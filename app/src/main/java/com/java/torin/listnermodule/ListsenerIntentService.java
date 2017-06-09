package com.java.torin.listnermodule;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Admin on 6/8/2017.
 */

public class ListsenerIntentService extends IntentService {
    public ListsenerIntentService(String name) {
        super(name);
    }

    ListenerHelper Listener ;
    Vibrator v ;

    @Override
    protected void onHandleIntent(Intent intent) {
        intent = new Intent(this, AlertingActivity.class);
        Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis()){
           // v.vibrate(3000);
            //startActivity(intent);
            Intent localIntent = new Intent("name");
            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
        }
    }

}
