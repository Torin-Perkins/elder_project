package com.java.torin.listnermodule;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IntroActivity extends AppCompatActivity {
    private View.OnClickListener onClick = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked


            startActivity(myIntent);
        }
    };

    Intent myIntent;
    ListenerHelper Listener ;
    Vibrator v ;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = (ImageButton) findViewById(R.id.Next);
        myIntent = new Intent(this, NameActivity.class);
        next.setOnClickListener(onClick);
       /* Listener = new ListenerHelper();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Listener.runListener();
        if(Listener.isOverLis()){
            v.vibrate(1000);
        }
*/




    }








}
