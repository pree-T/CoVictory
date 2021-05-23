package com.example.covictory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.covictory.oximeter.MainActivity2;

public class MenuActivity extends AppCompatActivity {


    LinearLayout covid, food,oximeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        covid = findViewById(R.id.covid_symptoms);
        food = findViewById(R.id.food);
        oximeter = findViewById(R.id.oximeter);

        covid.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, Covid.class);
            startActivity(intent);
        });
        food.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, Food.class);
            startActivity(intent);
        });
        oximeter.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}