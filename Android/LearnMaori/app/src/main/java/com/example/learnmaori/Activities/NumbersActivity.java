package com.example.learnmaori.Activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnmaori.Adaptors.NumberAdaptor;
import com.example.learnmaori.Data.DataProvider;
import com.example.learnmaori.Models.INumber;
import com.example.learnmaori.Models.Number;
import com.example.learnmaori.R;

import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    private class ViewHolder {
        ListView listView;

        public ViewHolder() {
            listView = findViewById(R.id.listView);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        vh = new ViewHolder();

        List<INumber> numbersList = DataProvider.getNumbers();
        NumberAdaptor itemsAdapter = new NumberAdaptor(this, R.layout.number_list_view_item,
                numbersList);
        vh.listView = (ListView) findViewById(R.id.listView);
        vh.listView.setAdapter(itemsAdapter);
    }
}
