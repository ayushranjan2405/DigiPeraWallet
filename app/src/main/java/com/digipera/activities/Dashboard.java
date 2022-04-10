package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daprlabs.cardstack.SwipeDeck;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Account;
import com.digipera.dto.Notification;
import com.digipera.dto.User;
import com.digipera.dto.Widget;
import com.digipera.firebase.NotificationUtil;
import com.digipera.firebase.model.Transaction;
import com.digipera.services.AccountService;
import com.digipera.services.WidgetsService;
import com.digipera.utils.DateTimeUtil;
import com.digipera.utils.DeckAdapter;
import com.digipera.R;
import com.digipera.services.DependentService;
import com.digipera.services.NotificationService;
import com.digipera.dto.Dependent;
import com.digipera.views.NotificationView;
import com.digipera.views.WidgetView;

import java.util.List;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        User user = getSuppliedUser();
        createWelcomeView(user);
        createTimeView();
        createAccountView(user);
        createCardView();
        createWidgetView();
        createNotificationView(user);

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

    }

    private void createCardView() {

        SwipeDeck cardStack;
        List<Dependent> dependentList;
        // on below line we are initializing our array list and swipe deck.
        cardStack = findViewById(R.id.swipe_deck);

        // on below line we are adding data to our array list.
        dependentList = DependentService.getAllDependents();

        // on below line we are creating a variable for our adapter class and passing array list to it.
        final DeckAdapter adapter = new DeckAdapter(dependentList, this);

        // on below line we are setting adapter to our card stack.
        cardStack.setAdapter(adapter);
        setEventCallback2CardStack(cardStack, dependentList);
    }

    private void createWidgetView() {

        List<Widget> widgets = WidgetsService.getWidgets(Constants.PARENT);

        //Get the linear layout for widgets
        LinearLayout widgetsLayout = findViewById(R.id.widgets);

        List<View> widgetViews = WidgetView.getWidgetViews(this, widgetsLayout, widgets.subList(0,4));
        for (View view: widgetViews ) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int widgetType = (int) v.getTag();
                    switch (widgetType){

                        case R.id.w_transfer_money:
                            Toast.makeText(Dashboard.this,"w_transfer_money",Toast.LENGTH_LONG).show();
                            Transaction transaction = new Transaction();
                            transaction.setTopic(Constants.TOPIC);
                            transaction.setSender("tny");
                            transaction.setTo("shilpi");
                            transaction.setNotificationType(0);
                            transaction.setAmount(100);
                            transaction.setTime(System.currentTimeMillis());
                            transaction.setComment("Payment");
                            NotificationUtil.sendTransactionNotification(transaction);
                            break;
                        case R.id.w_account_history:
                            Toast.makeText(Dashboard.this,"w_account_history",Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            });
            widgetsLayout.addView(view);
        }
    }

    private void createNotificationView(User user) {
        //Get the linear layout for notifications
        LinearLayout notificationsLayout = findViewById(R.id.notifications);
        List<Notification> notifications = NotificationService.getNotifications(user.getUsername());
        List<View> views = NotificationView.getNotificationViews(this, notificationsLayout, notifications);
        views.forEach(notificationsLayout::addView);
    }

    private User getSuppliedUser() {
        Bundle data = getIntent().getExtras();
        return (User) data.getParcelable("user");
    }

    private void setEventCallback2CardStack(SwipeDeck cardStack, List<Dependent> dependentList) {
        // on below line we are setting event callback to our card stack.
        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
                // on card swipe left we are displaying a toast message.
                Toast.makeText(Dashboard.this, "Card Swiped Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardSwipedRight(int position) {
                // on card swiped to right we are displaying a toast message.
                TextView dependentName = (TextView) findViewById(R.id.dependentName);
                //TextView password = (TextView) findViewById(R.id.password);
                Log.i("NAME", position + dependentName.getText().toString());
                Intent intent = new Intent(getApplicationContext(), DependentDetails.class);
                intent.putExtra("dependent", dependentList.get(position));
                startActivity(intent);
                Toast.makeText(
                        Dashboard.this,
                        "Card Swiped Right for dependent: " + dependentName.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardsDepleted() {
                // this method is called when no card is present
                Toast.makeText(Dashboard.this, "No more courses present", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cardActionDown() {
                // this method is called when card is swiped down.
                Log.i("TAG", "CARDS MOVED DOWN");
            }

            @Override
            public void cardActionUp() {
                // this method is called when card is moved up.
                Log.i("TAG", "CARDS MOVED UP");
            }
        });
    }
}