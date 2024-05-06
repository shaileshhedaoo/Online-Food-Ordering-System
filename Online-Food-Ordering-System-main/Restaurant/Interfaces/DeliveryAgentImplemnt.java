package Interfaces;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentImplemnt implements DeliveryAgent{

    private List<Order> assignedOrders;

    // Constructor
    public DeliveryAgentImplemnt() {
        this.assignedOrders = new ArrayList<>();
    }

    @Override
    public void viewPendingOrders() {

        for (Order order : assignedOrders) {
            if (order.getStatus().equals("Pending")) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Delivery Address: " + order.getDeliveryAddress());
                System.out.println("Contact Number: " + order.getContactNumber());

            }
        }

    }

    @Override
    public void updateOrderStatus(int orderId, String status) {
        for (Order order : assignedOrders) {
            if (order.getOrderId() == orderId) {
                order.setStatus(status);
                System.out.println("Order status updated successfully.");
                break;
            }
        }
    }
}
