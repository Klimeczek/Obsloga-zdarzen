package com.example.obslugazdarzen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private TextView tvGuessedShow, tvRandomNumberShow, tvGuessed, tvRandomNumber;
    private EditText etGuess;
    private Button btnRandomize, btnGuess;

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

        btnRandomize = findViewById(R.id.btnNewNumber);
        btnGuess = findViewById(R.id.btnGuess);

        btnRandomize.setOnClickListener(v -> {
            int number = randomNumber();
        });

        btnGuess.setOnClickListener(v -> showNumber());

    }

    private void showNumber() {
        int guessedNumber = Integer.parseInt(etGuess.getText().toString().trim());

        tvGuessed.setText(tvGuessed.getText().toString() + guessedNumber);
    }
    private int randomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

}