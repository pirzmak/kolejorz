package com.example.chciabymbyckolejarzem.model;

public class CategoryChoose extends Messages {
    private String category;

    public CategoryChoose(String userId, String category) {
        super(userId);
        this.category = category;
    }
}
