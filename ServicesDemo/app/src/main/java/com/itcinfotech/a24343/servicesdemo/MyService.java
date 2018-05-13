package com.itcinfotech.a24343.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 24343 on 10/12/2017.
 */

public class MyService extends Service
{
    MediaPlayer myPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
           Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();

       // myPlayer = MediaPlayer.create(this, R.raw.sun);

        myPlayer.setLooping(false); // Set looping

    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }

}
