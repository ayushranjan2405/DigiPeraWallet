//package com.digipera.services;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.digipera.R;
//import com.digipera.dto.Widget;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ParentWidgetsService {
//    public static List<View> getAllWidgets(AppCompatActivity context, LinearLayout rootLayout) {
//            return buildWidgets(context, rootLayout);
//    }
//
//    private static List<View> buildWidgets(AppCompatActivity context, LinearLayout rootLayout) {
//        List<View> views = new ArrayList<>();
//        mockWidgetsView().forEach(widget -> {
//            // Here you can access all views inside your child layout and assign them values
//            View view = LayoutInflater.from(context).inflate(R.layout.widget, rootLayout, false);
//
//            ImageView widgetImage = (ImageView) view.findViewById(R.id.widgetImage);
//            widgetImage.setImageResource(widget.getWidgetId());
//
//            TextView widgetText = view.findViewById(R.id.widgetText);
//            widgetText.setText(widget.getWidgetText());
//
//
//            views.add(view);
//        });
//        return views;
//    }
//
//    private static List<Widget> mockWidgetsView() {
//        List<Widget> widgets = new ArrayList<>();
//        widgets.add(new Widget(R.drawable.ic_baseline_account_balance_24, "History"));
//        widgets.add(new Widget(R.drawable.ic_baseline_money_24, "Transfer"));
//        widgets.add(new Widget(R.drawable.ic_baseline_question_answer_24, "Quiz"));
//        widgets.add(new Widget(R.drawable.ic_baseline_person_add_24, "Add Dependent"));
//        return widgets;
//    }
//
//}
//
