package com.digipera.views;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.digipera.R;
import com.digipera.dto.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationView {
    public static List<View> getNotificationViews(AppCompatActivity context,
                                                  LinearLayout rootLayout,
                                                  List<Notification> notifications) {

        List<View> views = new ArrayList<>();
        notifications.forEach(notification -> {
            // Here you can access all views inside your child layout and assign them values
            View view = LayoutInflater.from(context).inflate(R.layout.notification, rootLayout,
                    false);
            TextView line1Left = view.findViewById(R.id.line1_left);
            line1Left.setText(notification.getLine1Left());

            TextView line1Right = view.findViewById(R.id.line1_right);
            line1Right.setText(notification.getLine1Right());

            TextView line2Left = view.findViewById(R.id.line2_left);
            line2Left.setText(notification.getLine2Left());

            TextView line2Right = view.findViewById(R.id.line2_right);
            line2Right.setText(notification.getLine2Right());
            views.add(view);
        });

        return views;
    }
}
