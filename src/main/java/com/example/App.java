package com.example;

import com.example.domain.Customer;
import com.example.domain.Order;
import com.example.service.OrderService;

public class App {
    public static void main(String[] args) {
        Customer customer = new Customer("john doe", "john.doe@example.com");
        Order order = new Order(1, customer, 100.00);
        
        OrderService orderService = new OrderService();
        String result = orderService.processOrder(order);
        
        System.out.println(result);
    }
}
