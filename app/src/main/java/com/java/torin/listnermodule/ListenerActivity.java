package com.java.torin.listnermodule;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ListenerActivity extends AppCompatActivity {

    SignInHelper s =  SignInHelper.getInstance();
    ImageButton start;
    ImageButton stop;
    Intent myIntent;
    Intent myIntent2;
    Intent myIntent3;
    ListenerHelper Listener ;
    Vibrator v ;
    Button res;



    private View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked


            startService(myIntent);
        }
    };
    private View.OnClickListener List = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked



            stopService(myIntent);
            startActivity(myIntent2);
        }
    };
    private View.OnClickListener re = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked

            stopService(myIntent);
            startActivity(myIntent3);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listener_activity);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();


        editor.putBoolean("Service", false);
        editor.apply();
        Listener = new ListenerHelper();
        start = (ImageButton) findViewById(R.id.Button);
        stop= (ImageButton) findViewById(R.id.Button2);
        res = (Button) findViewById(R.id.button4);
        myIntent = new Intent(this, ListsenerIntentService.class);
        myIntent2 = new Intent(this , AlertingActivity.class);
        myIntent3 = new Intent(this , IntroActivity.class);

        editor.putBoolean("seen", true);
        editor.apply();
        Context context;
//Listener.cycler(myIntent3);
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        PackageManager pm = getApplicationContext().getPackageManager();
        int hasPerm = pm.checkPermission(
                Manifest.permission.RECORD_AUDIO,
                getApplicationContext().getPackageName());
        if ((hasPerm != PackageManager.PERMISSION_GRANTED)) {
            startActivity(myIntent3);
        }
        /*
        if(preferences.getBoolean("seen",true)){
            startActivity(myIntent3);
        }
*/

        LocalBroadcastManager.getInstance(this).registerReceiver(listenerbroadcastreceiver,listenerintentfilter);



        start.setOnClickListener(listener);
        stop.setOnClickListener(List);
        res.setOnClickListener(re);
       /*
        Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis()){
            v.vibrate(1000);
            */





    }

private final IntentFilter listenerintentfilter = new IntentFilter("name");



private final BroadcastReceiver listenerbroadcastreceiver= new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        stopService(myIntent);
        startActivity(myIntent2);
        Log.v("SERVICE","got = service");
    }
};
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

}
