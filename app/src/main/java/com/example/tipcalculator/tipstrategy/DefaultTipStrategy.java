package com.example.tipcalculator.tipstrategy;

// Concrete implementation of strategy algorithm.
public class DefaultTipStrategy implements TipStrategy {
    @Override
    public double calculate(double bill, int tipPercent) {
        return bill * tipPercent * 0.01;
    }
}
