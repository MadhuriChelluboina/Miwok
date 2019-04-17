package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
//        LinearLayout mNumbers_rootView  = findViewById(R.id.numbers_rootView);

        final ArrayList<CustomWords> mNumbersList = new ArrayList<>();
        mNumbersList.add(new CustomWords("lutti", "one", R.drawable.number_one, R.raw.number_one));
        mNumbersList.add(new CustomWords("otiiko", "two", R.drawable.number_two, R.raw.number_two));
        mNumbersList.add(new CustomWords("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        mNumbersList.add(new CustomWords("oyyisa", "four", R.drawable.number_four, R.raw.number_four));
        mNumbersList.add(new CustomWords("massokka", "five", R.drawable.number_five, R.raw.number_five));
        mNumbersList.add(new CustomWords("temmokka", "six", R.drawable.number_six, R.raw.number_six));
        mNumbersList.add(new CustomWords("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        mNumbersList.add(new CustomWords("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        mNumbersList.add(new CustomWords("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine));
        mNumbersList.add(new CustomWords("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten));


//        for(int index=0;index<mNumbersList.size();index++)
//        {
//            TextView mNumbers_textView = new TextView(this);
//            mNumbers_textView.setText(mNumbersList.get(index));
//            mNumbers_rootView.addView(mNumbers_textView);
//        }

        CustomAdapter customAdapter = new CustomAdapter(this, mNumbersList, R.color.numbers_color);
        ListView mNumbers_ListView = findViewById(R.id.root_listView);
        mNumbers_ListView.setAdapter(customAdapter);

        mNumbers_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                CustomWords wordObject = mNumbersList.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, wordObject.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
