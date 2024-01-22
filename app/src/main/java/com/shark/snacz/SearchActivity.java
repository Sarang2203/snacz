package com.shark.snacz;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        // Add any initialization code for your profile activity here

        // Assuming "imageView" is the ID of your ImageView defined in your layout XML
        ImageView backButton = findViewById(R.id.imageView);

        // Set a click listener for the backButton
        backButton.setOnClickListener(view -> onBackPressed());
    }
}
