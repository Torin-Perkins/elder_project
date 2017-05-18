package com.java.torin.listnermodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Admin on 5/18/2017.
 */

public class WhisperActivity extends AppCompatActivity {
    SignInHelper s = new SignInHelper();
    Button yes;
    Button no;
    Intent myIntent;


    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked


    s.getWhisper();
        }
    };
    private View.OnClickListener List = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked



            startActivity(myIntent);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whisper_activity);
        yes = (Button) findViewById(R.id.button);
        no= (Button) findViewById(R.id.button2);
        myIntent = new Intent(this, TherapistEmailActivity.class);
        yes.setOnClickListener(Listener);
        no.setOnClickListener(List);


    }


}
