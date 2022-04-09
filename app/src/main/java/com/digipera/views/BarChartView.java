package com.digipera.views;

import android.graphics.Color;

import com.digipera.services.SpendingHabitService;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class BarChartView {

    public static BarChart getBarChartView(BarChart barChart){
        return new BarChartView().loadBarChart(barChart);
    }

    public BarChart loadBarChart(BarChart barChart) {

        com.digipera.dto.SpendingHabit spendingHabitData = SpendingHabitService.getSpendingHabit();
        List<String> categories = spendingHabitData.getCategory();

        List<BarEntry> prevMonthItems = getPrevMonthItems(spendingHabitData);
        List<BarEntry> currMonthItems = getCurrMonthItems(spendingHabitData);

        BarDataSet dataSet1 = new BarDataSet(prevMonthItems, "Previous Month");
        decorateDataSet(dataSet1, Color.rgb(81, 128, 30));

        BarDataSet dataSet2 = new BarDataSet(currMonthItems, "Current Month");
        decorateDataSet(dataSet2, Color.rgb(128, 30, 32));

        BarData data = new BarData(dataSet1, dataSet2);
        decorateBarData(data);

        XAxis xAxis = barChart.getXAxis();
        decorateXAxis(xAxis, categories);

        Legend legend = barChart.getLegend();
        decorateLegends(legend);

        barChart.setData(data);
        decorateBarChart(barChart);
        return barChart;

    }

    private void decorateDataSet(BarDataSet dataSet1, int barColor) {
        dataSet1.setColors(barColor);
        dataSet1.setValueTextSize(10f);  /* values size */
        dataSet1.setValueTextColor(Color.WHITE);
    }

    private List<BarEntry> getPrevMonthItems(com.digipera.dto.SpendingHabit spendingHabitData) {
        List<String> categories = spendingHabitData.getCategory();
        List<Integer> previousMonthData = spendingHabitData.getPreviousMonth();
        List<BarEntry> items = getBarItems(categories, previousMonthData);

        return getBarItems(categories, previousMonthData);
    }

    private List<BarEntry> getCurrMonthItems(com.digipera.dto.SpendingHabit spendingHabitData) {
        List<String> categories = spendingHabitData.getCategory();
        List<Integer> currentMonthData = spendingHabitData.getCurrentMonth();
        return getBarItems(categories, currentMonthData);
    }

    private List<BarEntry> getBarItems(List<String> categories, List<Integer> values) {
        List<BarEntry> items = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            items.add(new BarEntry(i, values.get(i)));
        }
        return items;
    }

    private void decorateBarData(BarData data) {
        float barWidth = 0.42f; // x2 dataset

        //Converting float to String
        ValueFormatter vf = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "" + (int) value;
            }
        };
        data.setValueFormatter(vf);

        data.setValueTextSize(12f);
        data.setBarWidth(barWidth);
    }


    private void decorateXAxis(XAxis xAxis, List<String> categories) {

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setLabelCount(categories.size());
        xAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMaximum(categories.size());
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(14f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(categories));
    }

    private void decorateLegends(Legend legend) {

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setTextColor(Color.WHITE);
        legend.setTextSize(14f);
    }



    private void decorateBarChart(BarChart barChart) {
        float groupSpace = 0.15f;
        float barSpace = 0.01f; // x2 dataset
        barChart.groupBars(0f, groupSpace, barSpace);
        barChart.getAxisLeft().setTextColor(Color.WHITE);
        barChart.getAxisRight().setTextColor(Color.WHITE);
        barChart.getDescription().setTextColor(Color.WHITE);
        barChart.getDescription().setEnabled(false);
        barChart.setExtraBottomOffset(20f);
        barChart.setDrawValueAboveBar(false);
        barChart.setTouchEnabled(false);
        barChart.animateY(500);
        barChart.invalidate();
    }

}
