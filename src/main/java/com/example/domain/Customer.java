package com.example.domain;

public class Customer {
    private String name;
    private String email;

    // Constructor, getters, setters
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
