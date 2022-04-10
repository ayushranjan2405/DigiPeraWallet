package com.digipera.listresource;

import android.content.Context;
import android.view.ViewGroup;

import com.digipera.R;
import com.digipera.dto.User;
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

public class UserListAdapter extends GenericRecyclerViewAdapter<User, OnRecyclerItemClickListener, UserListViewHolder> {

    public UserListAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    @Override
    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserListViewHolder(inflate(R.layout.item_user, parent), getListener());
    }
}