package com.digipera.mockdata;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.dto.Widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WidgetData {

    Map<String, List<Widget>> widgetTable;

    public WidgetData(){
        widgetTable = new HashMap<>();
        widgetTable.put(Constants.PARENT, getParentWidgets());
        widgetTable.put(Constants.DEPENDENT_DASHBOARD, getDependentDashboardWidgets());
        widgetTable.put(Constants.DEPENDENT_DETAIL, getDependentDetailWidgets());
    }


    public List<Widget> getWidgets(String key){
        return widgetTable.get(key);
    }
    
    private static List<Widget> getParentWidgets() {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget(R.drawable.ic_baseline_account_balance_24, R.id.w_account_history,"History"));
        widgets.add(new Widget(R.drawable.ic_baseline_money_24, R.id.w_transfer_money,"Transfer"));
        widgets.add(new Widget(R.drawable.ic_baseline_question_answer_24, R.id.w_quiz ,"Quiz"));
        widgets.add(new Widget(R.drawable.ic_baseline_person_add_24, R.id.w_add_dependent,"Add Dependent"));
        return widgets;
    }

    private static List<Widget> getDependentDashboardWidgets() {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget(R.drawable.ic_baseline_account_balance_24, R.id.w_account_history,"History"));
        widgets.add(new Widget(R.drawable.ic_baseline_question_answer_24, R.id.w_quiz,"Quiz"));
        widgets.add(new Widget(R.drawable.ic_baseline_bar_chart_24, R.id.w_spending_habit,"Spending Habit"));
        widgets.add(new Widget(R.drawable.ic_baseline_directions_run_24, R.id.w_activity,"Activity"));
        widgets.add(new Widget(R.drawable.ic_outline_access_time_24, R.id.w_screen_activity,"Screen Time"));
        widgets.add(new Widget(R.drawable.ic_baseline_thumb_up_24, R.id.w_rewards,"Rewards"));
        widgets.add(new Widget(R.drawable.ic_baseline_qr_code_scanner_24, R.id.w_scan_n_pay,"Scan & Pay"));
        return widgets;
    }

    private static List<Widget> getDependentDetailWidgets() {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(new Widget(R.drawable.ic_baseline_account_balance_24, R.id.w_account_history,"History"));
        widgets.add(new Widget(R.drawable.ic_baseline_question_answer_24, R.id.w_quiz,"Quiz"));
        widgets.add(new Widget(R.drawable.ic_baseline_bar_chart_24, R.id.w_spending_habit,"Spending Habit"));
        widgets.add(new Widget(R.drawable.ic_baseline_directions_run_24, R.id.w_activity,"Activity"));
        widgets.add(new Widget(R.drawable.ic_outline_access_time_24, R.id.w_screen_activity,"Screen Time"));
        widgets.add(new Widget(R.drawable.ic_baseline_thumb_up_24, R.id.w_rewards,"Rewards"));
        return widgets;
    }
}
