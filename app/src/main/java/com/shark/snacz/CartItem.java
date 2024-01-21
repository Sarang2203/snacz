package com.shark.snacz;

// Import statements if needed

public class CartItem {
    private String productName;
    private String smallDescription;
    private double productPrice;
    private int selectedQuantityIndex;

    // Constructor
    public CartItem(String productName, String smallDescription, double productPrice, int selectedQuantityIndex) {
        this.productName = productName;
        this.smallDescription = smallDescription;
        this.productPrice = productPrice;
        this.selectedQuantityIndex = selectedQuantityIndex;
    }

    // Getter methods
    public String getProductName() {
        return productName;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getSelectedQuantityIndex() {
        return selectedQuantityIndex;
    }

    // You can add more setter methods if needed
}

