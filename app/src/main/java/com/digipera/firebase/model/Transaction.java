package com.digipera.firebase.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction implements Parcelable {
    @SerializedName("sender")
    @Expose
    private String sender;

    @SerializedName("receiver")
    @Expose
    private String receiver;

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
    private String amount;

    @SerializedName("comment")
    @Expose
    private String comment;

    public Transaction(){

    }

    protected Transaction(Parcel in) {
        sender = in.readString();
        receiver = in.readString();
        notificationType = in.readInt();
        type = in.readInt();
        if (in.readByte() == 0) {
            time = null;
        } else {
            time = in.readLong();
        }
        amount = in.readString();
        comment = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sender);
        dest.writeString(receiver);
        dest.writeInt(notificationType);
        dest.writeInt(type);
        if (time == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(time);
        }
        dest.writeString(amount);
        dest.writeString(comment);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }
}