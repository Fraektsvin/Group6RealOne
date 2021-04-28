package com.example.applicationtier.controller;

import com.example.applicationtier.DAO.FirebaseService;
import com.example.applicationtier.Service.CustomerService;
import com.example.applicationtier.Service.TestClass;
import com.example.applicationtier.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    @Autowired
    private CustomerService service;

  /*  @Autowired
    private TestClass service;*/

    @GetMapping("/users")
    public Customer validateUser(@RequestParam String username, @RequestParam String password) {
        return service.validateUser(username, password);
    }

    @PostMapping("/createNewUser")
    public void  RegisterCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        service.registerCustomer(customer);
    }

   @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestHeader String name) {
        service.deleteCustomer(name);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody Customer customer){
        service.updateCustomer(customer);
    }
}
