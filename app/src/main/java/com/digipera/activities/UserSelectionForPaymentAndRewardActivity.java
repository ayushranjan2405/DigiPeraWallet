package com.digipera.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.digipera.R;
import com.digipera.dto.User;
import com.digipera.listresource.UserListAdapter;
import com.digipera.mockdata.UserData;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

import java.util.List;

public class UserSelectionForPaymentAndRewardActivity extends BaseActivity implements OnRecyclerItemClickListener {
    List<User> users = UserData.getInstance().getAllUsers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);
        setActionbar();
        RecyclerView recyclerView = findViewById(R.id.userListRecyclerView);
        UserListAdapter userListAdapter = new UserListAdapter(UserSelectionForPaymentAndRewardActivity.this, this);
        recyclerView.setAdapter(userListAdapter);
        userListAdapter.setItems(users);
    }

    @Override
    public void onItemClick(int position) {
        User receiver = users.get(position);
        Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
        intent.putExtra("receiver", receiver);
        startActivity(intent);
    }
}