package com.shark.snacz; // Replace with your actual package name

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<CategoryItem> categoryItems;
    private Context context;
    private OnCategoryClickListener onCategoryClickListener;

    public CategoryAdapter(Context context, List<CategoryItem> categoryItems, OnCategoryClickListener listener) {
        this.context = context;
        this.categoryItems = categoryItems;
        this.onCategoryClickListener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryItem categoryItem = categoryItems.get(position);

        holder.textView.setText(categoryItem.getText());
        holder.headerImage.setImageResource(categoryItem.getImageResource());

        // Set OnClickListener for the entire card
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event here
                // Pass the clicked CategoryItem to the listener
                onCategoryClickListener.onCategoryClick(categoryItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView headerImage;
        TextView textView;
        CardView cardView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            headerImage = itemView.findViewById(R.id.header_image);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    // Interface to handle category clicks
    public interface OnCategoryClickListener {
        void onCategoryClick(CategoryItem categoryItem);
    }
}
