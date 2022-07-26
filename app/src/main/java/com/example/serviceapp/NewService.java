package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NewService extends Service {
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service: onStartCommand()", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        // starting the process
        player.start();
        //returns the status
        // of the program

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service: onDestroy()", Toast.LENGTH_LONG).show();
        // stopping the process
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Service: onBind()", Toast.LENGTH_LONG).show();
        return null;
    }
}
