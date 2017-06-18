package com.java.torin.listnermodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Admin on 5/16/2017.
 */

public class BolTherapistActivity extends AppCompatActivity {
    SignInHelper s =  SignInHelper.getInstance();
    Button yes;
    Button no;
    Intent myIntent;
    Intent myIntent2;

    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked


            startActivity(myIntent);
       }
    };
    private View.OnClickListener List = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked



            startActivity(myIntent2);
       }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bol_therapist_activity);
        yes = (Button) findViewById(R.id.yes);
        no= (Button) findViewById(R.id.no);
        myIntent = new Intent(this, TherapistEmailActivity.class);
        myIntent2 = new Intent(this, NormActivity.class);
        yes.setOnClickListener(Listener);
        no.setOnClickListener(List);


    }
}
