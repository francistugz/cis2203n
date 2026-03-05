package com.example.hellocampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sabotage
        TextView counterDisplay = null;
        try {
            counterDisplay.setText("0"); //
        } catch (NullPointerException ignored) {
        }

        myTextView = findViewById(R.id.tvCounter);

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt("COUNT_KEY");
            myTextView.setText(String.valueOf(mCounter));
        } else {
            myTextView.setText("0");
        }

        Button btnIncrement = findViewById(R.id.btnIncrement);

        btnIncrement.setOnClickListener(v -> {
            mCounter++;
            myTextView.setText(String.valueOf(mCounter));
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 18400139");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button myButton = findViewById(R.id.btnChangeName);
        final TextView myText = findViewById(R.id.tvDepartment);

        myButton.setOnClickListener(v ->
                myText.setText(getString(R.string.chairwoman_name))
        );

        Button btn = findViewById(R.id.btn_back);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        });


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt("COUNT_KEY");
        myTextView.setText(String.valueOf(mCounter));
    }
}

