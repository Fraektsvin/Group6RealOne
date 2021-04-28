package com.example.applicationtier.DAO;

import com.example.applicationtier.models.Customer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseServiceImpl implements FirebaseService{
    public String saveUserDetails(Customer customer){
        try {
            System.out.println("User: " + customer);
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Users").document(customer.getName()).set(customer);
            return collectionsApiFuture.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer getUserDetails(String name) {
        try {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            DocumentReference documentReference = dbFirestore.collection("Users").document(name);
            ApiFuture<DocumentSnapshot> future = documentReference.get();

            DocumentSnapshot document = future.get();
            Customer user = null;
            if (document.exists()) {
                user = document.toObject(Customer.class);
                return user;
            } else {
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

        }
        return null;
    }

    public String updateUserDetails(Customer customer) {
        try {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Users").document(customer.getName()).set(customer);
            return collectionsApiFuture.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteUser(String name) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> writeResult = db.collection("Users").document(name).delete();
            return writeResult.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
