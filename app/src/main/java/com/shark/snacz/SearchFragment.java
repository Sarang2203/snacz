package com.shark.snacz;

import android.os.Bundle;
import android.util.Log;  // Add this import statement
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView searchResultsRecyclerView;
    private SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search, container, false);
        Log.d("SearchFragment", "onCreateView");

        // Initialize RecyclerView
        searchResultsRecyclerView = view.findViewById(R.id.searchResultsRecyclerView);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set up SearchAdapter with an empty list
        searchAdapter = new SearchAdapter(new ArrayList<>());
        searchResultsRecyclerView.setAdapter(searchAdapter);

        // Set up SearchView listener
        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search based on the query and update the RecyclerView
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Perform search based on the updated query and update the RecyclerView
                performSearch(newText);
                return true;
            }
        });

        return view;
    }

    private void performSearch(String query) {
        // Implement your logic to fetch search results based on the query
        List<SearchItem> searchResults = getSearchResults(query);

        // Update the RecyclerView with the new search results only if there's a change
        if (!searchResults.equals(searchAdapter.getSearchResults())) {
            searchAdapter.setSearchResults(searchResults);
            searchAdapter.notifyDataSetChanged();
        }
    }

    private List<SearchItem> getSearchResults(String query) {
        // Implement your logic to fetch search results based on the query
        // For testing purposes, return a predefined list of fake data
        List<SearchItem> searchResults = new ArrayList<>();
        searchResults.add(new SearchItem("Fake Result 1"));
        searchResults.add(new SearchItem("Fake Result 2"));
        searchResults.add(new SearchItem("Fake Result 3"));
        return searchResults;
    }
}
