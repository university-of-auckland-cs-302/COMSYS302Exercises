package com.example.learnmaori.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.learnmaori.Adaptors.ItemsAdaptor;
import com.example.learnmaori.Models.Colors;
import com.example.learnmaori.Models.IItems;
import com.example.learnmaori.Models.Number;
import com.example.learnmaori.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.LinkedList;
import java.util.List;


public class ColorsActivity extends AppCompatActivity {

    private class ViewHolder {
        ListView listView;
        ProgressBar progressBar;

        public ViewHolder() {
            listView = findViewById(R.id.colors_list_view);
            progressBar = findViewById(R.id.colors_load_progressbar);
        }
    }

    ViewHolder vh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        vh = new ViewHolder();
        fetchColorsData();
    }


    private void fetchColorsData() {
        List<IItems> colorsList = new LinkedList<IItems>();

        // Getting numbers collection from Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("colors").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot results = task.getResult();
                    for (IItems aColorItem : task.getResult().toObjects(Colors.class)) {
                        colorsList.add(aColorItem);
                        Log.i("Parsing colors", aColorItem.getEnglishColor()+ " loaded.");
                    }
                    if (colorsList.size() > 0) {
                        Log.i("Getting colors", "Success");
                        // Once the task is successful and data is fetched, propagate the adaptor
                        propagateAdaptor(colorsList);

                        // Hide the ProgressBar
                        vh.progressBar.setVisibility(View.GONE);
                    } else
                        Toast.makeText(getBaseContext(), "Colors Collection was empty!", Toast.LENGTH_LONG).show();

                } else
                    Toast.makeText(getBaseContext(), "Loading colors collection failed from Firestore!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void propagateAdaptor(List<IItems> data) {
        ItemsAdaptor itemsAdapter = new ItemsAdaptor(this, R.layout.colors_list_view_item,
                data);
        vh.listView.setAdapter(itemsAdapter);
        vh.listView.setVisibility(View.VISIBLE);
    }
}