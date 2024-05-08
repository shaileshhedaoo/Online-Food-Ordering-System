package controller;

import model.Customer;
import model.Order;
import model.OrderTracker;

public class OrderTrackerController {
    public static void main(String[] args) {
        // Create some sample orders
        Order order1 = new Order(1, "123 Main St, City A", "123-456-7890");
        Order order2 = new Order(2, "456 Elm St, City B", "987-654-3210");

        // Create some sample customers
        Customer customer1 = new Customer(1,"Alice","Bengaluru","alice@example.com");
        Customer customer2 = new Customer(2,"Bob","Nagpur" ,"bob@example.com");

        // Create an OrderTracker instance
        OrderTracker orderTracker = new OrderTracker();

        // Update order statuses
        orderTracker.orderStatusMap.put(1, "Picked Up");
        orderTracker.orderStatusMap.put(2, "En Route");

        System.out.println("=================== Tracking the order for the Customers =================");
        // Track order status for customer1
        String status1 = orderTracker.trackOrderStatus(order1.getOrderId());
        System.out.println("Order Status for Customer " + customer1.getCustomerName() + ": " + status1);

        // Track order status for customer2
        String status2 = orderTracker.trackOrderStatus(order2.getOrderId());
        System.out.println("Order Status for Customer " + customer2.getCustomerName() + ": " + status2);

        System.out.println("=================== Sending notifications to customers =================");
        // Send notifications to customers
        orderTracker.sendNotification(customer1, "Your order is on its way!");
        orderTracker.sendNotification(customer2, "Your order has been picked up!");
    }
}

