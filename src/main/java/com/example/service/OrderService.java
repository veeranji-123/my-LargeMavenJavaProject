package com.example.service;

import com.example.domain.Order;
import com.example.util.StringUtilsUtil;  // Updated import statement

public class OrderService {
    public String processOrder(Order order) {
        String customerName = order.getCustomer().getName();
        double amount = order.getTotalAmount();

        // Using a utility method from StringUtilsUtil to format the customer name
        String formattedName = StringUtilsUtil.capitalizeWords(customerName);

        // Business logic (e.g., validating, processing, etc.)
        return "Order for " + formattedName + " processed with total: " + amount;
    }
}

