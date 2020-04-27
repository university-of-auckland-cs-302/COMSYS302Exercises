package com.example.orderapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.orderapp.models.Order;

public class MainActivity extends AppCompatActivity {

    class ViewHolder {
        EditText priceEditText, usernameEditText;
        TextView totalOrderTextView, quantityTextView;
        CardView cardViewResults;
        Button confirmButton;
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
        vh.cardViewResults = (CardView) findViewById(R.id.card_view_result_message);
        vh.usernameEditText = (EditText) findViewById(R.id.edit_text_username);
        vh.confirmButton= (Button) findViewById(R.id.confirm_button);
        anOrder = new Order();
    }

    public void toppingsEventHandler(View v) {
        CheckBox toppingCheckBox = (CheckBox) v;
        if (toppingCheckBox.isChecked())
            anOrder.addTopping(toppingCheckBox.getText().toString());
        else
            anOrder.removeTopping(toppingCheckBox.getText().toString());

    }

    public void orderButtonPressed(View v) {
        if (!vh.priceEditText.getText().toString().isEmpty()) {
            anOrder.setPricePerItem(Double.valueOf(vh.priceEditText.getText().toString()));
            anOrder.setUsername(vh.usernameEditText.getText().toString());

            vh.totalOrderTextView.setText(anOrder.getOrderMessage());
            vh.cardViewResults.setVisibility(View.VISIBLE);
            vh.confirmButton.setVisibility(View.VISIBLE);
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

    public void composeEmail(View v) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + anOrder.getUsername())); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "New Order");
        intent.putExtra(Intent.EXTRA_TEXT, anOrder.getOrderMessage());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
