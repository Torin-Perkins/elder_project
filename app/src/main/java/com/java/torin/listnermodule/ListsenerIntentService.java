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
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 6/8/2017.
 */

public class ListsenerIntentService extends IntentService {
    public ListsenerIntentService() {
        super("ListenerIntentService");
    }

    ListenerHelper Listener = new ListenerHelper();
    Vibrator v ;
    AudioTimestamp at;
    Toast toast;
    Intent myIntent3;
    Boolean stop=false;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onHandleIntent(Intent intent) {
        toast = Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT);
        toast.show();
        at=new AudioTimestamp();
        myIntent3 = new Intent(this , IntroActivity.class);
        intent = new Intent(this, AlertingActivity.class);
        Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis(toast,getApplicationContext())){
            //Listener.record.getTimestamp(at,AudioTimestamp.TIMEBASE_MONOTONIC);
            stop=true;
            Log.i("STOP",""+stop);

            Listener.stopLis();

           // v.vibrate(3000);
            //startActivity(intent);
            Intent localIntent = new Intent("name");
            LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
        }
    }

    public void onDestroy(){
        Listener.getValidSampleRates();

        super.onDestroy();
        Log.i("STOP",""+stop);
        if(!stop)
             { Listener.stopLis();
             //Listener.release();
             }
    }


}
