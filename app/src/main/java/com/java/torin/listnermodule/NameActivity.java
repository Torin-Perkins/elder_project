package com.java.torin.listnermodule;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Admin on 5/13/2017.
 */

public class NameActivity extends AppCompatActivity  {
    SignInHelper s = SignInHelper.getInstance();
    EditText firstName, phone;
    ImageButton next;
    Intent myIntent;

    private View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked

            s.firstName = getFirstName();
            s.Email = getLastName();
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("Name", getFirstName());
            editor.putString("Phone",getLastName());
            editor.apply();
            Log.i("PHONE",""+s.Email);
            startActivity(myIntent);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);
        next = (ImageButton) findViewById(R.id.Next);
        myIntent = new Intent(this, NormActivity.class);
        next.setOnClickListener(Listener);


    }
    public String getFirstName(){
        firstName = (EditText) findViewById(R.id.editText);
        String newString = firstName.getText().toString();

        return newString;

    }
    public String getLastName(){
        phone = (EditText) findViewById(R.id.editText2);
        String newString = phone.getText().toString();


      return newString;
    }






}
