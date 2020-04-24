package com.example.orderapp.models;

public class Order {

    private int quantity;
    private double pricePerItem;

    public Order() {
        quantity = 1;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {
        if (quantity > 1)
            quantity--;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return quantity * pricePerItem;
    }
}
