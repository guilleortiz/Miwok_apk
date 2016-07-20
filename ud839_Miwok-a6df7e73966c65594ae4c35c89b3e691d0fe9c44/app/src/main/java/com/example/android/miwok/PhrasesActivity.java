package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));




        // for (int i=11;i<100;i++){
        //    words.add(new Word( "+","+"+i));
        // }


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter Adapter =new WordAdapter(this, words,R.color.category_phrases);

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

                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this,word.getSoundId());
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
