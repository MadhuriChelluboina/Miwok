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
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
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

        final ArrayList<CustomWords> mFamilyArrayList = new ArrayList<>();
        mFamilyArrayList.add(new CustomWords("әpә", "father", R.drawable.family_father, R.raw.family_father));
        mFamilyArrayList.add(new CustomWords("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        mFamilyArrayList.add(new CustomWords("angsi", "son", R.drawable.family_son, R.raw.family_son));
        mFamilyArrayList.add(new CustomWords("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        mFamilyArrayList.add(new CustomWords("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        mFamilyArrayList.add(new CustomWords("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        mFamilyArrayList.add(new CustomWords("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        mFamilyArrayList.add(new CustomWords("kolliti", "young sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        mFamilyArrayList.add(new CustomWords("ama", "grand mother", R.drawable.family_grandmother, R.raw.family_grandmother));
        mFamilyArrayList.add(new CustomWords("paapa", "grand father", R.drawable.family_grandfather, R.raw.family_grandfather));

        ListView listView = rootView.findViewById(R.id.root_listView);
        CustomAdapter adapter = new CustomAdapter(getActivity(), mFamilyArrayList, R.color.family_color);
        listView.setAdapter(adapter);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                CustomWords wordObject = mFamilyArrayList.get(position);
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
