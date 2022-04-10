package com.digipera.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.digipera.DigiperaApplication;
import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.User;
import com.digipera.firebase.NotificationUtil;
import com.digipera.firebase.model.Transaction;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;

public class PaymentActivity extends BaseActivity {

    TextView txtReceiver;
    EditText etAmount, etComment;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setActionbar();
        Bundle data = getIntent().getExtras();
        User receiver = data.getParcelable("receiver");
        User sender = DigiperaApplication.getInstance().getCurrentUser();
        txtReceiver = findViewById(R.id.receiver);
        txtReceiver.setText(receiver.getFirstname()+" "+receiver.getLastname());
        etAmount = findViewById(R.id.amount);
        etComment = findViewById(R.id.comment);
        btnPay = findViewById(R.id.pay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Transaction transaction = new Transaction();
                transaction.setSender(sender.getUsername());
                transaction.setReceiver(receiver.getUsername());
                transaction.setNotificationType(Constants.TRANSACTION_TYPE_DEBIT);
                transaction.setAmount(etAmount.getText().toString());
                transaction.setTime(System.currentTimeMillis());
                transaction.setComment(etComment.getText().toString());

                DocumentReference documentReferenceReceiver = DigiperaApplication.getInstance().getDb().collection("wallet").document(receiver.getUsername());
                documentReferenceReceiver.update("transactions", FieldValue.arrayUnion(transaction));

                DocumentReference documentReferenceSender = DigiperaApplication.getInstance().getDb().collection("wallet").document(sender.getUsername());
                documentReferenceSender.update("transactions", FieldValue.arrayUnion(transaction));

                NotificationUtil.sendTransactionNotification(transaction, new NotificationUtil.NotificationSendListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(PaymentActivity.this, "Sent", Toast.LENGTH_LONG).show();
                        // finish();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(PaymentActivity.this, R.string.generic_error, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }


}