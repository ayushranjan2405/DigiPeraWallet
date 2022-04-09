package com.digipera.firebase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("time")
    @Expose
    private Long time;

    @SerializedName("amount")
    @Expose
    private int amount;

    @SerializedName("comment")
    @Expose
    private String comment;

    @SerializedName("topic")
    @Expose
    private String topic;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}