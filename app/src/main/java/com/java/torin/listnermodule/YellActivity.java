package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Admin on 5/18/2017.
 */

public class YellActivity extends AppCompatActivity {
    SignInHelper s =  SignInHelper.getInstance();
    Button yes;
    Button no;
    Intent myIntent;
    Vibrator b ;
    TextView t;


    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked



    //
             s.getYell(t,getApplicationContext());


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
        setContentView(R.layout.yell_activity);
        yes = (Button) findViewById(R.id.button);
        no= (Button) findViewById(R.id.button2);
        myIntent = new Intent(this, ListenerActivity.class);
        t = (TextView) findViewById(R.id.textView7);
        yes.setOnClickListener(Listener);
        no.setOnClickListener(List);


    }
    @Override
    protected void onDestroy() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences.Editor editor = preferences.edit();
        preferences.edit().putBoolean("seen",false).apply();

        s.setAct = true;
       // editor.apply();
        super.onDestroy();
    }


}
