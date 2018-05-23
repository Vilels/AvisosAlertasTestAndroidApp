package com.example.vilels.avisosalertastest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String click_action = remoteMessage.getNotification().getClickAction();
        String title = "0";
        String body = "0";
        String key_1 = "0";
        String key_2 = "0";

        if (remoteMessage.getData().size()>0){
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            title = remoteMessage.getData().get("title");
            body = remoteMessage.getData().get("body");
            key_1 = remoteMessage.getData().get("key_1");
            key_2 = remoteMessage.getData().get("key_2");
        }

        sendNotification(remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle(), title, body, key_1, key_2, click_action);


    }

    private void sendNotification(String messageBody, String messageTitle, String title, String body, String key_1, String key_2, String click_action){
        Intent intent = new Intent(click_action);
        intent.putExtra("title", title);
        intent.putExtra("body", body);
        intent.putExtra("key_1", key_1);
        intent.putExtra("key_2", key_2);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.drawable.ic_home_black_24dp)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }

}

