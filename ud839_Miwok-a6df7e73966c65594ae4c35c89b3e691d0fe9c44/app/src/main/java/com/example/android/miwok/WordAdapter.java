package com.example.android.miwok;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Guille on 15/07/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {


    private int mColorResourceId;



    //Constructor
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0,words);
        mColorResourceId=colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(  // LayoutInflater =Instantiates a layout XML file into its corresponding View
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.txtMiwok);

        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //-----------------------------------------------------------------------------

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.txtdefault);

        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //IMAGE
        ImageView image =(ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImagen()){

            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }else {
            image.setVisibility(View.GONE);
        }





        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;


    }
}
