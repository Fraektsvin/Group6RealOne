package com.example.applicationtier.DAO;

import com.example.applicationtier.models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Component
public interface FirebaseService {

    String saveUserDetails(Customer user);
    Customer getUserDetails(String name);
    String updateUserDetails(Customer user);
    String deleteUser(String name);

}
