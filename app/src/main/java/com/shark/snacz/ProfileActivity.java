package com.shark.snacz;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        // Assuming you have a List<OrderedProduct> to represent your data
        List<OrderedProduct> orderedProducts = generateOrderedProducts();

        // Find the RecyclerView in your activity
        RecyclerView recyclerView = findViewById(R.id.orderHistoryRecyclerView);

        // Create and set up the adapter
        OrderHistoryAdapter adapter = new OrderHistoryAdapter(orderedProducts);
        recyclerView.setAdapter(adapter);

        // Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Assuming "imageView" is the ID of your ImageView defined in your layout XML
        ImageView backButton = findViewById(R.id.imageView);

        // Set a click listener for the backButton
        backButton.setOnClickListener(view -> onBackPressed());
    }

    private List<OrderedProduct> generateOrderedProducts() {
        List<OrderedProduct> products = new ArrayList<>();
        // Populate your data here
        products.add(new OrderedProduct("Donut", "Sparkel Donut", "Rs.200"));
        products.add(new OrderedProduct("Donut", "Sparkel Donut", "Rs.200"));
        products.add(new OrderedProduct("Donut", "Sparkel Donut", "Rs.200"));
        products.add(new OrderedProduct("Donut", "Sparkel Donut", "Rs.200"));
        products.add(new OrderedProduct("Donut", "Sparkel Donut", "Rs.200"));
        products.add(new OrderedProduct("Donut", "Sparkel Donut", "Rs.200"));

        // Add more products as needed
        return products;
    }
}
