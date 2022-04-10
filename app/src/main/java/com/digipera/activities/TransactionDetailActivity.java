package com.digipera.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.digipera.R;
import com.digipera.dto.User;
import com.digipera.firebase.model.Transaction;
import com.digipera.utils.DateTimeUtil;

public class TransactionDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
        setActionbar();
        Bundle data = getIntent().getExtras();
        Transaction transaction = data.getParcelable("transaction");

        TextView amount = findViewById(R.id.amount);
        amount.setText(transaction.getAmount());

        TextView sender = findViewById(R.id.sender);
        sender.setText(transaction.getSender());

        TextView to = findViewById(R.id.receiver);
        to.setText(transaction.getReceiver());

        TextView dateTime = findViewById(R.id.dateTime);
        dateTime.setText(DateTimeUtil.getDate(transaction.getTime()));

    }
}