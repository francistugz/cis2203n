package com.example.exercise03;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.widget.TextView;


public class EchoActivity extends AppCompatActivity {

    public static final String TAG = "EchoActivity";
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_echo);

        Log.d(TAG, "onCreate called");

        txtMessage = findViewById(R.id.txtMessage);

        // Get message from Intent
        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);

        Log.d(TAG, "Received message: " + message);

        txtMessage.setText(message);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.echo), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }