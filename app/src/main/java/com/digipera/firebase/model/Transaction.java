package com.digipera.firebase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {
    @SerializedName("sender")
    @Expose
    private String sender;

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("notificationType")
    @Expose
    private int notificationType;

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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }
}