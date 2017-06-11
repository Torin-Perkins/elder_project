package com.java.torin.listnermodule;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
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
    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {

            messagetEt = (EditText)

                            findViewById(R.id.email);

            String message = messagetEt.getText().toString();
            String phoneNo = si.Email;//mPhoneNoEt.getText().toString();




                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(si.Email, null, message, null, null);
                Log.v("SENT","SENT");
             startActivity(myIntent);


        }

    };
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.alert_activity);
            myIntent = new Intent(this,ListenerActivity.class);
            b = (Button) findViewById(R.id.button3);
            v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(3000);
            b.setOnClickListener(Listener);
        }



}

