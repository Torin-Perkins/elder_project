package com.java.torin.listnermodule;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;

public class ListenerActivity extends AppCompatActivity {



    ListenerHelper Listener ;
    Vibrator v ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_activity);
        Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis()){
            v.vibrate(1000);
        }




    }








}
