package Interfaces;

import model.MenuItem;

import java.util.List;

public interface MenuRepositary {

    void browseMenusByCuisine(String cuisineType);
    void addToCart(MenuItem item, int quantity, String specialInstructions);
    void placeOrder(String deliveryAddress, String paymentDetails);
}
