package com.example.covictory;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covictory.api.ApiUtilities;
import com.example.covictory.api.CountryData;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView totalConfirm, todayConfirm, totalDeaths, todayDeaths, totalActive, totalRecover, todayRecover, tests,updateDate;
    Button morebtn;
    private PieChart pieChart;
    private List<CountryData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<>();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait,fetching data for you");
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialog.show();
        progressDialog.setCancelable(false);


        init();

        ApiUtilities.getApiInterface().getCountryData().enqueue(new Callback<List<CountryData>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<List<CountryData>> call, @NonNull Response<List<CountryData>> response) {
                assert response.body() != null;
                list.addAll(response.body());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCountry().equals("India")) {
                        int confirm = Integer.parseInt(list.get(i).getCases());
                        int active = Integer.parseInt(list.get(i).getActive());
                        int recovered = Integer.parseInt(list.get(i).getRecovered());
                        int deaths = Integer.parseInt(list.get(i).getDeaths());
                        totalActive.setText(NumberFormat.getInstance().format(active));
                        totalDeaths.setText(NumberFormat.getInstance().format(deaths));
                        totalRecover.setText(NumberFormat.getInstance().format(recovered));
                        totalConfirm.setText(NumberFormat.getInstance().format(confirm));





                        todayDeaths.setText("+"+NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayDeaths())));
                        todayConfirm.setText("+"+NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayCases())));
                        todayRecover.setText("+"+NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayRecovered())));
                        tests.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTests())));



                        DateText(list.get(i).getUpdated());


                        pieChart.addPieSlice(new PieModel("Confirm", confirm, getResources().getColor(R.color.yellow)));
                        pieChart.addPieSlice(new PieModel("Active", active, getResources().getColor(R.color.blue_pie)));
                        pieChart.addPieSlice(new PieModel("Recovered", recovered, getResources().getColor(R.color.green_pie)));
                        pieChart.addPieSlice(new PieModel("Deaths", deaths, getResources().getColor(R.color.red_pie)));
                    }
                }
                progressDialog.dismiss();


                morebtn.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                });

            }

            @Override
            public void onFailure(@NonNull Call<List<CountryData>> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                Toast.makeText(MainActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();

                //Setting the title manually

                builder.setMessage("Please Check your Internet Connection and try again")
                .setCancelable(false)
                .setPositiveButton("Yes Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No,thanks!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();

                    }
                });
                builder.show();


            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void DateText(String updated)
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format= new SimpleDateFormat("MMM dd, yyyy");
        long milliseconds=Long.parseLong(updated);
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        updateDate.setText("Updated at "+format.format(calendar.getTime()));
    }

    private void init() {
        totalConfirm = findViewById(R.id.totalConfirm);
        todayConfirm = findViewById(R.id.todayConfirm);
        totalDeaths = findViewById(R.id.totalDeaths);
        todayDeaths = findViewById(R.id.todayDeaths);
        totalActive = findViewById(R.id.totalActive);
        totalRecover = findViewById(R.id.totalRecover);
        todayRecover = findViewById(R.id.todayRecover);
        tests = findViewById(R.id.Tests);
        pieChart = findViewById(R.id.pieChart);
        updateDate=findViewById(R.id.updateTime);
        morebtn=findViewById(R.id.btn);
    }
}