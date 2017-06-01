package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ListenerActivity extends AppCompatActivity {


    Button start;
    Button stop;
    Intent myIntent;
    Intent myIntent2;
    ListenerHelper Listener ;
    Vibrator v ;
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
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listener_activity);
        start = (Button) findViewById(R.id.button);
        stop= (Button) findViewById(R.id.button2);
        myIntent = new Intent(this, ListenerService.class);

        start.setOnClickListener(listener);
        stop.setOnClickListener(List);
       /*
        Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis()){
            v.vibrate(1000);
            */





    }








}
