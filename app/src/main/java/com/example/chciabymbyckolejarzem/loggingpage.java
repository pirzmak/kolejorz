package com.example.chciabymbyckolejarzem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loggingpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingpage);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
    }

    /*** Called when the user taps the Next button */
    public void connectbutton(View view) {
        Intent intent = new Intent(this, afterlogging.class);
        startActivity(intent);
        // Do something in response to button
    }
}
