package com.shark.snacz; // Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // Initialize views
        RecyclerView categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        // Set up dummy data for demonstration
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Donut", R.drawable.donut));
        categoryItems.add(new CategoryItem("Pizza", R.drawable.pizza));
        // Add more items as needed

        // Set up the RecyclerView with the CategoryAdapter
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryItems, new CategoryAdapter.OnCategoryClickListener() {
            @Override
            public void onCategoryClick(CategoryItem categoryItem) {
                // Handle the category card click here
                // Open the ProductPageActivity with the selected category
                Intent intent = new Intent(HomeActivity.this, ProductPageActivity.class);
                intent.putExtra("category", categoryItem.getText());
                startActivity(intent);
            }
        });
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
}

