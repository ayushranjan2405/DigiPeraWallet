package com.digipera.listresource;

import android.view.View;
import android.widget.TextView;

import com.digipera.R;
import com.digipera.dto.User;
import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

public class UserListViewHolder extends BaseViewHolder<User, OnRecyclerItemClickListener> {

    private TextView nameTv;

    public UserListViewHolder(View itemView, OnRecyclerItemClickListener listener) {
        super(itemView, listener);
        // initialize view and set click listener
        nameTv = itemView.findViewById(R.id.username);
        if (listener != null) {
                    itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
                }
    }

    @Override
    public void onBind(User item) {
        // bind data to the views
        nameTv.setText(item.getFirstname()+" "+item.getLastname());
    }
}