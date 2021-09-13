package com.example.tipcalculator;

import com.example.tipcalculator.tipstrategy.DefaultTipStrategy;
import com.example.tipcalculator.tipstrategy.TipStrategy;

// Singleton class
public class TipSettings {
    private int tipPercent = 20;
    private TipStrategy tipStrategy = new DefaultTipStrategy();

    private static TipSettings INSTANCE;

    private TipSettings() {
    }

    public static TipSettings getInstance() {
        // Lazy initialization. INSTANCE won't be initialized until the first getInstance() call.
        if (INSTANCE == null)
            INSTANCE = new TipSettings();

        return INSTANCE;
    }

    public int getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(int value) {
        tipPercent = value;
    }

    public TipStrategy getTipStrategy() {
        return tipStrategy;
    }

    public void setTipStrategy(TipStrategy value) {
        tipStrategy = value;
    }
}
