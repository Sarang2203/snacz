package com.shark.snacz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductItem> productItems;

    public ProductAdapter(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.description_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Check if the position is within the bounds of the list
        if (position >= 0 && position < productItems.size()) {
            ProductItem productItem = productItems.get(position);

            // Set data to views
            holder.nameTextView.setText(productItem.getName());
            holder.descriptionTextView.setText(productItem.getDescription());
            holder.priceTextView.setText(String.valueOf(productItem.getPrice()));
        }
    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        TextView priceTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views in your product_item.xml here if needed
            nameTextView = itemView.findViewById(R.id.product_name);
            descriptionTextView = itemView.findViewById(R.id.product_description);
            priceTextView = itemView.findViewById(R.id.product_price);
        }
    }
}
