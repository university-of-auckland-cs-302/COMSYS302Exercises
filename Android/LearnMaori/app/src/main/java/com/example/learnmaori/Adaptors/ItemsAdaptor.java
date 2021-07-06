package com.example.learnmaori.Adaptors;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learnmaori.Models.Colors;
import com.example.learnmaori.Models.IItems;
import com.example.learnmaori.Models.Number;
import com.example.learnmaori.R;

import java.util.List;

public class ItemsAdaptor extends ArrayAdapter {


    private class ViewHolder {
        TextView maoriTextView;
        ImageView play;

        public ViewHolder(View currentListViewItem) {
            maoriTextView = currentListViewItem.findViewById(R.id.maori_text_view);
            play = currentListViewItem.findViewById(R.id.play_image_view);
        }
    }

    private class NumberViewHolder extends ViewHolder {
        ImageView iconImageView;

        public NumberViewHolder(View currentListViewItem) {
            super(currentListViewItem);
            iconImageView = currentListViewItem.findViewById(R.id.icon_image_view);
        }
    }

    private class ColorsViewHolder extends ViewHolder {
        TextView englishColorTextView;
        LinearLayout colorRootView;

        public ColorsViewHolder(View currentListViewItem) {
            super(currentListViewItem);
            englishColorTextView = currentListViewItem.findViewById(R.id.english_text_view);
            colorRootView = currentListViewItem.findViewById(R.id.linear_layout_color);
        }
    }

    int mLayoutID;
    List<IItems> mItems;
    Context mContext;
    MediaPlayer mediaPlayer;

    public ItemsAdaptor(@NonNull Context context, int resource, @NonNull List<IItems> objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        mContext = context;
        mItems = objects;
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

        //Get the Number object for the current position
        IItems currentItem = mItems.get(position);
        if (currentItem.getClass() == Number.class)

            // Populate the Current ListView Item with Numbers data and layout
            return populateNumbersListItem(currentItem, currentListViewItem);

        else if (currentItem.getClass() == Colors.class)
            // Populate the Current ListView Item with Colors data and layout
            return populateColorsListItem(currentItem, currentListViewItem);
        else return null;

    }

    private View populateNumbersListItem(IItems currentItem, View currentListViewItem) {
        // Note a new ViewHolder object has to be created for every currentListViewItem
        NumberViewHolder vh = new NumberViewHolder(currentListViewItem);

        //Set the attributed of list_view_number_item views
        int i = mContext.getResources().getIdentifier(
                currentItem.getIconFilename(), "drawable",
                mContext.getPackageName());

        //Setting the icon
        vh.iconImageView.setImageResource(i);

        // Setting the maori text
        vh.maoriTextView.setText(currentItem.getMaoriTranslation());

        //Getting the audio resource id for the current Number object
        final String audio = currentItem.getAudioFilename();
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

    private View populateColorsListItem(IItems currentItem, View currentListViewItem) {
        // Note a new ViewHolder object has to be created for every currentListViewItem
        ColorsViewHolder vh = new ColorsViewHolder(currentListViewItem);

        vh.colorRootView.setBackgroundColor(Color.parseColor(currentItem.getBackgroundColor()));

        vh.englishColorTextView.setText(currentItem.getEnglishColor());

        // Setting the maori text
        vh.maoriTextView.setText(currentItem.getMaoriTranslation());

        //Getting the audio resource id for the current Number object
        final String audio = currentItem.getAudioFilename();
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
