package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView calculatorScreen;

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

    }
}