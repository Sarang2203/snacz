package com.shark.snacz;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_page);

        // Declare Spinners
        Spinner auditoriumDropdown = findViewById(R.id.auditoriumDropdown);
        Spinner rowDropdown = findViewById(R.id.rowDropdown);
        Spinner seatNoDropdown = findViewById(R.id.seatNoDropdown);

        // Declare and populate values for each dropdown
        List<String> auditoriums = new ArrayList<>();
        auditoriums.add("1");
        auditoriums.add("2");
        auditoriums.add("3");
        auditoriums.add("4");
        auditoriums.add("5");

        // Add more auditoriums as needed

        List<String> rows = new ArrayList<>();
        rows.add("A");
        rows.add("B");
        rows.add("C");
        rows.add("D");
        rows.add("E");
        rows.add("F");

        // Add more rows as needed

        List<String> seatNos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            seatNos.add(String.valueOf(i));
        }

        // Create adapters
        ArrayAdapter<String> auditoriumAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, auditoriums);
        ArrayAdapter<String> rowAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rows);
        ArrayAdapter<String> seatNoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, seatNos);

        // Set adapters to Spinners
        auditoriumDropdown.setAdapter(auditoriumAdapter);
        rowDropdown.setAdapter(rowAdapter);
        seatNoDropdown.setAdapter(seatNoAdapter);
    }
}
