package Interfaces;

import model.MenuItem;
import model.ConcreteRestaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    public List<ConcreteRestaurant> restaurants;

    public RestaurantRepositoryImpl() {
        this.restaurants = new ArrayList<>();
    }

    @Override
    public void addRestaurant(ConcreteRestaurant Concreterestaurant) {
        restaurants.add(Concreterestaurant);
    }

    @Override
    public void setActivationStatus(boolean status) {
        for (ConcreteRestaurant restaurant : restaurants) {
            restaurant.setActive(status);
        }
    }

    @Override
    public void updateMenuItem(MenuItem item) {
        for (ConcreteRestaurant restaurant : restaurants) {
            List<MenuItem> menuItems = restaurant.getMenuItems();
            for (MenuItem menuItem : menuItems) {
                if (menuItem.getId() == item.getId()) {
                    menuItem.setName(item.getName());
                    menuItem.setPrice(item.getPrice());
                    menuItem.setDescription(item.getDescription());
                }
            }
        }
    }

    @Override
    public ConcreteRestaurant getRestaurantById(long id) {
        for (ConcreteRestaurant restaurant : restaurants) {
            if (restaurant.getRestaurantId() == id) {
                return restaurant;
            }
        }
        return null;
    }

    @Override
    public List<ConcreteRestaurant> findRestaurantByLocation(String location) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    @Override
    public List<ConcreteRestaurant> findRestaurantByName(String name) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<ConcreteRestaurant> findRestaurantByType(String CuisineType) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getCuisineType() == CuisineType)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConcreteRestaurant> findAllActiveRestaurant() {
        return restaurants.stream()
                .filter(ConcreteRestaurant::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConcreteRestaurant> findAllDeactivatedRestaurant() {
        return restaurants.stream()
                .filter(restaurant -> !restaurant.isActive())
                .collect(Collectors.toList());
    }
}
