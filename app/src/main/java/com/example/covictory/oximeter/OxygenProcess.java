package com.example.covictory.oximeter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covictory.R;
import com.example.covictory.oximeter.Math.Fft;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

public class OxygenProcess extends AppCompatActivity {

    private static final String TAG="OxygenMeasure";
    private static final AtomicBoolean processing=new AtomicBoolean(false);

    private static  Camera camera=null;
    private static SurfaceHolder previewHolder=null;
    private static PowerManager.WakeLock wakeLock=null;

    private ProgressBar ProgO2;
    public int ProgP=0;
    public int inc=0;
    private static long startTime=0;
    double Stdr=0;
    double Stdb=0;
    double sumred =0;
    double sumblue=0;
    public int o2;
    public ArrayList<Double> RedAvgList= new ArrayList<>();
    public ArrayList<Double> BlueAvgList= new ArrayList<>();
    public int counter=0;

    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_process);

        SurfaceView preview = findViewById(R.id.preview);
        previewHolder= preview.getHolder();
        previewHolder.addCallback(surfaceCallBack);
        previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        ProgO2 = findViewById(R.id.o2pb);
        ProgO2.setProgress(0);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "NOTDIMSCREEN");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wakeLock.acquire(10*60*1000L /*10 minutes*/);
        camera=Camera.open();
        camera.setDisplayOrientation(90);
        startTime=System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wakeLock.release();
        camera.setPreviewCallback(null);
        camera.stopPreview();
        camera.release();
        camera=null;

    }
    private final Camera.PreviewCallback previewCallback= new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
            if (data==null) throw new NullPointerException();
            Camera.Size size=camera.getParameters().getPreviewSize();
            if(size==null)throw new NullPointerException();
            if(!processing.compareAndSet(false,true))return;
            int width=size.width;
            int height=size.height;
            double RedAvg;
            double BlueAvg;

            RedAvg=ImageProcessing.colordecoderRGB(data.clone(),height,width,1);
            sumred+=RedAvg;
            BlueAvg=ImageProcessing.colordecoderRGB(data.clone(),height,width,2);
            sumblue+=BlueAvg;
            RedAvgList.add(RedAvg);
            BlueAvgList.add(BlueAvg);
            ++counter;

            if(RedAvg<200)
            {
                inc=0;
                ProgP=inc;
                ProgO2.setProgress(ProgP);
                processing.set(false);
            }


            long endTime=System.currentTimeMillis();
            double totalTimeInSecs=(endTime-startTime)/1000d;
            if(totalTimeInSecs>=30)
            {
                startTime=System.currentTimeMillis();
                double samplingFreq = (counter / totalTimeInSecs);
                Double[] Red=RedAvgList.toArray(new Double[RedAvgList.size()]);
                Double[] Blue=BlueAvgList.toArray(new Double[BlueAvgList.size()]);
                double HRFreq= Fft.FFT(Red,counter, samplingFreq);
                double bpm=(int) ceil(HRFreq*60);
                double meanr=sumred/counter;
                double meanb=sumblue/counter;
                for(int i=0;i<counter-1;i++)
                {
                    Double bufferb=Blue[i];
                    Stdb+=((bufferb-meanb)*(bufferb-meanb));
                    Double bufferr=Red[i];
                    Stdr+=((bufferr-meanr)*(bufferr-meanr));
                }
                double varr=sqrt(Stdr/(counter-1));
                double varb=sqrt(Stdb/(counter-1));
                double R=(varr/meanr)/(varb/meanb);
                double spo2=100-5*R;
                o2=(int)(spo2);

                if(o2<80 || o2>99||(bpm<45 || bpm>200))
                {
                    inc=0;
                    ProgP=inc;
                    ProgO2.setProgress(ProgP);
                    Toast mainToast = Toast.makeText(getApplicationContext(), "Measurement Failure ,showing previous reading", Toast.LENGTH_LONG);
                    mainToast.show();
                    startTime=System.currentTimeMillis();
                    counter=0;
                    processing.set(false);
                    return;
                }

            }

            if(o2!=0)
            {
                Intent i=new Intent(OxygenProcess.this,OxygenCalculate.class);
                i.putExtra("o2r",o2);
                startActivity(i);
                finish();
            }
            if(RedAvg!=0)
            {
                ProgP=inc++/34;
                ProgO2.setProgress(ProgP);
            }
            processing.set(false);


        }
    };
    private final SurfaceHolder.Callback surfaceCallBack= new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) {
            try {
                camera.setPreviewDisplay(previewHolder);
                camera.setPreviewCallback(previewCallback);
            }
            catch(Throwable t)
            {
                Log.d(TAG,"surfaceCreated: ",t);
            }

        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            Camera.Parameters parameters= camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            Camera.Size size=getSmallestPreview(width,height,parameters);
            if(size!=null)
            {
                parameters.setPreviewSize(size.width,size.height);
            }
            camera.setParameters(parameters);
            camera.startPreview();

        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

        }
    };

    private Camera.Size getSmallestPreview(int width, int height, Camera.Parameters parameters) {
        Camera.Size result=null;
        for(Camera.Size size: parameters.getSupportedPreviewSizes())
        {
            if(size.width<=width && size.height<=height)
            {
                if(result==null)
                {
                    result=size;
                }
                else
                {
                    int resultArea=size.width*result.height;
                    int newArea=size.width*size.height;
                    if(newArea<resultArea)
                        result=size;
                }
            }
        }
        return result;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(OxygenProcess.this,MainActivity2.class);
        startActivity(i);
        finish();
    }
}