package com.digipera.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationUtil {

    private final String token = "AAAAv2JC7-U:APA91bEMkZDaCuJfLnlHmTf5qGqeR6-s530Ol3QS7F-TCZvBH6vpdas29rGe58VBkT54FQVM8A1SI8sWYsxst6xi5uojZB2vgjSFZajhBkX8Y73MBSmctYINqIbxVi6o-_rINtsHwtuk";

    public void sendNotification(Data data) {
        PostData postData = new PostData();
        postData.setData(data);
        postData.setTo("/topics/"+data.getTopic());
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
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Notification", "onFailure");
            }
        });
    }

}
