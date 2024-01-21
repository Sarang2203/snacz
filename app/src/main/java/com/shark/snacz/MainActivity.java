package com.shark.snacz;

import android.content.Intent;  // Add this import statement
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // Initialize RecyclerView for Category
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
                Intent intent = new Intent(MainActivity.this, ProductPageActivity.class);
                intent.putExtra("category", categoryItem.getText());
                startActivity(intent);
            }
        });

        LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryRecyclerView.setLayoutManager(categoryLayoutManager);


        // Initialize RecyclerView for Description
        RecyclerView descriptionRecyclerView = findViewById(R.id.descriptionRecyclerView);
        DescriptionAdapter descriptionAdapter = new DescriptionAdapter();
        LinearLayoutManager descriptionLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        descriptionRecyclerView.setAdapter(descriptionAdapter);
        descriptionRecyclerView.setLayoutManager(descriptionLayoutManager);

        // Initialize NavbarHandler and set click listeners
        View navBarView = findViewById(R.id.navBar);
        NavbarHandler navbarHandler = new NavbarHandler(this);
        navbarHandler.setNavbarClickListeners(navBarView);
    }
}
