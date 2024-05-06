package model;

import java.util.HashMap;
import java.util.Map;

public class OrderTracker {
    private Map<Integer, String> orderStatusMap; // Map to track order status

    // Constructor
    public OrderTracker() {
        this.orderStatusMap = new HashMap<>();
    }

    // Method to track order status (User Story 3)
    public String trackOrderStatus(int orderId) {
        return orderStatusMap.getOrDefault(orderId, "Order not found");
    }
}
