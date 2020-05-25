package com.example.learnmaori;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Testing the dictionary
        Map<Integer, String> words = DataProvider.generateMaoriDigits();
        String text = "";
        for (Integer key : words.keySet()) {
            text += String.valueOf(key) + " : " + words.get(key) + "\n";
        }
        TextView tempView = (TextView) findViewById(R.id.temp_text_view);
        tempView.setText(text);


    }
}
