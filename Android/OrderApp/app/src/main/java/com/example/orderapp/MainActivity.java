package com.example.orderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void orderButtonPressed(View v) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);


        EditText priceEditText = (EditText) findViewById(R.id.price_edit_text);
        Double price = Double.valueOf(priceEditText.getText().toString());

        quantityTextView.setText("The price is: "+ price.toString());
    }

}
