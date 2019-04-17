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
public class NumberFragment extends Fragment {


    public NumberFragment() {
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
    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list,container,false);

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

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), mNumbersList, R.color.numbers_color);
        ListView mNumbers_ListView = rootView.findViewById(R.id.root_listView);
        mNumbers_ListView.setAdapter(customAdapter);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        mNumbers_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                CustomWords wordObject = mNumbersList.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getActivity(), wordObject.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
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
