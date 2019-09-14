package com.example.chciabymbyckolejarzem.model;

public class BoostMessage extends Message {
    private String receiver;
    private BOOST boost;

    public BoostMessage(String userId, String receiver, BOOST boost) {
        super(userId);
        this.receiver = receiver;
        this.boost = boost;
    }
}
