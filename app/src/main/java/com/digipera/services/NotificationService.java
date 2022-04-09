package com.digipera.services;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digipera.activities.Dashboard;
import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Notification;
import com.digipera.mockdata.NotificationData;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    public static List<Notification> getNotifications(String username) {
        Log.i("Username_notification: ", username);
        NotificationData notificationData = new NotificationData();
        return notificationData.getNotifications(username);
    }
}

