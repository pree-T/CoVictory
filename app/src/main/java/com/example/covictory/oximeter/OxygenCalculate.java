package com.example.covictory.oximeter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covictory.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OxygenCalculate extends AppCompatActivity {
    private String Date;
    @SuppressLint("SimpleDateFormat")
    DateFormat df=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today= Calendar.getInstance().getTime();
    int o2;String errmsg="Place your finger properly and try again";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_calculate);
        Date =df.format(today);
        TextView Ro2=this.findViewById(R.id.o2r);
       // Button So2=this.findViewById(R.id.SendO2);




        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            o2=bundle.getInt("o2r");
            if(o2==0)
                Ro2.setText(errmsg);
            else
             Ro2.setText(String.valueOf(o2));
        }
        /*So2.setOnClickListener(v -> {
            Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_SUBJECT,"Oxygen Meter");
            i.putExtra(Intent.EXTRA_TEXT,"Oxygen Level \n"+"at "+Date+" is "+o2);
            try {
                startActivity(Intent.createChooser(i,"SEND..."));
            }
            catch(android.content.ActivityNotFoundException e)
            {
                Toast.makeText(this,"No sharing apps installed on this device",Toast.LENGTH_SHORT).show();
            }


        });*/

    }
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(OxygenCalculate.this, MainActivity2.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}