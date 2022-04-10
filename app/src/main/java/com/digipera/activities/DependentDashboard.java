package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Account;
import com.digipera.dto.User;
import com.digipera.dto.Widget;
import com.digipera.services.AccountService;
import com.digipera.services.WidgetsService;
import com.digipera.services.NotificationService;
import com.digipera.dto.Notification;
import com.digipera.utils.DateTimeUtil;
import com.digipera.views.NotificationView;
import com.digipera.views.WidgetView;

import java.util.List;

public class DependentDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependent_dashboard);

        User user = getSuppliedUser();
        createWelcomeView(user);
        createTimeView();
        createAccountView(user);
        createWidgetView();
        createNotificationView(user);
    }

    private User getSuppliedUser() {
        Bundle data = getIntent().getExtras();
        return (User) data.getParcelable("user");
    }

    private void createWelcomeView(User user) {
        TextView initials = (TextView) findViewById(R.id.initials);
        initials.setText(Formatter.getInitials(user));
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        welcomeMessage.setText(Formatter.getWelcomeMessage(user.getFirstname()));
    }

    private void createTimeView() {
        TextView time = (TextView) findViewById(R.id.time);
        time.setText(DateTimeUtil.getSystemDate());
    }

    private void createAccountView(User user) {
        //Balance
        Account account = AccountService.getAccount(user.getUsername());
        TextView balance = (TextView) findViewById(R.id.balance);
        balance.setText(Formatter.getBalance(account.getBalance()));

        //Rewards
        TextView rewards = (TextView) findViewById(R.id.reward);
        rewards.setText(Formatter.getRewards(account.getRewardPoints()));
    }

    private void createWidgetView() {

        List<Widget> widgets = WidgetsService.getWidgets(Constants.DEPENDENT_DASHBOARD);

        //Get the linear layout for widgets
        LinearLayout widgetsLayout = findViewById(R.id.widgets);
        List<View> widgetViews = WidgetView.getWidgetViews(this, widgetsLayout, widgets.subList(0,4));

        for (View view: widgetViews ) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int widgetType = (int) v.getTag();
                    Intent intent;
                    switch (widgetType){
                        case R.id.w_account_history:
                            intent = new Intent(getApplicationContext(), HistoryActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            });
            widgetsLayout.addView(view);
        }

        LinearLayout widgetsLayout2 = findViewById(R.id.widgets2);
        List<View> widgetViews2 = WidgetView.getWidgetViews(this, widgetsLayout2, widgets.subList(4,7));
        widgetViews2.forEach(widgetsLayout2::addView);
    }

    private void createNotificationView(User user) {
        //Get the linear layout for notifications
        LinearLayout notificationsLayout = findViewById(R.id.notifications);
        List<Notification> notifications = NotificationService.getNotifications(user.getUsername());
        if(notifications!=null){
            List<View> views = NotificationView.getNotificationViews(this, notificationsLayout, notifications);
            views.forEach(notificationsLayout::addView);
        }
    }
}