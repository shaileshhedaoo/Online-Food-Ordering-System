package controller;
import model.*;

import java.time.LocalTime;
import java.util.*;
public class OrderingSystemController {
        public static void main(String[] args) {
            // Create sample menu items
            MenuItem menuItem1 = new MenuItem(1, "Pizza", 9.99, 3.4,"Delicious pizza with cheese and toppings");
            MenuItem menuItem2 = new MenuItem(2, "Pasta", 12.99, 5.6,"Spaghetti with tomato sauce and meatballs");

            List<MenuItem> menuItems = new ArrayList<>();
            menuItems.add(menuItem1);
            menuItems.add(menuItem2);

            // Create sample restaurant
            ConcreteRestaurant restaurant = new ConcreteRestaurant(1, "Italiano Delight", "ITALIAN",
                    "123 Main Street", LocalTime.of(11, 0), LocalTime.of(21, 0),
                    menuItems, true);

            restaurant.addMenuItem(menuItem1);
            restaurant.addMenuItem(menuItem2);

            System.out.println("================ Checking the Available Restaurants =================");
            // Create an ordering system
            OrderingSystem orderingSystem = new OrderingSystem();

            // Add menu items to the ordering system
            orderingSystem.addMenu(menuItem1);
            orderingSystem.addMenu(menuItem2);

            // Display available restaurants
            List<ConcreteRestaurant> restaurants = new ArrayList<>();
            restaurants.add(restaurant);
            OrderingSystem.displayAvailableRestaurants(restaurants);

            System.out.println("================= Browseing the Manu Based on Cuisine Type =================");
            // Browse menus by cuisine
            orderingSystem.browseMenusByCuisine(restaurants, "Italian");

            System.out.println("================= Adding ManuItems Into the Cart & Calculating the Prize Based on the Quantity ========================");
            // Add items to the cart
            orderingSystem.addToCart(menuItem1, 2, "Extra cheese");
            orderingSystem.addToCart(menuItem2, 1, "");

            // Place an order
            try {
                orderingSystem.placeOrder("456 Elm St", "Credit Card");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
}

