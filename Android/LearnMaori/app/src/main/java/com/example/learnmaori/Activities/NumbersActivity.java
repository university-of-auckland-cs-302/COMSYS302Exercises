package com.example.learnmaori.Activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmaori.Adaptors.NumberAdaptor;
import com.example.learnmaori.Data.DataProvider;
import com.example.learnmaori.Models.Number;
import com.example.learnmaori.R;

import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Testing the dictionary
        List<Number> numbersList = DataProvider.getNumbers();
        NumberAdaptor itemsAdapter = new NumberAdaptor(this, R.layout.number_list_view_item,
                numbersList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);


    }
}
