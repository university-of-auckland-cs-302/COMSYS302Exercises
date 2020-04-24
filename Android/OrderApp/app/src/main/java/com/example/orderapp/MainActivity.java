package com.example.orderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderapp.models.Order;

public class MainActivity extends AppCompatActivity {

    class ViewHolder {
        EditText priceEditText;
        TextView totalOrderTextView, quantityTextView;
    }

    Order anOrder;
    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vh = new ViewHolder();
        vh.priceEditText = (EditText) findViewById(R.id.price_edit_text);
        vh.totalOrderTextView = (TextView) findViewById(R.id.total_order_text_view);
        vh.quantityTextView = findViewById(R.id.quantity_text_view);
        anOrder = new Order();
    }

    public void orderButtonPressed(View v) {


        if (!vh.priceEditText.getText().toString().isEmpty()) {
            anOrder.setPricePerItem(Double.valueOf(vh.priceEditText.getText().toString()));


            vh.totalOrderTextView.setText(vh.totalOrderTextView.getText().toString() + "\n" +
                    String.valueOf(anOrder.getTotalPrice()));
            vh.totalOrderTextView.setVisibility(View.VISIBLE);
        } else
            Toast.makeText(this, "Please enter the price first.", Toast.LENGTH_LONG).show();
    }

    public void increaseQuantity(View v) {
        anOrder.increaseQuantity();
        updateQuantityTextView();
    }

    public void decreaseQuantity(View v) {
        anOrder.decreaseQuantity();
        updateQuantityTextView();
    }

    private void updateQuantityTextView() {

        vh.quantityTextView.setText(String.valueOf(anOrder.getQuantity()));

    }

}
