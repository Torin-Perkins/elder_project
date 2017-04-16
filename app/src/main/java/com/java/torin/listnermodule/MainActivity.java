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
//ADD PERMISSION DUMB ASS CMON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



    int bufferSize;
    AudioRecord record;
    private int minSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

getValidSampleRates();
        start(record);
        read(record);
    }


    public void getValidSampleRates() {
        for (int rate : new int[] {8000, 11025, 16000, 22050, 44100}) {  // add the rates you wish to check against
           bufferSize = AudioRecord.getMinBufferSize(rate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
            if (bufferSize > 0) {
                // buffer size is valid, Sample rate supported
                 record = new AudioRecord(MIC, rate,CHANNEL_IN_MONO, ENCODING_PCM_16BIT,bufferSize);
            }
        }
    }


    public void start(AudioRecord record){
        record.startRecording();
    }

    public void read(AudioRecord record){
        short[] buffer = new short[bufferSize];
        while(record.getRecordingState()== RECORDSTATE_RECORDING) {
            record.read(buffer, 0, bufferSize);

            Log.v("READ",""+ Arrays.toString(buffer));
        }
    }





}
