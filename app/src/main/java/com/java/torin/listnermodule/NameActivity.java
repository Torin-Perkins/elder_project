package com.java.torin.listnermodule;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Admin on 5/13/2017.
 */

public class NameActivity extends AppCompatActivity  {
    SignInHelper s = new SignInHelper();
    EditText firstName, lastName;
    ImageButton next;
    Intent myIntent;

    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked

            s.firstName = getFirstName();
            s.lastName = getLastName();
            startActivity(myIntent);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);
        next = (ImageButton) findViewById(R.id.Next);
        myIntent = new Intent(this, EmailActivity.class);
        next.setOnClickListener(Listener);


    }
    public String getFirstName(){
        firstName = (EditText) findViewById(R.id.FirstName);
        String newString = firstName.getText().toString();


        while(!newString.isEmpty()  ){
            if(!newString.equals("First Name") || !newString.isEmpty()){
                return newString;
            }

        }
return null;
    }
    public String getLastName(){
        lastName = (EditText) findViewById(R.id.LastName);
        String newString = lastName.getText().toString();


        while(!newString.isEmpty()  ){
            if(!newString.equals("Last Name") || newString.isEmpty()){
                return newString;
            }

        }
return null;
    }






}
