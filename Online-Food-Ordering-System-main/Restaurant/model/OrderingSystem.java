package model;

import Interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Exception.*;

public class OrderingSystem implements MenuRepositary {
    private List<Menu> menus;
    private Map<MenuItem,Integer> cart;

    public OrderingSystem() {
        this.menus = new ArrayList<>();
        this.cart=new HashMap<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
//Browse menu by cuisine type
    public List<Menu> browseMenusByCuisine(String cuisineType) {
        List<Menu> filteredMenus = new ArrayList<>();
        for (Menu menu : menus) {
            if (menu.getCuisineType().equalsIgnoreCase(cuisineType)) {
                filteredMenus.add(menu);
            }
        }
        return filteredMenus;
    }

    // Method to add items to the cart
    public void addToCart(MenuItem item, int quantity, String specialInstructions) {
        // Check if the item is already in the cart
        if (cart.containsKey(item)) {
            int existingQuantity = cart.get(item);
            cart.put(item, existingQuantity + quantity);
        } else {
            cart.put(item, quantity);
        }
        // You can add special instructions handling here if needed
        System.out.println(quantity + " " + item.getName() + "(s) added to cart.");
    }

    // Method to place an order
    public void placeOrder(String deliveryAddress, String paymentDetails) {

        // Implementation of placing an order goes here
        if(cart.isEmpty()){
            throw new RuntimeException("Cart is Empty..!!");
            //throw new EmptyCartException("Cart Is Empty..!! \n Please add Items Before Placing Order");
        }

        double totalAmount=0;

        for(Map.Entry<MenuItem,Integer> entry: cart.entrySet()){
            MenuItem item=entry.getKey();
            int quantity= entry.getValue();
            double cost=item.getPrice()*quantity;
            System.out.println("- " + item.getName() + ": ₹" + item.getPrice() + " x " + quantity + " = ₹" + cost);
            totalAmount+=cost;
        }
        System.out.println("Total Amount: ₹" + totalAmount);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Payment Details: " + paymentDetails);

        // Clear the cart after placing the order
        cart.clear();
        System.out.println("Your order has been placed successfully!");
    }
}
