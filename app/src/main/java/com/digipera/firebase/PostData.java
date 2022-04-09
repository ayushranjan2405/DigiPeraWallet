package com.digipera.firebase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostData {

    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("priority")
    @Expose
    private String priority;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PostData{" +
                "to='" + to + '\'' +
                ", data=" + data +
                ", priority='" + priority + '\'' +
                '}';
    }
}