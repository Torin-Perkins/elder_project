package com.java.torin.listnermodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Admin on 4/29/2017.
 */

public class SwitchOver extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void Switch(){
        Intent u = new Intent(getApplicationContext(), AlertingActivity.class);
        startActivity(u);
    }
}
