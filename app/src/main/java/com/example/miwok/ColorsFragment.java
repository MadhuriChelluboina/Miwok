package com.example.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    public ColorsFragment() {
        // Required empty public constructor
    }

    MediaPlayer mMediaPlayer;
    AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if ((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
                    || (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list,container,false);

        final ArrayList<CustomWords> colorsArrayList = new ArrayList<>();

        colorsArrayList.add(new CustomWords("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        colorsArrayList.add(new CustomWords("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        colorsArrayList.add(new CustomWords("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        colorsArrayList.add(new CustomWords("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        colorsArrayList.add(new CustomWords("kululli", "black", R.drawable.color_black, R.raw.color_black));
        colorsArrayList.add(new CustomWords("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        colorsArrayList.add(new CustomWords("ṭakaakki", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArrayList.add(new CustomWords("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        ListView listView = rootView.findViewById(R.id.root_listView);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), colorsArrayList, R.color.colors_color);
        listView.setAdapter(customAdapter);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                CustomWords wordObject = colorsArrayList.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), wordObject.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }

            }
        });


        return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
