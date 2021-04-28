package DatabaseService;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.logging.Logger;

@Service
public class FirebaseInitialize {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("./ServiceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://group6-5d4eb-default-rtdb.europe-west1.firebasedatabase.app")
                    .build();

            FirebaseApp.initializeApp(options);
            Firestore db = FirestoreClient.getFirestore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}