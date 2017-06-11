package com.java.torin.listnermodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Admin on 5/16/2017.
 */

public class EmailActivity extends AppCompatActivity {
    SignInHelper s = SignInHelper.getInstance();
    EditText email;
    ImageButton next;
    Intent myIntent;

    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked

            s.Email = getEmail();

            startActivity(myIntent);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activity);
        next = (ImageButton) findViewById(R.id.Next);
        myIntent = new Intent(this, BolTherapistActivity.class);
        next.setOnClickListener(Listener);


    }

    public String getEmail(){
        email = (EditText) findViewById(R.id.email);
        String newString = email.getText().toString();



        return newString;
    }
}
