package com.shark.snacz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        // Dummy data for demonstration purposes
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Product 1", "Description 1", 19.99, 1));
        cartItems.add(new CartItem("Product 2", "Description 2", 29.99, 2));
        cartItems.add(new CartItem("Product 3", "Description 2", 29.99, 2));
        cartItems.add(new CartItem("Product 4", "Description 2", 29.99, 2));
        // Add more items as needed

        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CartAdapter cartAdapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(cartAdapter);

        // Assuming your next activity is named DetailsPageActivity
        final Intent intent = new Intent(this, DetailsActivity.class);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        // Assuming "imageView" is the ID of your ImageView defined in your layout XML
        ImageView backButton = findViewById(R.id.imageView);

        // Set a click listener for the backButton
        backButton.setOnClickListener(view -> onBackPressed());
    }
}
