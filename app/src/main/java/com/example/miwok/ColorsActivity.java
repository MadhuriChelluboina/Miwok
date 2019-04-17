package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<CustomWords> colorsArrayList = new ArrayList<>();

        colorsArrayList.add(new CustomWords("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        colorsArrayList.add(new CustomWords("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        colorsArrayList.add(new CustomWords("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        colorsArrayList.add(new CustomWords("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        colorsArrayList.add(new CustomWords("kululli", "black", R.drawable.color_black, R.raw.color_black));
        colorsArrayList.add(new CustomWords("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        colorsArrayList.add(new CustomWords("ṭakaakki", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArrayList.add(new CustomWords("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        ListView listView = findViewById(R.id.root_listView);
        CustomAdapter customAdapter = new CustomAdapter(this, colorsArrayList, R.color.colors_color);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                CustomWords wordObject = colorsArrayList.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, wordObject.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });


//        for(int i=0;i<colorsList.size();i++)
//        {
//            TextView textView = new TextView(this);
//            textView.setText(colorsList.get(i));
//            rootView.addView(textView);
//        }


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
