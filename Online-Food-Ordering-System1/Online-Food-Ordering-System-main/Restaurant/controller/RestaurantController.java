package controller;

import model.ConcreteRestaurant;
import model.MenuItem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class RestaurantController {

    public static void main(String[] args) {
        // Creating menu items
        MenuItem pizza = new MenuItem(1, "Pizza", 9.99, 3.4,"Delicious pizza with cheese and toppings");
        MenuItem pasta = new MenuItem(2, "Pasta", 12.99, 5.6,"Spaghetti with tomato sauce and meatballs");

        // Creating a restaurant
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(pizza);
        menuItems.add(pasta);

        ConcreteRestaurant restaurant = new ConcreteRestaurant(1, "Italiano Delight", "ITALIAN",
                "123 Main Street", LocalTime.of(11, 0), LocalTime.of(21, 0),
                menuItems, true);

        // Displaying restaurant information
        System.out.println("=============== Displaying Restaurant Information: ==================");
        System.out.println(restaurant);

        // Checking if the restaurant is open at different times
        LocalTime currentTime = LocalTime.of(12, 0);
        System.out.println("Is the restaurant open at " + currentTime + "? " + restaurant.isOpen(currentTime));

        currentTime = LocalTime.of(22, 0);
        System.out.println("Is the restaurant open at " + currentTime + "? " + restaurant.isOpen(currentTime));

        // Adding a new menu item
        MenuItem salad = new MenuItem(3, "Caesar Salad", 7.99, 2.5,"Fresh greens with Caesar dressing");
        restaurant.addMenuItem(salad);
        System.out.println("================== Displaying Menu Items after adding salad: =================");
        for (MenuItem item : restaurant.getMenuItems()) {
            System.out.println(item);
        }
        // Removing a menu item
        restaurant.removeMenuItem(pasta);
        System.out.println("=================== Displaying Menu Items after removing pasta: ===============");
        for (MenuItem item : restaurant.getMenuItems()) {
            System.out.println(item);
        }

    }
}

