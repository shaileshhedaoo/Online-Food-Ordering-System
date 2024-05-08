package controller;

import Interfaces.DeliveryAgentImpl;
import model.ConcreteRestaurant;
import model.MenuItem;
import model.Order;
import model.OrderingSystem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
                public static void main(String[] args) {
                    // Create some sample orders
                    Order order1 = new Order(1, "123 Main St, City A", "123-456-7890");
                    Order order2 = new Order(2, "456 Elm St, City B", "987-654-3210");
                    Order order3 = new Order(3, "789 Oak St, City C", "456-789-0123");

                    // Create a delivery agent
                    DeliveryAgentImpl deliveryAgent = new DeliveryAgentImpl();

                    // Assign orders to the delivery agent
                    deliveryAgent.AssignedOrders(order1);
                    deliveryAgent.AssignedOrders(order2);
                    deliveryAgent.AssignedOrders(order3);

                    // View pending orders
                    System.out.println("Pending Orders:");
                    deliveryAgent.viewPendingOrders();

                    // View updateOrderStatus
                    System.out.println("updateOrderStatus:");
                    deliveryAgent.updateOrderStatus(1,"Completed");

                }

}
