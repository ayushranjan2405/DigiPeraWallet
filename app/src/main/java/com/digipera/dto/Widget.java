package com.digipera.dto;

public class Widget {
    private final int widgetImage;
    private final int widgetId;
    private final String widgetText;

    public Widget(int widgetImage, int widgetId, String widgetText) {
        this.widgetImage = widgetImage;
        this.widgetId = widgetId;
        this.widgetText = widgetText;
    }

    public int getWidgetImage() {
        return widgetImage;
    }

    public int getWidgetId() {
        return widgetId;
    }

    public String getWidgetText() {
        return widgetText;
    }
}
