package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Admin on 4/17/2017.
 */

public class AlertingActivity extends AppCompatActivity {
    ListenerActivity Lis = new ListenerActivity();
    SwitchOver s = new SwitchOver();

    public void read(){
        short[] tempBuffer = Lis.buffer;
        int i =0;
       while(Lis.recordingState()) {
           if (tempBuffer[i] > 2000) {
               Log.v("SWITCH", "Switched");
               s.Switch();
               Lis.stopLis();
               break;

           }
           i++;

             }

        }

    }

