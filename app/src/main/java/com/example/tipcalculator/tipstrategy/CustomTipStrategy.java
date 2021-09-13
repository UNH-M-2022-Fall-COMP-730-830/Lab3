package com.example.tipcalculator.tipstrategy;

// Concrete implementation of strategy algorithm.
public class CustomTipStrategy implements TipStrategy {
    @Override
    public double calculate(double bill, int tipPercent) {
        double tip = bill * tipPercent * 0.01;
        double roundedTotal = Math.ceil(tip + bill);
        return roundedTotal - bill;
    }
}
