package com.digipera.firebase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by trilokinathyadav on 09/04/2022.
 */

public class FcmResponse {
    public FcmResponse() {
    }

    @SerializedName("message_id")
    @Expose
    private long messageId;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

}
