package com.shark.snacz;

import android.os.Bundle;
import android.widget.ImageView;  // Import the ImageView class
import androidx.appcompat.app.AppCompatActivity;

public class OfferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer);

        // Assuming "imageView" is the ID of your ImageView defined in your layout XML
        ImageView backButton = findViewById(R.id.imageView);

        // Set a click listener for the backButton
        backButton.setOnClickListener(view -> onBackPressed());


    }
}
