package com.example.recyclerviewdemo.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.models.Contact;

import java.util.List;

public class ContactAdaptor extends RecyclerView.Adapter<ContactAdaptor.ViewHolder> {

    // To make your view item clickable ensure that the view holder class implements View.OnClickListener and it has the onClick(View v) method.
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Declare objects of all the views to be manipulated in item_contact.xml
        public TextView nameTextView;
        public RadioButton radioButtonOnlineStatus;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            // Initialize the view objects
            nameTextView = v.findViewById(R.id.contact_name);
            radioButtonOnlineStatus = v.findViewById((R.id.radio_button_online_status));
        }

        @Override
        public void onClick(View v) {
            // What to do when the view item is clicked
            Contact clickedContact = mContacts.get(getAdapterPosition());
            Toast.makeText(mContext, clickedContact.getName() + " is clicked in position " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }

    // Declare the data collection object that holds the data to be populated in the RecyclerView
    private List<Contact> mContacts;
    private Context mContext;

    // Pass in the contact array object into the constructor
    public ContactAdaptor(List<Contact> contacts) {
        // The contacts object is sent via the activity that creates this adaptor
        mContacts = contacts;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ContactAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder holder = new ViewHolder(contactView);
        return holder;
    }

    // This method populates the data from mContacts to the view items
    @Override
    public void onBindViewHolder(@NonNull ContactAdaptor.ViewHolder holder, int position) {
        // Get the data object for the item view in this position
        Contact thisContact = mContacts.get(position);

        holder.nameTextView.setText(thisContact.getName());
        holder.radioButtonOnlineStatus.setChecked(thisContact.isOnline());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}
