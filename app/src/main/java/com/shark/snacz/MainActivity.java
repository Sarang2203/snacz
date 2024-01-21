package com.shark.snacz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // Initialize RecyclerView for Category
        RecyclerView categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        CategoryAdapter categoryAdapter = new CategoryAdapter();
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
