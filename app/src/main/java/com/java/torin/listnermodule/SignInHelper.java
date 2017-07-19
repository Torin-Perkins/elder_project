package com.java.torin.listnermodule;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import javax.inject.Singleton;
import javax.xml.datatype.Duration;

import static android.media.AudioFormat.CHANNEL_IN_MONO;
import static android.media.AudioFormat.ENCODING_PCM_16BIT;
import static android.media.AudioRecord.RECORDSTATE_RECORDING;
import static android.media.MediaRecorder.AudioSource.MIC;

/**
 * Created by Admin on 5/12/2017.
 */

@Singleton
public class SignInHelper extends AppCompatActivity{

    private static SignInHelper INSTANCE;

    public static SignInHelper getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SignInHelper();
        return INSTANCE;
    }

    int bufferSize;
    AudioRecord record ;
    private int minSize = 0;
    short[] buffer = new short[bufferSize];
    String AudioSavePathInDevice = null;
    Random random = new Random();
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    int whisper;
    int normal;
    int yell;
    int Threshold;
    String firstName;
    String lastName;
    String Email;
    Boolean Therapist;
    String TherapistEmail = "";
    boolean setAct = false;

    // Vibrate for 500 milliseconds


    public void runListener() {
        getValidSampleRates();
        start(record);
        //record.read();
    }

    public void stopLis() {
        stop(record);
    }


    private void getValidSampleRates() {
        for (int rate : new int[]{8000, 11025, 16000, 22050, 44100}) {  // add the rates you wish to check against
            bufferSize = AudioRecord.getMinBufferSize(rate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
            if (bufferSize > 0) {
                // buffer size is valid, Sample rate supported
                record = new AudioRecord(MIC, rate, CHANNEL_IN_MONO, ENCODING_PCM_16BIT, bufferSize);
            }
        }
    }


    private void start(AudioRecord record) {
        record.startRecording();
    }

    private void stop(AudioRecord record) {
        record.stop();
        record.release();

    }

    protected boolean recordingState() {
        return record.getRecordingState() == RECORDSTATE_RECORDING;
    }

    public void show(TextView t){
        t.setText("REC");
    }
    public int getRec( TextView t) {




        short[] tempBuffer = null;
        int y = 0;
        int i = 0;

        runListener();
        buffer = new short[bufferSize];

        Log.v("READ", "" + Arrays.toString(buffer));

        for(int j = 0; j < 100;j++) {

            record.read(buffer, 0, bufferSize);

            for (int k = 0; k < 800; k++) {
                if (k == 0) {
                    tempBuffer = buffer;
                    y=0;
                }
                y = y + tempBuffer[k];

                if(Math.abs(y)>i){
                    i=y;
                }




            }
            Log.v("y", "" + i);
            Log.v("j", "" + j);

        }

        stopLis();
       // t.setText("");
        return i;
    }

  /*  public int getRecSingle(final TextView t){
        runListener();
        buffer = new short[bufferSize];

        short[] tempBuffer = null;
        int y = 0;
        int i = 0;

        CountDownTimer ct = new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long l) {
                t.setText("seconds remaining: " + l/1000);
            }

            @Override
            public void onFinish() {
                t.setText("done!");
            }
        };
        ct.start();

        record.read(buffer, 0, bufferSize);
        Log.v("READ", "" + Arrays.toString(buffer));


            for (int k = 0; k < 800; k++) {
                if (k == 0) {
                    tempBuffer = buffer;
                    y=0;
                }
                y = y + tempBuffer[k];

                if(Math.abs(y)>i){
                    i=y;
                }

                Log.v("y", "" + i);
                Log.v("j", "" + j);


            }


        }

        stopLis();

        return i;
    }*/

    public void getWhisper(TextView t){
        whisper=getRec(t);
    }
    public void getNorm(TextView t){


        normal=getRec(t);
    }
    public void getYell(TextView t,Context context){
        yell=getRec(t);



        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("YELL", yell);
        editor.apply();
        Log.v("THING", ""+yell);

    }
    public void calcValForThresh(){
        Threshold=normal + whisper;
    }


    }

