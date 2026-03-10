package com.example.exercise02part02;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.exercise02part02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnSubmit.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        String studentId = binding.etStudentId.getText().toString();
        String password = binding.etPassword.getText().toString();

        String lastTwo = studentId.substring(studentId.length() - 2);

        String correctPassword = "blue" + lastTwo;

        if (password.equals(correctPassword)) {
            binding.tvResult.setText("Password is Correct");
        } else {
            binding.tvResult.setText("Password is Wrong");
        }
    }
}