package com.example.mockmidterms;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView ResultText;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button plus, minus, multiply, divide, equals, clear, themeToggle;

    double firstNum = 0;
    double secondNum = 0;
    String operator = "";
    boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ResultText = findViewById(R.id.ResultText);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);


        plus = findViewById(R.id.Plus);
        minus = findViewById(R.id.Subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.Divide);
        equals = findViewById(R.id.result);
        clear = findViewById(R.id.clear);


        themeToggle = findViewById(R.id.themeToggle);


        btn1.setOnClickListener(v -> appendNumber("1"));
        btn2.setOnClickListener(v -> appendNumber("2"));
        btn3.setOnClickListener(v -> appendNumber("3"));
        btn4.setOnClickListener(v -> appendNumber("4"));
        btn5.setOnClickListener(v -> appendNumber("5"));
        btn6.setOnClickListener(v -> appendNumber("6"));
        btn7.setOnClickListener(v -> appendNumber("7"));
        btn8.setOnClickListener(v -> appendNumber("8"));
        btn9.setOnClickListener(v -> appendNumber("9"));
        btn0.setOnClickListener(v -> appendNumber("0"));


        plus.setOnClickListener(v -> setOperator("+"));
        minus.setOnClickListener(v -> setOperator("-"));
        multiply.setOnClickListener(v -> setOperator("*"));
        divide.setOnClickListener(v -> setOperator("/"));


        equals.setOnClickListener(v -> {
            secondNum = Double.parseDouble(ResultText.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    if (secondNum == 0) {
                        ResultText.setText("Error");
                        return;
                    }
                    result = firstNum / secondNum;
                    break;
            }

            if (result == (int) result) {
                ResultText.setText(String.valueOf((int) result));
            } else {
                ResultText.setText(String.valueOf(result));
            }
        });


        clear.setOnClickListener(v -> {
            ResultText.setText("0");
            firstNum = 0;
            secondNum = 0;
            operator = "";
        });


        themeToggle.setOnClickListener(v -> {
            int currentMode = AppCompatDelegate.getDefaultNightMode();

            if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Append number
    private void appendNumber(String number) {
        if (ResultText.getText().toString().equals("0") || isOperatorClicked) {
            ResultText.setText(number);
            isOperatorClicked = false;
        } else {
            ResultText.append(number);
        }
    }

    // Set operator
    private void setOperator(String op) {
        firstNum = Double.parseDouble(ResultText.getText().toString());
        operator = op;
        isOperatorClicked = true;
    }
}