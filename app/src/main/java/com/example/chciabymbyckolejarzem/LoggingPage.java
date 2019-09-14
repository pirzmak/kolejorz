package com.example.chciabymbyckolejarzem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.chciabymbyckolejarzem.main.GameActivity;
import com.example.chciabymbyckolejarzem.model.User;

public class LoggingPage extends AppCompatActivity {
    public static final String login_message ="login";
    public static final String password_message ="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingpage);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
    }

    /*** Called when the user taps the Next button */
    public void connectbutton(View view) {
        Intent intent = new Intent(this, GameActivity.class);

        // Do something in response to button
        EditText logint = (EditText) findViewById(R.id.editText);
        EditText passwordt = (EditText) findViewById(R.id.editText2);
        String login = logint.getText().toString();
        String password = passwordt.getText().toString();
        intent.putExtra(login_message, login);
        intent.putExtra(password_message, password);
        startActivity(intent);
    }
}
