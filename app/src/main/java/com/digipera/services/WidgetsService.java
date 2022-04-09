package com.digipera.services;

import com.digipera.dto.Widget;
import com.digipera.mockdata.WidgetData;

import java.util.List;

public class WidgetsService {

    public static List<Widget> getWidgets(String key) {
        WidgetData widgetData = new WidgetData();
        return widgetData.getWidgets(key);
    }

}



