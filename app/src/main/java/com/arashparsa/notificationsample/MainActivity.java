package com.arashparsa.notificationsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialButton = findViewById(R.id.btn_simpleNotification);

    }

    @Override
    public void onClick(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        switch (view.getId()){
            case R.id.btn_simpleNotification:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                Notification notification = new NotificationCompat.Builder(MainActivity.this, "myapp")
                        .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                        .setContentTitle("My Notification")
                        .setContentText("This is my first notification")
                        .setContentIntent(pendingIntent)
                        .build();
                notificationManager.notify(new Random().nextInt(), notification);
                break;

            case R.id.btn_bigPictureStyleNotification:
                Notification bigPictureStyleNotification = new NotificationCompat.Builder(MainActivity.this, "myapp")
                        .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                        .setContentTitle("My Notification")
                        .setContentText("This is my first notification")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.banner)).setBigContentTitle("The banner is big! its very very big!"))
                        .build();
                notificationManager.notify(new Random().nextInt(), bigPictureStyleNotification);

                break;
            case R.id.btn_bigTextStyleNotification:
                Notification bigTextStyleNotification = new NotificationCompat.Builder(MainActivity.this, "myapp")
                        .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                        .setContentTitle("My Notification")
                        .setContentText("This is my first notification")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is my first notificationThis is my first notificationThis is my first notificationThis is my first notificationThis is my first notificationThis is my first notificationThis is my first notificationThis is my first notification"))
                        .build();
                notificationManager.notify(new Random().nextInt(), bigTextStyleNotification);
break;
            case R.id.btn_inboxStyleNotification:
                Notification inboxStyleNotification = new NotificationCompat.Builder(MainActivity.this, "myapp")
                        .setSmallIcon(R.drawable.ic_baseline_music_note_24)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                        .setContentTitle("My Notification")
                        .setContentText("This is my first notification")
                        .setStyle(new NotificationCompat.InboxStyle().addLine("This is my first notification")
                                .addLine("This is my second notification")
                                .addLine("This is my third notification"))
                        .build();
                notificationManager.notify(new Random().nextInt(), inboxStyleNotification);


        }
    }
}