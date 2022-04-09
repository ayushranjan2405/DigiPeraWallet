package com.digipera.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Dependent implements Parcelable {

    public static final Creator<Dependent> CREATOR = new Creator<Dependent>() {
        @Override
        public Dependent createFromParcel(Parcel in) {
            return new Dependent(in);
        }

        @Override
        public Dependent[] newArray(int size) {
            return new Dependent[size];
        }
    };

    private String firstname;
    private String lastname;
    private String balance;
    private String rewardPoints;

    public Dependent(String firstname, String lastname, String balance, String rewardPoints) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.balance = balance;
        this.rewardPoints = rewardPoints;
    }

    protected Dependent(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        balance = in.readString();
        rewardPoints = in.readString();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(String rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstname);
        parcel.writeString(lastname);
        parcel.writeString(balance);
        parcel.writeString(rewardPoints);
    }
}

