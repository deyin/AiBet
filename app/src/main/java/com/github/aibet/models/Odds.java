package com.github.aibet.models;

public class Odds {

    private OddsType type;

    private double value;

    public Odds(OddsType type, double value) {
        this.type = type;
        this.value = value;
    }
}
