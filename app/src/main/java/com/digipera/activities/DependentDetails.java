package com.digipera.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.commons.Formatter;
import com.digipera.dto.Account;
import com.digipera.dto.Dependent;
import com.digipera.dto.Widget;
import com.digipera.services.AccountService;
import com.digipera.services.WidgetsService;
import com.digipera.utils.DateTimeUtil;
import com.digipera.views.WidgetView;

import java.util.List;

public class DependentDetails extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependent_details);
        setActionbar();
        Dependent dependent = getSuppliedDependent();
        createWelcomeView(dependent);
        createTimeView();
        createAccountView(dependent);
        createWidgetView();
        handleWidgetClick();

    }

    @SuppressLint("ClickableViewAccessibility")
    private void handleWidgetClick() {
        final ImageView v = (ImageView) findViewById(R.id.w_spending_habit);
        v.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("IMAGE_TAP", "action_down");
                    Intent intent = new Intent(getApplicationContext(), SpendingHabit.class);
                    //intent.putExtra("user", user);
                    startActivity(intent);
                    break;
                }
                case MotionEvent.ACTION_CANCEL:{
                    Log.i("IMAGE_TAP", "action_cancel");
                    break;
                }
            }
            return true;
        });
    }

    private Dependent getSuppliedDependent() {
        Bundle data = getIntent().getExtras();
        return (Dependent) data.getParcelable("dependent");
    }

    private void createWelcomeView(Dependent dependent) {
        TextView initials = (TextView) findViewById(R.id.initials);
        initials.setText(Formatter.getInitials(dependent));
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        welcomeMessage.setText(Formatter.getWelcomeMessage(dependent.getFirstname()));

    }

    private void createTimeView() {
        TextView time = (TextView) findViewById(R.id.time);
        time.setText(DateTimeUtil.getSystemDate());
    }

    private void createAccountView(Dependent dependent) {
        //Balance
        Account account = AccountService.getAccount(dependent.getFirstname().toLowerCase());
        TextView balance = (TextView) findViewById(R.id.balance);
        balance.setText(Formatter.getBalance(account.getBalance()));

        //Rewards
        TextView rewards = (TextView) findViewById(R.id.reward);
        rewards.setText(Formatter.getRewards(account.getRewardPoints()));
    }

    private void createWidgetView() {
        List<Widget> widgets = WidgetsService.getWidgets(Constants.DEPENDENT_DETAIL);

        //Get the linear layout for widgets
        LinearLayout widgetsLayout = findViewById(R.id.widgets);
        List<View> widgetViews = WidgetView.getWidgetViews(this, widgetsLayout, widgets.subList(0,4));
        widgetViews.forEach(widgetsLayout::addView);

        LinearLayout widgetsLayout2 = findViewById(R.id.widgets2);
        List<View> widgetViews2 = WidgetView.getWidgetViews(this, widgetsLayout2, widgets.subList(4,6));
        widgetViews2.forEach(widgetsLayout2::addView);
    }
}