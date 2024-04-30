package controller;

import Repositry.RestaurantManagement;

public class Admin {

    public static void main(String[] args) {

        RestaurantManagement restaurantManagement= new RestaurantManagement();
        restaurantManagement.addRestaurant("Restaurant1","Indian","Bengaulru");

        System.out.println(restaurantManagement);
    }



}
