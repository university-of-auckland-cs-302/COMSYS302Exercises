package com.example.learnmaori.Adaptors;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learnmaori.Models.IItems;
import com.example.learnmaori.R;

import java.util.List;

public class NumberAdaptor extends ArrayAdapter {

    private class ViewHolder {
        ImageView iconImageView;
        TextView maoriTextView;
        ImageView play;

        public ViewHolder(View currentListViewItem) {
            iconImageView = currentListViewItem.findViewById(R.id.icon_image_view);
            maoriTextView = currentListViewItem.findViewById(R.id.maori_text_view);
            play = currentListViewItem.findViewById(R.id.play_image_view);
        }
    }

    int mLayoutID;
    List<IItems> mNumbers;
    Context mContext;
    MediaPlayer mediaPlayer;

    public NumberAdaptor(@NonNull Context context, int resource, @NonNull List<IItems> objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mContext = context;
        mNumbers = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }
        // Note a new ViewHolder object has to be created for every currentListViewItem
        ViewHolder vh = new ViewHolder(currentListViewItem);

        //Get the Number object for the current position
        IItems currentNumber = mNumbers.get(position);

        //Set the attributed of list_view_number_item views
        int i = mContext.getResources().getIdentifier(
                currentNumber.getIconFilename(), "drawable",
                mContext.getPackageName());

        //Setting the icon
        vh.iconImageView.setImageResource(i);

        // Setting the maori text
        vh.maoriTextView.setText(currentNumber.getMaoriTranslation());

        //Getting the audio resource id for the current Number object
        final String audio = currentNumber.getAudioFilename();
        //vh.play = (ImageView) currentListViewItem.findViewById(R.id.play_image_view);

        //Setting the image click handler
        vh.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Operations to perform when the play ImageView is clicked
                int i = mContext.getResources().getIdentifier(
                        audio, "raw",
                        mContext.getPackageName());
                //Using MediaPlayer to play the audio file
                if (mediaPlayer != null)
                    mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(mContext, i);
                mediaPlayer.start();

            }
        });

        return currentListViewItem;
    }
}
