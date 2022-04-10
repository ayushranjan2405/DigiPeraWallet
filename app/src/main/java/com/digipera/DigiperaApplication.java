package com.digipera;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.digipera.commons.Constants;
import com.digipera.dto.User;
import com.digipera.firebase.NotificationUtil;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class DigiperaApplication extends Application {
    private static DigiperaApplication singleton;

    public static DigiperaApplication getInstance(){
        return singleton;
    }

    private User currentUser;
    private FirebaseFirestore db;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        NotificationUtil.subscribeTopic(Constants.TOPIC);
        createNotificationChannel();
        setupFirestoreDB();
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "digipera";
            String description = "Trsanctions";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(name, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public FirebaseFirestore getDb() {
        return db;
    }

    public void setupFirestoreDB() {
        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
    }
}