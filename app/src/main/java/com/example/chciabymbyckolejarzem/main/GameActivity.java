package com.example.chciabymbyckolejarzem.main;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chciabymbyckolejarzem.ConnectionService.ConnectionServiceImpl;
import com.example.chciabymbyckolejarzem.LoggingPage;
import com.example.chciabymbyckolejarzem.R;
import com.example.chciabymbyckolejarzem.model.AnswerMessage;
import com.example.chciabymbyckolejarzem.model.BOOST;
import com.example.chciabymbyckolejarzem.model.BoostMessage;
import com.example.chciabymbyckolejarzem.model.CategoryMessage;
import com.example.chciabymbyckolejarzem.model.StatsMessage;
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

        service.getStats(new StatsMessage("asd"), v -> onGetStats((Integer)v));
        service.chooseCategory(new CategoryMessage("asd", "test"), v -> Log.d("TEST", "chooseCategory"));
        service.addBoost(new BoostMessage("asd", "asd", BOOST.FROZEN), v -> Log.d("TEST", "boost"));
        service.answerQuestion(new AnswerMessage("asd", "asd"), v -> Log.d("TEST", "answer"));

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
