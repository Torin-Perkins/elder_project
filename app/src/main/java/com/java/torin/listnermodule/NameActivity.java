package com.java.torin.listnermodule;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Admin on 5/13/2017.
 */

public class NameActivity extends AppCompatActivity {
    SignInHelper s = new SignInHelper();
    EditText firstName, lastName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);
        s.firstName = getFirstName();



    }
    public String getFirstName(){
        String newString = firstName.getText().toString();
        firstName = (EditText) findViewById(R.id.FirstName);

        while(newString.equals("First Name") ){
            if(!newString.equals("FirstName") || newString.isEmpty()){
                return newString;
            }

        }
        return null;
    }





}
