package com.example.chciabymbyckolejarzem.main;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chciabymbyckolejarzem.ConnectionService.ConnectionServiceImpl;
import com.example.chciabymbyckolejarzem.LoggingPage;
import com.example.chciabymbyckolejarzem.R;
import com.example.chciabymbyckolejarzem.model.User;

public class GameActivity extends AppCompatActivity {
    private ConnectionServiceImpl service;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String login = intent.getStringExtra(LoggingPage.login_message);
        String password = intent.getStringExtra(LoggingPage.password_message);

        User user=new User(login,password);


        service = new ConnectionServiceImpl(login, password);

        service.setOnLogin(() -> runOnUiThread(() ->
                Toast.makeText(GameActivity.this, "User connected", Toast.LENGTH_SHORT).show()
        ));

        service.setOnDisconnect(() -> runOnUiThread(() ->
                Toast.makeText(GameActivity.this, "User disconnect", Toast.LENGTH_SHORT).show()
        ));

        service.setOnGetStats(v -> onGetStats((Integer)v));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        service.disconnect();
    }

    private void onGetStats(Integer pkt) {
        //TODO
    }
}
