package com.example.service;

import com.example.domain.Customer;
import com.example.domain.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    public void testProcessOrder() {
        Customer customer = new Customer("john doe", "john.doe@example.com");
        Order order = new Order(1, customer, 100.00);
        
        OrderService orderService = new OrderService();
        String result = orderService.processOrder(order);

        assertTrue(result.contains("Order for John doe processed"));
        assertTrue(result.contains("total: 100.0"));
    }
}
