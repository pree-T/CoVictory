package com.example.covictory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.covictory.oximeter.MainActivity2;

public class MenuActivity extends AppCompatActivity {


    LinearLayout beds,oximeter,oxygen,medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        beds = findViewById(R.id.beds);

        oximeter = findViewById(R.id.oximeter);
        oxygen=findViewById(R.id.oxygen);
        medicine=findViewById(R.id.medicines);

        beds.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, Beds.class);
            startActivity(intent);
        });

        oxygen.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, Oxygen.class);
            startActivity(intent);
        });
        medicine.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, Medicine.class);
            startActivity(intent);
        });
        oximeter.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}