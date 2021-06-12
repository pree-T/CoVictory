package com.example.covictory;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covictory.databinding.ActivityOxygenBinding;

import java.util.ArrayList;

public class Oxygen extends AppCompatActivity {

    ActivityOxygenBinding binding;
    ArrayList<String> state;


    ArrayList<String> city_jhar;
    ArrayList<String> city_wb;
    ArrayList<String> city_bihar;
    ArrayAdapter<String> state_adapter;
    ArrayAdapter<String> city;
    DbHelperOxygen db;
    RecyclerView recyclerView;
    ArrayList<ModelClass> dataholder = new ArrayList<>();
    public String city_name, state_name;

    public Button search_btn;


    Spinner spinner_state, spinner_city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOxygenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        spinner_state = findViewById(R.id.spinner_state);
        spinner_city = findViewById(R.id.spinner_city);

        search_btn = findViewById(R.id.search_button);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adding_values_to_arrays();
        load_initial();

        binding.spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    city = new ArrayAdapter<>(Oxygen.this, R.layout.district, city_jhar);
                } else if (position == 1) {
                    city = new ArrayAdapter<>(Oxygen.this, R.layout.district, city_bihar);
                } else if (position == 2) {
                    city = new ArrayAdapter<>(Oxygen.this, R.layout.district, city_wb);
                }
                binding.spinnerCity.setAdapter(city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        db = new DbHelperOxygen(this);
        db.addNewData();

        search_btn.setOnClickListener(v -> {
            dataholder.clear();
            state_name = spinner_state.getSelectedItem().toString();
            city_name = spinner_city.getSelectedItem().toString();
            viewData(state_name, city_name);

        });


    }

    private void viewData(String state_name, String city_name) {
        Cursor cursor = new DbHelperOxygen(this).viewData();
        while (cursor.moveToNext()) {
            if (cursor.getString(0).equals(state_name) && cursor.getString(1).equals(city_name)) {
                ModelClass obj = new ModelClass(cursor.getString(2), cursor.getString(3), cursor.getString(4));
                dataholder.add(obj);
            }

        }
        myadapter adapter = new myadapter(dataholder);
        recyclerView.setAdapter(adapter);

    }

    void adding_values_to_arrays() {
        state = new ArrayList<>();
        state.add("Jharkhand");
        state.add("Bihar");
        state.add("WestBengal");


        city_jhar = new ArrayList<>();
        city_jhar.add("Jamshedpur");
        city_jhar.add("Dhanbad");
        city_jhar.add("Ranchi");
        city_jhar.add("Bokaro");

        city_wb = new ArrayList<>();
        city_wb.add("Asansoal");
        city_wb.add("Baranagar");
        city_wb.add("Durgapur");
        city_wb.add("Kolakata");
        city_wb.add("Purulia");
        city_wb.add("Krishnanagar");
        city_wb.add("Kolakata");
        city_wb.add("North 24 Parganas");
        city_wb.add("Siliguri");




        city_bihar = new ArrayList<>();
        city_bihar.add("Patna");
        city_bihar.add("Begusarai");
        city_bihar.add("Bhagalpur");
        city_bihar.add("Buxar");
        city_bihar.add("Champaran");
        city_bihar.add("Darbhanga");
        city_bihar.add("Gaya");
        city_bihar.add("Gopalganj");
        city_bihar.add("Muzaffarpur");




    }

    void load_initial() {
        state_adapter = new ArrayAdapter<>(Oxygen.this, R.layout.state, state);
        binding.spinnerState.setAdapter(state_adapter);
        city = new ArrayAdapter<>(Oxygen.this, R.layout.city, city_jhar);
        binding.spinnerCity.setAdapter(city);


    }
}
