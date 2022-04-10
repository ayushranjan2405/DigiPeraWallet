package com.digipera.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.digipera.commons.Constants;
import com.digipera.firebase.model.Transaction;
import com.digipera.firebase.model.TransactionPostData;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationUtil {

    private static final String token = "key=AAAAv2JC7-U:APA91bEMkZDaCuJfLnlHmTf5qGqeR6-s530Ol3QS7F-TCZvBH6vpdas29rGe58VBkT54FQVM8A1SI8sWYsxst6xi5uojZB2vgjSFZajhBkX8Y73MBSmctYINqIbxVi6o-_rINtsHwtuk";

    public static void subscribeTopic(String topic){

        FirebaseMessaging.getInstance().subscribeToTopic(topic).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.e("Notification", "subscribe to topic : "+topic);
            }
        });
    }

    public static void sendTransactionNotification(Transaction transaction, NotificationSendListener notificationSendListener) {
        TransactionPostData postData = new TransactionPostData();
        postData.setTransaction(transaction);
        postData.setTo("/topics/"+ Constants.TOPIC);
       // postData.setMessageId(System.currentTimeMillis()+"");
        postData.setPriority("high");

        Call<FcmResponse> call = NotificationApiClient.getAPIService().sendData(postData, token);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, @NonNull Response response) {
                if (response.body() == null) {
                    onFailure(call, new Exception());
                } else {
                    FcmResponse fcmResponse = (FcmResponse) response.body();
                    Log.e("Notification", ""+fcmResponse.getMessageId());
                    notificationSendListener.onSuccess();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Notification", "onFailure");
                notificationSendListener.onError();
            }
        });
    }

    public interface NotificationSendListener{
        void onSuccess();
        void onError();
    }

}
