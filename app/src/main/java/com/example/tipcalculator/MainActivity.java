package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private MaterialButtonToggleGroup tipAmountContainer;
    private MaterialButtonToggleGroup tipStrategyContainer;
    private TextInputEditText amountEditText;
    private MaterialButton calculateButton;
    private TextView tipText;
    private TextView totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipAmountContainer = findViewById(R.id.tipAmountContainer);
        tipStrategyContainer = findViewById(R.id.tipStrategyContainer);
        amountEditText = findViewById(R.id.amountEditText);
        calculateButton = findViewById(R.id.calculateButton);
        tipText = findViewById(R.id.tipText);
        totalText = findViewById(R.id.totalText);

        tipAmountContainer.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                int selectedTipPercent = getSelectedTipPercent(checkedId);
                TipSettings settings = new TipSettings();
                settings.setTipPercent(selectedTipPercent);
            }
        });

        tipStrategyContainer.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                int selectedStrategy = getSelectedTipStrategy(checkedId);
                TipSettings settings = new TipSettings();
                settings.setTipStrategy(selectedStrategy);
            }
        });

        calculateButton.setOnClickListener(view -> onCalculateButtonClick());

        tipAmountContainer.check(R.id.percent20);
        tipStrategyContainer.check(R.id.defaultButton);
    }

    private void onCalculateButtonClick() {
        if (amountEditText.getText() == null) {
            hideTip();
            return;
        }
        String amountString = amountEditText.getText().toString();
        try {
            TipSettings settings = new TipSettings();

            int tipStrategy = settings.getTipStrategy();
            int tipPercent = settings.getTipPercent();

            double amount = Double.parseDouble(amountString);

            double tipAmount = 0;

            // TODO 2: Implement tip strategy algorithm using Strategy Design Pattern.
            // TODO 3: Add Custom tip strategy
            switch (tipStrategy) {
                case 0: // Default
                    tipAmount = amount * tipPercent * 0.01;
                    break;
                case 1: // Round up
                    double nonRounded = amount * tipPercent * 0.01;
                    tipAmount = Math.ceil(nonRounded);
                    break;
                case 2: // Round Down
                    double nonRounded2 = amount * tipPercent * 0.01;
                    tipAmount = Math.floor(nonRounded2);
                    break;
            }

            double totalAmount = amount + tipAmount;

            showTip(tipAmount, totalAmount);
        } catch (NumberFormatException e) {
            hideTip();
        }
    }

    private void showTip(double tipAmount, double totalAmount) {
        tipText.setText(getString(R.string.money_pattern, tipAmount));
        totalText.setText(getString(R.string.money_pattern, totalAmount));
        tipText.setVisibility(View.VISIBLE);
        totalText.setVisibility(View.VISIBLE);
    }

    private void hideTip() {
        tipText.setVisibility(View.GONE);
        totalText.setVisibility(View.GONE);
    }

    private int getSelectedTipPercent(int checkedId) {
        switch (checkedId) {
            case R.id.percent10: return 10;
            case R.id.percent15: return 15;
            case R.id.percent20: return 20;
            case R.id.percent25: return 25;
            default: return 0;
        }
    }

    private int getSelectedTipStrategy(int checkedId) {
        switch (checkedId) {
            case R.id.defaultButton: return 0;
            case R.id.roundUp: return 1;
            case R.id.roundDown: return 2;
            default: return 0;
        }
    }
}