package com.shark.snacz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {

    private List<OrderedProduct> orderedProducts;

    public OrderHistoryAdapter(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_product_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderedProduct orderedProduct = orderedProducts.get(position);

        // Bind data to views in order_product_card.xml
        holder.productNameTextView.setText(orderedProduct.getProductName());
        holder.productDescriptionTextView.setText(orderedProduct.getProductDescription());
        holder.productPriceTextView.setText(orderedProduct.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return orderedProducts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTextView;
        TextView productDescriptionTextView;
        TextView productPriceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.textView);
            productDescriptionTextView = itemView.findViewById(R.id.textView2);
            productPriceTextView = itemView.findViewById(R.id.textView3);
        }
    }
}

