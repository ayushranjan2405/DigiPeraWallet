package com.digipera.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.digipera.R;
import com.digipera.commons.Formatter;
import com.digipera.dto.Dependent;

import java.util.List;

public class DeckAdapter extends BaseAdapter {

    // on below line we have created variables
    // for our array list and context.
    private List<Dependent> dependents;
    private Context context;

    // on below line we have created constructor for our variables.
    public DeckAdapter(List<Dependent> dependents, Context context) {
        this.dependents = dependents;
        this.context = context;
    }

    @Override
    public int getCount() {
        // in get count method we are returning the size of our array list.
        return dependents.size();
    }

    @Override
    public Object getItem(int position) {
        // in get item method we are returning the item from our array list.
        return dependents.get(position);
    }

    @Override
    public long getItemId(int position) {
        // in get item id we are returning the position.
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // in get view method we are inflating our layout on below line.
        View v = convertView;
        if (v == null) {
            // on below line we are inflating our layout.
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        }
        ((CardView) v.findViewById(R.id.dependentCard)).setBackgroundTintList(getRandomColor(position));
        // on below line we are initializing our variables and setting data to our variables.
        ((TextView) v.findViewById(R.id.dependentName)).setText(dependents.get(position).getFirstname());
        ((TextView) v.findViewById(R.id.balance)).setText(getBalance(dependents.get(position).getBalance()));
        ((TextView) v.findViewById(R.id.reward)).setText(getRewards(dependents.get(position).getRewardPoints()));
        ((TextView) v.findViewById(R.id.initials)).setText(getInitials(dependents.get(position)));
        return v;
    }

    private String getBalance(String balance) {
        return Formatter.getBalance(balance);
    }

    private String getRewards(String rewardPoints) {
        return Formatter.getRewards(rewardPoints);
    }

    private String getInitials(Dependent dependent) {
        return dependent.getFirstname().substring(0, 1) + dependent.getLastname().substring(0, 1);
    }

    private ColorStateList getRandomColor(int position) {
        return ColorStateList.valueOf(Color.parseColor(getColor(position)));
    }

    private String getColor(int i) {
        String[] colors = {String.format("#%06X", (0xFFFFFF & R.color.primary)), "#51801e"};
        if (i >= 2) {
            i = i % 2;
        }
        return colors[i];
    }
}

