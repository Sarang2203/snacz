package com.shark.snacz;
import com.shark.snacz.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItems; // Replace CartItem with your actual data model

    public CartAdapter(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_card, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.productName.setText(cartItem.getProductName());
        holder.smallDescription.setText(cartItem.getSmallDescription());
        holder.productPrice.setText("Price: $" + cartItem.getProductPrice());
        // You can bind more data if needed

        // Example for setting the initial selection in the Spinner
        holder.quantitySpinner.setSelection(cartItem.getSelectedQuantityIndex());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView productName, smallDescription, productPrice;
        Spinner quantitySpinner;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            smallDescription = itemView.findViewById(R.id.smallDescription);
            productPrice = itemView.findViewById(R.id.productPrice);
            quantitySpinner = itemView.findViewById(R.id.quantitySpinner);
        }
    }
}

