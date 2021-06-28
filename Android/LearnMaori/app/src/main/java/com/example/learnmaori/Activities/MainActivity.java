package com.example.learnmaori.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learnmaori.Data.DataProvider;
import com.example.learnmaori.R;

public class MainActivity extends AppCompatActivity {

    private class ViewHolder {
        CardView numbersCardView;

        public ViewHolder() {
            numbersCardView = findViewById(R.id.card_view_numbers);
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

    }

}
