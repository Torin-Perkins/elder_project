package com.java.torin.listnermodule;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioTimestamp;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Admin on 6/8/2017.
 */

public class ListsenerIntentService extends IntentService {
    public ListsenerIntentService() {
        super("ListenerIntentService");
    }

    ListenerHelper Listener ;
    Vibrator v ;
    AudioTimestamp at;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onHandleIntent(Intent intent) {
        at=new AudioTimestamp();
        intent = new Intent(this, AlertingActivity.class);
        Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis()){
            //Listener.record.getTimestamp(at,AudioTimestamp.TIMEBASE_MONOTONIC);
            Listener.stopLis();
           // v.vibrate(3000);
            //startActivity(intent);
            Intent localIntent = new Intent("name");
            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
        }
    }

}
