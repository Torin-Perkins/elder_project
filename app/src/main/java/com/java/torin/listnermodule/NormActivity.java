package com.java.torin.listnermodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Admin on 5/18/2017.
 */

public class NormActivity extends AppCompatActivity {
    SignInHelper s =  SignInHelper.getInstance();
    Button yes;
    Button no;
    Intent myIntent;
    TextView t;
    Vibrator b ;

    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked


    //Toast.makeText(getApplicationContext(),"REC",Toast.LENGTH_LONG).show()
            b.vibrate(500);
    t.setText("DONE");
    s.getNorm(t);




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
        setContentView(R.layout.norm_activity);
        yes = (Button) findViewById(R.id.button);
        no= (Button) findViewById(R.id.button2);
        b = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        myIntent = new Intent(this, YellActivity.class);
        t = (TextView) findViewById(R.id.textView9);
        yes.setOnClickListener(Listener);
        no.setOnClickListener(List);



    }


}
