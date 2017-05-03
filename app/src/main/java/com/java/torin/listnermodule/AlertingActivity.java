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
        short[] tempBuffer;


        int i =0;
       while(Lis.recordingState()) {
           tempBuffer = Lis.buffer;
           if (tempBuffer[i] > 2000) {
               Log.v("SWITCH", "Switched");
               s.Switch();
               Lis.stopLis();
               break;

           }
           i++;

             }

        }
    public  void timeBasedRead (int Time,int Value){
        short[] tempBuffer=Lis.buffer;
        int timeToTimes = (((Time/60*60)/1000)/10)*8;
        for(int j = 0;j<timeToTimes;j++) {
            for (int i = 0; i < 800; i++) {
                if (i == 0) {
                    tempBuffer = Lis.buffer;

                }
                if (tempBuffer[i] > Value) {
                    Log.v("SWITCH", "Switched");
                    s.Switch();
                    Lis.stopLis();
                    break;
                }
            }
        }
    }

    }

