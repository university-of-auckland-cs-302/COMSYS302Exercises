package com.example.orderapp.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int quantity;
    private double pricePerItem;
    private String username, orderMessage;
    private List<String> toppingsList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Order() {
        quantity = 1;
        toppingsList = new ArrayList<String>();
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


    public String getOrderMessage() {
        orderMessage =" Thank you for your order, "+username;
        orderMessage += "\nYour total price is: " + String.valueOf(getTotalPrice());

        if (toppingsList.size()>0)
        {
            orderMessage += "\n"+getToppingsString();
        }
        return orderMessage;
    }

    public void addTopping(String topping) {
        toppingsList.add(topping);
    }

    public String removeTopping(String topping) {
        return toppingsList.remove(toppingsList.indexOf(topping));
    }

    public String getToppingsString() {
        String toppingsString = "Your toppings are:\n";
        for (String topping : toppingsList)
            toppingsString += topping + "\n";

        return toppingsString;
    }


}
