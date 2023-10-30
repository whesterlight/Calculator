package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView calculatorScreen;
    private String input = "";
    private String operator = "";
    private double operand1 = Double.NaN;
    private double operand2;
    private double memory = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

        Button[] buttons = new Button[]{
                findViewById(R.id.MC), findViewById(R.id.MR), findViewById(R.id.MS), findViewById(R.id.MPlus), findViewById(R.id.MMinus),
                findViewById(R.id.back), findViewById(R.id.ClearEntry), findViewById(R.id.clear), findViewById(R.id.PlusMinus), findViewById(R.id.SquareRoot),
                findViewById(R.id.n7), findViewById(R.id.n8), findViewById(R.id.n9), findViewById(R.id.division), findViewById(R.id.percent),
                findViewById(R.id.n4), findViewById(R.id.n5), findViewById(R.id.n6), findViewById(R.id.multiplication), findViewById(R.id.OneDevidedByX),
                findViewById(R.id.n3), findViewById(R.id.n2), findViewById(R.id.n0), findViewById(R.id.n1), findViewById(R.id.period),
                findViewById(R.id.addition), findViewById(R.id.minus), findViewById(R.id.equals)
        };

        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String buttonText = ((Button) v).getText().toString();

        switch (buttonText) {

            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":

            case ".":
                input += buttonText;
                break;

            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                if (!input.isEmpty()) {
                    operand1 = Double.parseDouble(input);
                    operator = buttonText;
                    input = "";
                }
                break;

            case "=":
                if (!input.isEmpty() && !Double.isNaN(operand1)) {
                    operand2 = Double.parseDouble(input);
                    double result = performOperation(operand1, operand2, operator);
                    input = String.valueOf(result);
                    operand1 = result;
                    operator = "";
                }
                break;

            case "CE":
            case "C":
            case "←":

            case "±":
            case "√":
            case "1/x":

            case "M+":
            case "M-":
            case "MC":
            case "MR":
            case "MS":
        }

        calculatorScreen.setText(input);
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return Double.NaN;
                }
            case "%":
                return operand1 * (operand2 / 100);
            default:
                return operand2;
        }
    }
}