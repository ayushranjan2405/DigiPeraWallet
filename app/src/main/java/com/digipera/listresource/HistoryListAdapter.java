package com.digipera.listresource;

import android.content.Context;
import android.view.ViewGroup;

import com.digipera.R;
import com.digipera.dto.User;
import com.digipera.firebase.model.Transaction;
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

public class HistoryListAdapter extends GenericRecyclerViewAdapter<Transaction, OnRecyclerItemClickListener, HistoryViewHolder> {

    public HistoryListAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryViewHolder(inflate(R.layout.item_transaction, parent), getListener());
    }
}