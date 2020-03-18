package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerviewdemo.adaptors.ContactAdaptor;
import com.example.recyclerviewdemo.models.Contact;

import java.util.ArrayList;

// This demo application is created based on the following blog
// https://guides.codepath.com/android/using-the-recyclerview#using-with-listadapter
public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    ContactAdaptor adapter;
    RecyclerView rvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recyclerview in activity layout
        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = DataProvider.generateData();
        // Create adapter passing in the sample user data
        adapter = new ContactAdaptor(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);

        // Create a LayoutManager
        LinearLayoutManager lm = new LinearLayoutManager(this);


        // Fore a Horizontal RecyclerView use
        // LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Set layout manager to position the items
        rvContacts.setLayoutManager(lm);

    }

    public void addNewContact(View v) {


        EditText newNameEditText = findViewById(R.id.edit_text_name);

        //First check if contact name is not empty
        if (String.valueOf(newNameEditText.getText()).isEmpty()) {
            Toast.makeText(this, "Please enter the contact name", Toast.LENGTH_SHORT).show();
            return;
        }

        Spinner spinnerOnlineStatrus = findViewById(R.id.spinner_online_status);
        String onlineStatus = (String) spinnerOnlineStatrus.getSelectedItem();

        Contact newContact;
        if (onlineStatus.equals("Online"))
            newContact = new Contact(newNameEditText.getText().toString(), true);
        else
            newContact = new Contact(newNameEditText.getText().toString(), false);

        contacts.add(0, newContact);

        // Notify the adaptor that a new contact is added to the top of the list
        adapter.notifyItemInserted(0);

        // Scroll to the top of the recyclerview
        rvContacts.scrollToPosition(0);

        //Empty the editText
        newNameEditText.setText("");
        Toast.makeText(this, "New contact is added", Toast.LENGTH_SHORT).show();
        // Hide the keyboard
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(newNameEditText.getWindowToken(), 0);

    }
}
