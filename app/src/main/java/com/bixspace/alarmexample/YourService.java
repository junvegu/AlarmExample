package com.bixspace.alarmexample;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class YourService extends Service
{
    Alarm alarm = new Alarm();
    public void onCreate()
    {
        super.onCreate();       
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) 
    {
        alarm.setAlarm(this);
        return START_STICKY;
    }

   @Override        
   public void onStart(Intent intent, int startId)
    {
        alarm.setAlarm(this);
    }

    @Override
    public IBinder onBind(Intent intent) 
    {
        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        alarm.cancelAlarm(this);
    }
}