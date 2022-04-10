package com.digipera.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.digipera.DigiperaApplication;
import com.digipera.R;
import com.digipera.firebase.model.Transaction;
import com.digipera.firebase.model.TransactionData;
import com.digipera.listresource.HistoryListAdapter;
import com.digipera.listresource.UserListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import java.util.List;

public class HistoryActivity extends BaseActivity implements OnRecyclerItemClickListener {

    private static final String TAG = "HistoryActivity";
    private List<Transaction> transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setActionbar();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        HistoryListAdapter historyListAdapter = new HistoryListAdapter(HistoryActivity.this, this);
        recyclerView.setAdapter(historyListAdapter);
        DocumentReference docRef = DigiperaApplication.getInstance().getDb()
                .collection("wallet")
                .document(DigiperaApplication.getInstance().getCurrentUser().getUsername());

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d(TAG, "Cached document data: " + documentSnapshot.getData());
                try {
                    TransactionData transactionData = documentSnapshot.toObject(TransactionData.class);
                    transactionList = transactionData.getTransactions();
                    historyListAdapter.setItems(transactionData.getTransactions());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), TransactionDetailActivity.class);
        Transaction transaction = transactionList.get(position);
        intent.putExtra("transaction", transaction);
        startActivity(intent);
    }
}