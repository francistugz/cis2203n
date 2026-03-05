package com.example.hellocampus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sabotage
        TextView counterDisplay = null ;
        counterDisplay.setText ("0") ;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 18400139");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button myButton = findViewById(R.id.btnChangeName);
        final TextView myText = findViewById(R.id.tvDepartment);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myText.setText("Dr. Angie Ceniza-Canillo");
            }
        });

        Button btn = findViewById(R.id.btn_back);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

