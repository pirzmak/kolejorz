package com.example.chciabymbyckolejarzem.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chciabymbyckolejarzem.R;
import com.example.chciabymbyckolejarzem.loggingpage;


public class MainActivity extends AppCompatActivity {


    private Button btn;
    private EditText nickname;
    public static final String NICKNAME = "usernickname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*** Called when the user taps the Next button */
    public void startbutton(View view) {
        Intent intent = new Intent(this, loggingpage.class);
        startActivity(intent);
        // Do something in response to button
    }
}
