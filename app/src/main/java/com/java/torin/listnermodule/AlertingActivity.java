package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Admin on 4/17/2017.
 */

public class AlertingActivity extends AppCompatActivity {
    ListenerActivity Lis = new ListenerActivity();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_activity);
    }
    public void read(){
        short[] tempBuffer = Lis.buffer;
        for(int i=1;i<50; i++){
             if(tempBuffer[i]>80){
                 Intent u = new Intent(getApplicationContext(), AlertingActivity.class);
                 startActivity(u);

                 Lis.stopLis();
                 break;
             }

        }

    }
}
