package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String restaurantName;
    private String cuisineType;
    private List<MenuItem> items;

    public Menu(String restaurantName, String cuisineType) {
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.items = new ArrayList<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
