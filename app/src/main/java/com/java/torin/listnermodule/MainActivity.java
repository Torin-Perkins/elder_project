package com.java.torin.listnermodule;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

import static android.media.AudioFormat.CHANNEL_IN_MONO;
import static android.media.AudioFormat.ENCODING_PCM_16BIT;
import static android.media.AudioRecord.RECORDSTATE_RECORDING;
import static android.media.AudioRecord.getMinBufferSize;
import static android.media.MediaRecorder.AudioSource.MIC;

public class MainActivity extends AppCompatActivity {



    ListenerActivity Listener = new ListenerActivity();
    AlertingActivity a = new AlertingActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Listener.runListener();
        a.timeBasedRead(1,2000);


    }








}
