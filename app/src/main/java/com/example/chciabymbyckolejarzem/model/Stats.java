package com.example.chciabymbyckolejarzem.model;

public class Stats extends Response {
    private int pkt;

    public Stats(int pkt) {
        this.pkt = pkt;
    }

    public int getPkt() {
        return pkt;
    }

    public void setPkt(int pkt) {
        this.pkt = pkt;
    }
}
