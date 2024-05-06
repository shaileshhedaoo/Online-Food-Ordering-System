package controller;

import Repositry.RestaurantManagement;
import model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Admin {

    public static void main(String[] args) {

        RestaurantManagement restaurantManagement= new RestaurantManagement();
        List<MenuItem> mnu=new ArrayList<>();

//        Menu menu1 = new Menu("Restaurant A", "Italian");
//        menu1.addItem(new MenuItem("Spaghetti Carbonara", 10.99));
//        menu1.addItem(new MenuItem("Margherita Pizza", 8.99));

        restaurantManagement.addRestaurant("Restaurant1","VEG","Bengaulru", LocalTime.now(),LocalTime.now(),mnu,true);


        System.out.println(restaurantManagement);
        OrderingSystem orderingObject=new OrderingSystem();

        orderingObject.displayRestaurant();

        orderingObject.browseMenusByCuisine("VEG");




//        OrderingSystem orderingSystem = new OrderingSystem();
//        orderingSystem.addMenu(menu1);

    }



}
