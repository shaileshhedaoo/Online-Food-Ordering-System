package Interfaces;

import model.MenuItem;

import java.time.LocalTime;
import java.util.List;

public interface RestaurantMethod {

    void addRestaurant(String name, String cuisineType, String location, LocalTime openingTime, LocalTime closingTime, List<MenuItem> menuItems, boolean isActive);
    void updateRestaurant(String name, String cuisineType, String location);
    void deactivateRestaurant(String name);

}
