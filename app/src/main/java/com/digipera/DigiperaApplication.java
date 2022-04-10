package com.digipera;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.digipera.commons.Constants;
import com.digipera.dto.User;
import com.digipera.firebase.NotificationUtil;

public class DigiperaApplication extends Application {
    private static DigiperaApplication singleton;

    public DigiperaApplication getInstance(){
        return singleton;
    }

    private User currentUser;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        NotificationUtil.subscribeTopic(Constants.TOPIC);
        createNotificationChannel();
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
}