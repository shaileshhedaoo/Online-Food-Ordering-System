package controller;

import Repositry.RestaurantManagement;
import model.Menu;
import model.MenuItem;
import model.OrderingSystem;
import model.Restaurant;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static model.CustomerManagement.filterRestaurant;
import static model.CustomerManagement.printRest;

public class Admin {

    public static void main(String[] args) {

        RestaurantManagement restaurantManagement= new RestaurantManagement();
        List<MenuItem> mnu=new ArrayList<>();

//        Menu menu1 = new Menu("Restaurant A", "Italian");
//        menu1.addItem(new MenuItem("Spaghetti Carbonara", 10.99));
//        menu1.addItem(new MenuItem("Margherita Pizza", 8.99));

        restaurantManagement.addRestaurant("Restaurant1","Indian","Bengaulru", LocalTime.now(),LocalTime.now(),mnu,true);


        System.out.println(restaurantManagement);

        Scanner sc=new Scanner(System.in);
        printRest();

        System.out.println("FILTER OPTIONS:\n 1.CUSINE TYPE \n 2.LOCATION");

        int opt=sc.nextInt();
        filterRestaurant(opt);




//        OrderingSystem orderingSystem = new OrderingSystem();
//        orderingSystem.addMenu(menu1);

    }



}
