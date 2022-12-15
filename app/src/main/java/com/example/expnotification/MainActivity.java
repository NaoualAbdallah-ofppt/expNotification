package com.example.expnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;
final String  CHANNEL_ID="ch1";
final String  CHANNEL_NAME="ch_test";
final int  NOTIF_ID=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btn);

        NotificationManager notif = (NotificationManager) getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                 
                    NotificationChannel notifCh =
                            new NotificationChannel (CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
                    notif.createNotificationChannel(notifCh);
                    Notification.Builder notifBuilder =
                            new Notification.Builder(getApplicationContext(),CHANNEL_ID)
                                    .setContentTitle("titre xxxxx")
                                    .setContentText("description xxxxx")
                                    .setSmallIcon(R.drawable.ic_launcher_background);
                    notif.notify(NOTIF_ID, notifBuilder.build());





            }
        });
    }
}