package com.example.chciabymbyckolejarzem.ConnectionService;

import com.example.chciabymbyckolejarzem.model.AnswerMessage;
import com.example.chciabymbyckolejarzem.model.BoostMessage;
import com.example.chciabymbyckolejarzem.model.CategoryMessage;
import com.example.chciabymbyckolejarzem.model.CategoryResponse;
import com.example.chciabymbyckolejarzem.model.QuestionResponse;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;

import java.net.URISyntaxException;

public class ConnectionServiceImpl {

    private Socket socket;
    private Gson gson = new Gson();

    public ConnectionServiceImpl(String login,
                                 String password) {
        try {
            socket = IO.socket("http://17a2215f.ngrok.io");
            socket.connect();
            socket.emit("join", login);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        socket.disconnect();
    }

    public void setOnLogin(final EmptyEventListener listener) {
        socket.on("userlogin", args -> listener.call());
    }

    public void setOnDisconnect(final EmptyEventListener listener) {
        socket.on("userdisconnect", args -> listener.call());
    }

    public void getStats(CategoryMessage msg,  final EventListener<Integer> listener) {
        socket.emit("getstats", gson.toJson(msg));

        socket.on("statsresponse", args -> {
            String data = (String) args[0];
            Integer response = gson.fromJson(data, Integer.class);
            listener.call(response);
        });
    }

    public void chooseCategory(CategoryMessage msg, final EventListener<CategoryResponse> onGet) {
        socket.emit("choosecategory", gson.toJson(msg));

        socket.on("categoryresponse", args -> {
            String data = (String) args[0];
            CategoryResponse response = gson.fromJson(data, CategoryResponse.class);
            onGet.call(response);
        });
    }

    public void addBoost(BoostMessage msg, final EventListener<QuestionResponse> onGet) {
        socket.emit("addboost", gson.toJson(msg));

        socket.on("questionrespone", args -> {
            String data = (String) args[0];
            QuestionResponse response = gson.fromJson(data, QuestionResponse.class);
            onGet.call(response);
        });
    }

    public void answerQuestion(AnswerMessage msg, final EventListener<Object> onGet) {
        socket.emit("answerQuestion", gson.toJson(msg));

        socket.on("answerResponse", args -> {
            String data = (String) args[0];
            Object response = gson.fromJson(data, Object.class);
            onGet.call(response);
        });
    }
}

