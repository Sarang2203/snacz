package com.shark.snacz;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);

        // Initialize views
        ImageView backButton = findViewById(R.id.imageView);
        TextView headingTextView = findViewById(R.id.heading1);
        recyclerView = findViewById(R.id.descriptionRecyclerView);

        // Set the heading text (you can receive this from the intent)
        String category = getIntent().getStringExtra("category");
        headingTextView.setText(category);

        // Set up the RecyclerView with dummy data for demonstration
        List<ProductItem> productItems = new ArrayList<>();
        productItems.add(new ProductItem("Product 1", "Description 1", 19.99));
        productItems.add(new ProductItem("Product 2", "Description 2", 29.99));
        productItems.add(new ProductItem("Product 1", "Description 1", 19.99));
        productItems.add(new ProductItem("Product 2", "Description 2", 29.99));
        productItems.add(new ProductItem("Product 1", "Description 1", 19.99));
        productItems.add(new ProductItem("Product 2", "Description 2", 29.99));
        productItems.add(new ProductItem("Product 1", "Description 1", 19.99));
        productItems.add(new ProductItem("Product 2", "Description 2", 29.99));
        productItems.add(new ProductItem("Product 1", "Description 1", 19.99));
        productItems.add(new ProductItem("Product 2", "Description 2", 29.99));

        // Add more items as needed

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(productItems);
        recyclerView.setAdapter(productAdapter);

        // Handle back button click
        backButton.setOnClickListener(view -> onBackPressed());
    }
}
