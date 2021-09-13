package com.example.tipcalculator.tipstrategy;

// Strategy interface describes the algorithm. It doesn't implement the algorithm, it only says that
// in order to calculate tip bill amount and tip percent number is required.
public interface TipStrategy {
    double calculate(double bill, int tipPercent);
}
