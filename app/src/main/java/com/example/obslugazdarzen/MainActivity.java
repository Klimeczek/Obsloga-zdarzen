package com.example.obslugazdarzen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    private String firstNumber = "";
    private String operator = "";
    private boolean isNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvResult = findViewById(R.id.tvResult);

        Button bt0 = findViewById(R.id.bt0);
        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);
        Button bt5 = findViewById(R.id.bt5);
        Button bt6 = findViewById(R.id.bt6);
        Button bt7 = findViewById(R.id.bt7);
        Button bt8 = findViewById(R.id.bt8);
        Button bt9 = findViewById(R.id.bt9);
        Button btEq = findViewById(R.id.btEq);
        Button btAdd = findViewById(R.id.btAdd);
        Button btSub = findViewById(R.id.btSub);
        Button btMul = findViewById(R.id.btMul);
        Button btDiv = findViewById(R.id.btDiv);
        Button btClear = findViewById(R.id.btClear);

        btClear.setOnClickListener(v -> clearSymbol());
        bt0.setOnClickListener(v -> appendSymbol("0"));
        bt1.setOnClickListener(v -> appendSymbol("1"));
        bt2.setOnClickListener(v -> appendSymbol("2"));
        bt3.setOnClickListener(v -> appendSymbol("3"));
        bt4.setOnClickListener(v -> appendSymbol("4"));
        bt5.setOnClickListener(v -> appendSymbol("5"));
        bt6.setOnClickListener(v -> appendSymbol("6"));
        bt7.setOnClickListener(v -> appendSymbol("7"));
        bt8.setOnClickListener(v -> appendSymbol("8"));
        bt9.setOnClickListener(v -> appendSymbol("9"));

        btAdd.setOnClickListener(v -> setOperator("+"));
        btSub.setOnClickListener(v -> setOperator("-"));
        btMul.setOnClickListener(v -> setOperator("*"));
        btDiv.setOnClickListener(v -> setOperator("/"));

        btEq.setOnClickListener(v -> calculate());
    }

    private void clearSymbol() {
        tvResult.setText("");
        firstNumber = "";
        operator = "";
        isNewNumber = true;
    }

    private void appendSymbol(String symbol) {
        if (isNewNumber) {
            tvResult.setText(symbol);
            isNewNumber = false;
        } else {
            tvResult.setText(tvResult.getText().toString() + symbol);
        }
    }

    private void setOperator(String op) {
        firstNumber = tvResult.getText().toString();
        operator = op;
        isNewNumber = true;
    }

    private void calculate() {
        if (firstNumber.isEmpty() || operator.isEmpty()) {
            return;
        }

        String secondNumber = tvResult.getText().toString();

        try {
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(secondNumber);
            double result = 0;

            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                if (num2 == 0) {
                    tvResult.setText("Błąd");
                    return;
                }
                result = num1 / num2;
            }

            // pokaż wynik (bez .0 jak to liczba całkowita)
            if (result == (long) result) {
                tvResult.setText(String.valueOf((long) result));
            } else {
                tvResult.setText(String.valueOf(result));
            }

            firstNumber = "";
            operator = "";
            isNewNumber = true;

        } catch (Exception e) {
            tvResult.setText("Błąd");
        }
    }
}