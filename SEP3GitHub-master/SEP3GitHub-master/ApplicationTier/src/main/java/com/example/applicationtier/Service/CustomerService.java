package com.example.applicationtier.Service;

import com.example.applicationtier.models.Customer;

public interface CustomerService {
    void registerCustomer(Customer newCustomer);
    Customer validateUser(String username, String password);
    void deleteCustomer(String username);
    void updateCustomer(Customer customer);
}
