package com.java.torin.listnermodule;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 4/17/2017.
 */

public class AlertingActivity extends AppCompatActivity {
    ListenerHelper Lis = new ListenerHelper();
    SwitchOver s = new SwitchOver();
    Vibrator v;
    CheckBox cb;
    EditText messagetEt;
    Button b;
    Intent myIntent;
    SignInHelper si =  SignInHelper.getInstance();
    String message;
    Toast toast;
    Intent myIntent3;
String phone;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.alert_activity);
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String name = settings.getString("Name", null);
             phone = settings.getString("Phone", null);
            myIntent3 = new Intent(this , IntroActivity.class);
Log.v("PHONE",""+phone);
            myIntent = new Intent(this,ListenerActivity.class);
            b = (Button) findViewById(R.id.button3);
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            //Calendar c= Calendar.getInstance();
          //  int minutes = c.get(Calendar.MINUTE);
            try {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
            } catch (Exception e) {
                e.printStackTrace();
            }

           // Log.v("MIN",""+ minutes);
            v.vibrate(3000);


            messagetEt = (EditText)

                    findViewById(R.id.email);

             message = name + " has shown stress";

            SmsManager smsManager = SmsManager.getDefault();
            try {
                smsManager.sendTextMessage(phone, null, message, null, null);
            }
            catch (IllegalArgumentException e){
                Log.i("PHONE",""+phone);
                toast = Toast.makeText(getApplicationContext(),"Invalid Phone Number please try again",Toast.LENGTH_SHORT);
                toast.show();
                startActivity(myIntent3);
            }

            b.setOnClickListener(Listener);
        }


    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {


            message = messagetEt.getText().toString() + " ";

            Log.v("Phone",""+si.Email);
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, message, null, null);
            Log.v("SENT","SENT");

            startActivity(myIntent);


        }

    };
}





/*
TODO


UI changes
    Logo as button
    change text/grammar
    talk to kristina about UI

 */

