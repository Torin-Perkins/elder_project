package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.Random;

import static android.media.AudioFormat.CHANNEL_IN_MONO;
import static android.media.AudioFormat.ENCODING_PCM_16BIT;
import static android.media.AudioRecord.RECORDSTATE_RECORDING;
import static android.media.MediaRecorder.AudioSource.MIC;

/**
 * Created by Admin on 4/15/2017.
 */

public class ListenerHelper extends AppCompatActivity{
    int bufferSize;
    AudioRecord record;
    private int minSize = 0;
    short[] buffer = new short[bufferSize];
    String AudioSavePathInDevice = null;
    Random random = new Random();
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    SignInHelper si = SignInHelper.getInstance();


    // Vibrate for 500 milliseconds

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void runListener(){
        getValidSampleRates();
        start(record);
        //read(record);
    }
    public void stopLis(){
        stop(record);
    }


    private void getValidSampleRates() {
        for (int rate : new int[] {8000, 11025, 16000, 22050, 44100}) {  // add the rates you wish to check against
            bufferSize = AudioRecord.getMinBufferSize(rate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
            if (bufferSize > 0) {
                // buffer size is valid, Sample rate supported
                record = new AudioRecord(MIC, rate,CHANNEL_IN_MONO, ENCODING_PCM_16BIT,bufferSize);
            }
        }
    }


    private void start(AudioRecord record){
        record.startRecording();
    }
    private void stop(AudioRecord record){ record.stop();
        record.release();
    }
    protected boolean recordingState(){
        return record.getRecordingState() == RECORDSTATE_RECORDING;
    }
    private void read(AudioRecord record){
         buffer = new short[bufferSize];
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        short[]tempBuffer=null;
        int y =0;
        while(record.getRecordingState()== RECORDSTATE_RECORDING) {
            record.read(buffer, 0, bufferSize);

            Log.v("READ",""+ Arrays.toString(buffer));
            for(int k=0;k<800;k++){
                if (k == 0) {
                    tempBuffer =buffer;

                }
                y=y+tempBuffer[k];
                if(y>1053458){
                    Log.v("Switch","SWITCH");
                    v.vibrate(500);
                    break;
                }
                Log.v("y",""+y);
            }
        }
    }


    public boolean isOverLis(){
        buffer = new short[bufferSize];
        boolean toReturn = false;
        short[]tempBuffer=null;
        int y =0;
        si = new SignInHelper();
        while(record.getRecordingState()== RECORDSTATE_RECORDING) {
            record.read(buffer, 0, bufferSize);

            Log.v("READ",""+ Arrays.toString(buffer));
            for(int k=0;k<800;k++){
                if (k == 0) {
                    tempBuffer =buffer;
                    y=0;
                }
                y=y+tempBuffer[k];
                if(y>=si.yell){
                    Log.v("Switch","SWITCH");
                   toReturn = true;
                    return true;
                    //break;//return true;

                }
                Log.v("y",""+y);
            }
        }

        return toReturn;//return false;
    }
    public void createSaver(){
        AudioSavePathInDevice =
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/" +
                        CreateRandomAudioFileName(5) + "AudioRecording.3gp";
    }
    public String CreateRandomAudioFileName(int string){
        StringBuilder stringBuilder = new StringBuilder( string );
        int i = 0 ;
        while(i < string ) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));

            i++ ;
        }
        return stringBuilder.toString();
    }
    int next = 1;
    public boolean cycler(){
boolean thing = false;
        if(next == 1){
            thing = true;

        }

        return thing;
    }
}
