package com.digipera.firebase;

import static com.digipera.commons.Constants.NOTIFICATION_TYPE_TRANSACTION;
import static com.digipera.commons.Constants.TRANSACTION_TYPE_CREDIT;
import static com.digipera.commons.Constants.TRANSACTION_TYPE_DEBIT;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.digipera.R;
import com.digipera.commons.Constants;
import com.digipera.utils.SharedPrefUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MessagingService extends FirebaseMessagingService {
    private static final String TAG = "MessagingService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        // super.onMessageReceived(remoteMessage);
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        Map<String, String> remoteMessageData = remoteMessage.getData();
        if (remoteMessageData.size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessageData);
            String currentUser = SharedPrefUtils.getStringData(MessagingService.this, Constants.CURRENT_LOGIN_USER);
            String to = remoteMessageData.get("to");
            if (!currentUser.equals(to)){
                return;
            }
            int notificationType = Integer.parseInt(remoteMessageData.get("notificationType"));

            switch (notificationType){
                case NOTIFICATION_TYPE_TRANSACTION:
                    String sender = remoteMessageData.get("sender");
                    int type = Integer.parseInt(remoteMessageData.get("type"));
                    String time = remoteMessageData.get("time");
                    String amount = remoteMessageData.get("amount");
                    String comment = remoteMessageData.get("comment");
                    String notificationTitle = null;
                    String notificationContentText = null;

                    switch (type){
                        case TRANSACTION_TYPE_DEBIT:
                            notificationTitle = amount+" Debited";
                            notificationContentText = amount+" received from "+sender;
                            break;

                        case TRANSACTION_TYPE_CREDIT:
                            // for credit
                            break;


                        default:

                    }
                    sendNotification(notificationTitle, notificationContentText);
                    break;
                default:

            }

        }

    }

    private void sendNotification(String title, String contentText) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "digipera")
                .setSmallIcon(R.drawable.wallet_logo_64) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(contentText) // message for notification
                .setAutoCancel(true); // clear notification after click
//            Intent intent = new Intent(this, MainActivity.class);
//            PendingIntent pi = PendingIntent.getActivity(this,0,intent,Intent.FLAG_ACTIVITY_NEW_TASK);
//            mBuilder.setContentIntent(pi);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }


}