package com.example.chciabymbyckolejarzem.ConnectionService;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class ConnectionServiceImpl {

    private Socket socket;

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
        socket.on("userlogin", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                listener.call();
            }
        });
    }

    public void setOnDisconnect(final EmptyEventListener listener) {
        socket.on("userdisconnect", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                listener.call();
            }
        });
    }

    public void setOnGetStats(final EventListener listener) {
        socket.on("myStats", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                    JSONObject data = (JSONObject) args[0];
                    try {
                        int pkt = data.getInt("pkt");
                        listener.call(pkt);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
