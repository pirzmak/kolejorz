package com.example.chciabymbyckolejarzem.model;

import java.util.List;

public class QuestionResponse extends Response {
    private String question;
    private List<BOOST> boosts;

    public QuestionResponse(String question, List<BOOST> boosts) {
        this.question = question;
        this.boosts = boosts;
    }
}
