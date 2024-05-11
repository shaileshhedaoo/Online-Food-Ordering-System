package Repositry;
import Repository.RestaurantMethod;
import model.MenuItem;
import model.Restaurant;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManagement implements RestaurantMethod {
    public static Map<String, Restaurant> restaurantMap;
    public Map<String,List<MenuItem>> restaurantItemList;

    public RestaurantManagement() {
        this.restaurantMap = new HashMap<>();
        this.restaurantItemList=new HashMap<>();
    }

    @Override
    public void addRestaurant(String name, String cuisineType, String location, LocalTime openingTime, LocalTime closingTime, List<MenuItem> menuItems, boolean isActive)
    {

        try {
            if (!restaurantMap.containsKey(name)) {

                Restaurant restaurant = new Restaurant(name, cuisineType, location, openingTime, closingTime, menuItems, isActive);
                //this.name=name;
                restaurantMap.put(name,restaurant);


                System.out.println("Restaurant Added Successfully with name:- "+name);
                }
            }
        catch(RuntimeException e)
            {
                System.out.println("Restaurant with this name already exists.");
            }

    }

    //Update
    // User Story 2: Update restaurant details
    @Override
    public void updateRestaurant(String name, String cuisineType, String location) {

        try {
            if (restaurantMap.containsKey(name)) {
                Restaurant restaurant = restaurantMap.get(name);
                restaurant.setCuisineType(cuisineType);
                restaurant.setLocation(location);
                System.out.println("Restaurant details updated successfully.");
            }
        }
        catch (RuntimeException e) {
            System.out.println("Restaurant Not Found.");
        }
    }

    // User Story 3: Deactivate restaurant
    @Override
    public void deactivateRestaurant(String name) {
        if (restaurantMap.containsKey(name)) {
            Restaurant restaurant = restaurantMap.get(name);
            restaurant.setActive(false);
            System.out.println("Restaurant deactivated successfully.");
        } else {
            System.out.println("Restaurant not found.");
        }
    }


}



