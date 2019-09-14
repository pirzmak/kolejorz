package com.example.chciabymbyckolejarzem.model;

public class AnswerMessage extends Message {
    private String answer;

    public AnswerMessage(String userId, String answer) {
        super(userId);
        this.answer = answer;
    }
}
