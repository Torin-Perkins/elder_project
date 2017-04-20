package com.java.torin.listnermodule;

import android.content.Context;
import android.os.Vibrator;

/**
 * Created by Admin on 4/17/2017.
 */

public class AlertingActivity extends MainActivity {
    ListenerActivity Lis = new ListenerActivity();
    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    public void read(){
        short[] tempBuffer = Lis.buffer;
        for(int i=1; i==50; i++){
             if(tempBuffer[i]>80){
                v.vibrate(1000);
                 i++;
             }
        }

    }
}
