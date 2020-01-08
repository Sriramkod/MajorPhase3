package com.example.ksriram.majorphase3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import static com.example.ksriram.majorphase3.App.CHANNEL_1_ID;
public class Alaram extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        int notoficationId = intent.getIntExtra("NotifiactionId",0);
        String message = intent.getStringExtra("todo");
        Intent mainIntent = new Intent(context,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,0,mainIntent,0);


        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentTitle("From Sriram")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
      //  notificationManager.notify(2,notification);
      //  notificationManager.notify(3,notification);

    }
}
