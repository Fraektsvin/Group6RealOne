package com.example.applicationtier.Service;

import com.example.applicationtier.models.Customer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestClass {
    List<Customer> customerList = new ArrayList<>();

    public void registerCustomer(Customer customer)
    {
        boolean bool = false;
        for(Customer customer1:customerList)
        {
            if(customer1.getUsername().equals(customer.getUsername()))
            {
                bool = true;
                break;
            }
        }
        if(bool = false)
        {
            customerList.add(customer);
        }
        System.out.println(customerList);
    }

    public Customer validateUser(String username, String password)
    {
        for(Customer customer: customerList)
        {
            if(customer.getUsername().equals(username) && customer.getPassword().equals(password))
            {
                return customer;
            }
        }
        return null;
    }
}
