package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

         final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red,R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("green", "chokokki", R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white,R.raw.color_white));




        //for (int i=11;i<10;i++){
          //  words.add(new Word( "+","+"+i));
       // }


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter Adapter =new WordAdapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(Adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this, "Sound!", Toast.LENGTH_SHORT).show();
                //Word kk= new Word();

                Word word=  words.get(position);

                mMediaPlayer= MediaPlayer.create(ColorsActivity.this,word.getSoundId());
                mMediaPlayer.start();
            }
        });

        // Log.v("NumbersActivity", "Word at index 0: " + words.get(0));
        //Log.v("NumbersActivity", "Word at index 1: " + words.get(1));
        // Log.v("NumbersActivity", "Word at index 2: " + words.get(2));
        // Log.v("NumbersActivity", "Word at index 3: " + words.get(3));
        // Log.v("NumbersActivity", "Word at index 4: " + words.get(4));
        // Log.v("NumbersActivity", "Word at index 5: " + words.get(5));
        //  Log.v("NumbersActivity", "Word at index 6: " + words.get(6));
        // Log.v("NumbersActivity", "Word at index 7: " + words.get(7));
        // Log.v("NumbersActivity", "Word at index 8: " + words.get(8));
        //Log.v("NumbersActivity", "Word at index 9: " + words.get(9));




        //  for (int i=0;i<words.size();i++){

        //  LinearLayout rootView=(LinearLayout)findViewById(R.id.rootView);
        //  TextView wordView=new TextView(this);
        // wordView.setText(words.get(i));
        // rootView.addView(wordView);

        // }
    }
}