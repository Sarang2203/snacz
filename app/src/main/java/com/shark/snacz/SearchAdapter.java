package com.shark.snacz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<SearchItem> searchResults;

    public SearchAdapter(List<SearchItem> searchResults) {
        this.searchResults = searchResults;
    }

    public void setSearchResults(List<SearchItem> searchResults) {
        this.searchResults = searchResults;
        notifyDataSetChanged();
    }

    public List<SearchItem> getSearchResults() {
        return searchResults;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_layout, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchItem searchItem = searchResults.get(position);
        // Bind the data to your ViewHolder's views
        holder.bind(searchItem);
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        private TextView itemNameTextView;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.item_name_textview); // Replace with the actual ID of your TextView
        }

        public void bind(SearchItem searchItem) {
            itemNameTextView.setText(searchItem.getName());
            // Bind other data as needed
        }
    }
}
