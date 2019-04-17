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
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
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

        ListView listView = rootView.findViewById(R.id.root_listView);

        final ArrayList<CustomWords> mPhrasesArrayList = new ArrayList<>();
        mPhrasesArrayList.add(new CustomWords("minto wuksus", "Where are you going?", R.raw.phrase_where_are_you_going));
        mPhrasesArrayList.add(new CustomWords("tinnә oyaase'nә", "What is your name?", R.raw.phrase_what_is_your_name));
        mPhrasesArrayList.add(new CustomWords("oyaaset...", "My name is...", R.raw.phrase_my_name_is));
        mPhrasesArrayList.add(new CustomWords("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        mPhrasesArrayList.add(new CustomWords("kuchi achit", "I’m feeling good.", R.raw.phrase_im_feeling_good));
        mPhrasesArrayList.add(new CustomWords("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming));
        mPhrasesArrayList.add(new CustomWords("hәә’ әәnәm", "Yes, I’m coming.", R.raw.phrase_yes_im_coming));
        mPhrasesArrayList.add(new CustomWords("әәnәm", "I’m coming.", R.raw.phrase_im_coming));
        mPhrasesArrayList.add(new CustomWords("yoowutis", "Let’s go.", R.raw.phrase_lets_go));
        mPhrasesArrayList.add(new CustomWords("әnni'nem", "Come here.", R.raw.phrase_come_here));

        CustomAdapter adapter = new CustomAdapter(getActivity(), mPhrasesArrayList, R.color.phrases_color);
        listView.setAdapter(adapter);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                CustomWords wordObject = mPhrasesArrayList.get(position);
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
