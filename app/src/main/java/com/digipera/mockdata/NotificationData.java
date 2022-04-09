package com.digipera.mockdata;

import com.digipera.dto.Notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationData {

    private Map<String, List<Notification>> notificationTable;

    public NotificationData() {
        notificationTable = new HashMap<>();
        notificationTable.put("shilpi", getShilpiNotifications());
        notificationTable.put("ishita", getIshitaNotifications());
        notificationTable.put("rohan", getRohanNotifications());

    }

    public List<Notification> getNotifications(String username) {
        return notificationTable.get(username);
    }

    private List<Notification> getShilpiNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Credited to Ishita", "Rs. 2000", "Debited from: Shilpi", "April 1, 2022"));
        notifications.add(new Notification("Paid to School Canteen", "Rs. 85", "By: Ishita", "April 2, 2022"));
        notifications.add(new Notification("Quiz on Sports finished", "Score: 60", "By: Rohan", "April 5, 2022"));
        notifications.add(new Notification("Paid to Book store", "Rs. 345", "By: Rohan", "April 7, 2022"));
        return notifications;
    }


    private List<Notification> getIshitaNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Screen time crossed daily average", "2 h 15 mins", "Daily average: 2 hours", "April 1, 2022"));
        notifications.add(new Notification("Paid to School Canteen", "Rs. 85", "Debited from: Ishita", "April 2, 2022"));
        notifications.add(new Notification("Quiz completed", "Score: 60", "Topic: Sports", "April 5, 2022"));
        notifications.add(new Notification("Paid to Book store", "Rs. 345", "By: Ishita", "April 7, 2022"));
        notifications.add(new Notification("Received money", "Rs. 2000", "From: Shilpi", "April 8, 2022"));
        return notifications;
    }

    private List<Notification> getRohanNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Received money", "Rs. 1000", "From: Shilpi", "April 1, 2022"));
        notifications.add(new Notification("Screen time crossed daily average", "2 h 15 mins", "Daily average: 2 hours", "April 2, 2022"));
        notifications.add(new Notification("Paid to School Canteen", "Rs. 85", "Debited from: Rohan", "April 4, 2022"));
        notifications.add(new Notification("Quiz completed", "Score: 60", "Topic: Maths", "April 5, 2022"));
        notifications.add(new Notification("Paid to Book store", "Rs. 345", "By: Rohan", "April 7, 2022"));

        return notifications;
    }
}
