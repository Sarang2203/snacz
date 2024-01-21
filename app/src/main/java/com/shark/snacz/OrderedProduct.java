package com.shark.snacz;

public class OrderedProduct {

    private String productName;
    private String productDescription;
    private String productPrice;

    public OrderedProduct(String productName, String productDescription, String productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
