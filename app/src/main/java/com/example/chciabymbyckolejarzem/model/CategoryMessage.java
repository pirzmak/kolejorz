package com.example.chciabymbyckolejarzem.model;

public class CategoryMessage extends Message {
    private String category;

    public CategoryMessage(String userId, String category) {
        super(userId);
        this.category = category;
    }
}
