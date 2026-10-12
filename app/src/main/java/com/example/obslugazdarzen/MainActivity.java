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

    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btComma;
    private TextView tvResult;


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

        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);


        bt1.setOnClickListener(v -> appendSymbol("1"));
        bt2.setOnClickListener(v -> appendSymbol("2"));
        bt0.setOnClickListener(v -> appendSymbol("0"));

        tvResult = findViewById(R.id.tvResult);

        View.OnClickListener symbolListener =
                v -> appendSymbol(((Button) v).getText().toString());

        int[] symbolIds = {
                R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,
                R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9,
                R.id.btComma
        };

        for (int id : symbolIds) {
            findViewById(id).setOnClickListener(symbolListener);
        }

    }

    private void appendSymbol(String symbol) {
        tvResult.setText(tvResult.getText().toString() + symbol);
    }




}