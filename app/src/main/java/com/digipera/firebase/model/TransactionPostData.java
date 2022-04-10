package com.digipera.firebase.model;

import com.digipera.firebase.model.Transaction;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionPostData {

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("data")
    @Expose
    private Transaction transaction;

    @SerializedName("message_id")
    @Expose
    private String messageId;

    @SerializedName("priority")
    @Expose
    private String priority;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
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
                ", transaction=" + transaction +
                ", priority='" + priority + '\'' +
                '}';
    }
}