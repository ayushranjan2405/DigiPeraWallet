package com.digipera.listresource;

import android.view.View;
import android.widget.TextView;

import com.digipera.R;
import com.digipera.dto.User;
import com.digipera.firebase.model.Transaction;
import com.digipera.utils.DateTimeUtil;
import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;

public class HistoryViewHolder extends BaseViewHolder<Transaction, OnRecyclerItemClickListener> {

    private TextView tvTo,tvComment, tvAmount, tvDate;
    private View itemView;

    public HistoryViewHolder(View itemView, OnRecyclerItemClickListener listener) {
        super(itemView, listener);
        // initialize view and set click listener
        tvTo = itemView.findViewById(R.id.receiver);
        tvComment = itemView.findViewById(R.id.comment);
        tvAmount = itemView.findViewById(R.id.amount);
        tvDate = itemView.findViewById(R.id.date);
        this.itemView=itemView;
        if (listener != null) {
                    itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
                }
    }

    @Override
    public void onBind(Transaction item) {
        // bind data to the views
        tvTo.setText(item.getReceiver());
        tvComment.setText(item.getComment());
        tvAmount.setText(item.getAmount());
        tvDate.setText(DateTimeUtil.getDate(item.getTime()));
    }
}