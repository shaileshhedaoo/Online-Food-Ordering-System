package model;

import Interfaces.*;

import java.util.*;

import Exception.*;

import static Repositry.RestaurantManagement.restaurantMap;

public class OrderingSystem implements MenuRepositary {
    private List<MenuItem> menus;
    private Map<MenuItem,Integer> cart;
    Scanner sc=new Scanner(System.in);
    static int i=0;

    public OrderingSystem() {
        this.menus = new ArrayList<>();
        this.cart=new HashMap<>();
    }

    public void addMenu(MenuItem menu) {
        menus.add(menu);
    }

    //Displaying Available Restaurant

    public void displayRestaurant(){
        System.out.println("Available Restaurants:");

        for(Map.Entry<String, Restaurant> entry: restaurantMap.entrySet()){
            Restaurant rest=entry.getValue();
            if(rest.isActive()){
                System.out.println(i+". "+entry.getKey());
                i++;
            }
        }
        System.out.println("Filter Options:: \n 1.Cusine Type \n 2.Location");
        int opt=sc.nextInt();
        if(opt==1){
            System.out.println("cusine type: \n 1.VEG \n 2.NON-VEG \n 3.VEGAN");
            String cusType=sc.next();
            browseMenusByCuisine(cusType);
        }
        else{
            System.out.println("Enter the location: ");
            String loc=sc.next();
            browseMenusByLocation(loc);
        }

    }

    public void browseMenusByCuisine(String cusineType){
        i=0;
        for(Map.Entry<String, Restaurant> entry: restaurantMap.entrySet()){
            Restaurant rest=entry.getValue();
            if(rest.getCuisineType()==cusineType){
                System.out.println(i+". "+entry.getKey()+" Item:"+ rest.getMenuItems());
                i++;
            }
        }

    }

    private static void browseMenusByLocation(String loc) {
        System.out.println("d");
    }



//Browse menu by cuisine type
//    public static void List<Menu> browseMenusByCuisine(String cuisineType) {
//        List<Menu> filteredMenus = new ArrayList<>();
//        for (Menu menu : menus) {
//            if (menu.getCuisineType().equalsIgnoreCase(cuisineType)) {
//                filteredMenus.add(menu);
//            }
//        }
//        return filteredMenus;
//    }


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
