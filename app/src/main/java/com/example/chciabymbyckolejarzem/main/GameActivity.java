package com.example.chciabymbyckolejarzem.main;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chciabymbyckolejarzem.ConnectionService.ConnectionServiceImpl;
import com.example.chciabymbyckolejarzem.R;
import com.example.chciabymbyckolejarzem.model.AnswerMessage;
import com.example.chciabymbyckolejarzem.model.BOOST;
import com.example.chciabymbyckolejarzem.model.BoostMessage;
import com.example.chciabymbyckolejarzem.model.CategoryMessage;
import com.example.chciabymbyckolejarzem.model.CategoryResponse;
import com.example.chciabymbyckolejarzem.model.StatsMessage;

public class GameActivity extends AppCompatActivity {
    private ConnectionServiceImpl service;

    //user
    //public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        service = new ConnectionServiceImpl("", "");

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
