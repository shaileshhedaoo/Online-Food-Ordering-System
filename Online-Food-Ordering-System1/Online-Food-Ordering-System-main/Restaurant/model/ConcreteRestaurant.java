package model;
import java.time.LocalTime;
import java.util.List;

public class ConcreteRestaurant {

    private long restaurantId;
    private String name;
    private String cuisineType;
    private String location;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<MenuItem> menuItems;
    private boolean isActive;

    // Constructor
    public ConcreteRestaurant(long restaurantId, String name, String cuisineType, String location, LocalTime openingTime, LocalTime closingTime, List<MenuItem> menuItems, boolean isActive) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.menuItems = menuItems;
        this.isActive = isActive;
    }

    public ConcreteRestaurant(String name,String cuisineType,String location){
        this.name=name;
        this.cuisineType=cuisineType;
        this.location=location;
    }
    // Getters and Setters
    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Additional Methods

    // Method to check if the restaurant is open at a given time
    public boolean isOpen(LocalTime time) {
        return !time.isBefore(openingTime) && !time.isAfter(closingTime);
    }

    // Method to add a menu item
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    // Method to remove a menu item
    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
    }


    // Method to display the menu of the restaurant
    public void displayMenu() {
        System.out.println("Menu Items:");
        for (MenuItem item : menuItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            System.out.println("Description: " + item.getDescription());
        }
    }

    // Method to display basic information about the restaurant
    public void displayBasicInfo() {
        System.out.println("Restaurant Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Cuisine Type: " + cuisineType);
        System.out.println("Opening Time: " + openingTime);
        System.out.println("Closing Time: " + closingTime);
        System.out.println("Active Status: " + isActive);
    }

    // Method to display detailed information about the restaurant
    public void displayDetailedInfo() {
        displayBasicInfo();
        System.out.println();
        displayMenu();
    }

    // Method to display restaurant information
    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", cuisineType=" + cuisineType +
                ", location='" + location + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", menuItems=" + menuItems +
                ", isActive=" + isActive +
                '}';
    }
}
