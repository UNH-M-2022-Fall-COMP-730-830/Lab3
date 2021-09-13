package com.example.tipcalculator;

// TODO 1: Turn TipSettings into Singleton
public class TipSettings {
    private int tipPercent = 20;
    private int tipStrategy = 0;

    public int getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(int value) {
        tipPercent = value;
    }

    public int getTipStrategy() {
        return tipStrategy;
    }

    public void setTipStrategy(int value) {
        tipStrategy = value;
    }
}
