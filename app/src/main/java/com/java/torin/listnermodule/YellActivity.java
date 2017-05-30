package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Admin on 5/18/2017.
 */

public class YellActivity extends AppCompatActivity {
    SignInHelper s = new SignInHelper();
    Button yes;
    Button no;
    Intent myIntent;
    Vibrator b ;

    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked



    s.getYell();
            b = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            b.vibrate(2000);
            Toast.makeText(getApplicationContext(),"Done listening please press next",Toast.LENGTH_SHORT).show();

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
        yes.setOnClickListener(Listener);
        no.setOnClickListener(List);


    }


}
