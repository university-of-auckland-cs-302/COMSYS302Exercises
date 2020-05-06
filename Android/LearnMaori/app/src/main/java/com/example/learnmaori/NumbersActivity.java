package com.example.learnmaori;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Intent thisIntent = getIntent();
        String message = thisIntent.getStringExtra("MessageFromMainActivity");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
