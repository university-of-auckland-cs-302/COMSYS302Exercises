package com.example.learnmaori.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learnmaori.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView numbersCardView = (CardView) findViewById(R.id.card_view_numbers);
        numbersCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), NumbersActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "This message came form Main Activity");
                startActivity(numbersIntent);
            }
        });
    }

}
