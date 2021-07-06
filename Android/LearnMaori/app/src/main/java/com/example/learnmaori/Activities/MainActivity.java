package com.example.learnmaori.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learnmaori.Data.ColorsFirestoreDataProvider;
import com.example.learnmaori.Data.DataProvider;
import com.example.learnmaori.R;

public class MainActivity extends AppCompatActivity {

    private class ViewHolder {
        CardView numbersCardView, colorsCardView;

        public ViewHolder() {
            numbersCardView = findViewById(R.id.card_view_numbers);
            colorsCardView = findViewById(R.id.colors_card_view);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vh = new ViewHolder();

        vh.numbersCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        vh.colorsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsIntent = new Intent(getBaseContext(), ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });
    }
}
