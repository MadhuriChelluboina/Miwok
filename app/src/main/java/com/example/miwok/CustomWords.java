package com.example.miwok;

public class CustomWords {

    private String mForeignWord;
    private String mDefaultWord;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public CustomWords(String mForeignWord, String mDefaultWord, int mAudioResourceId) {
        this.mForeignWord = mForeignWord;
        this.mDefaultWord = mDefaultWord;
        this.mAudioResourceId = mAudioResourceId;
    }


    public CustomWords(String mForeignWord, String mDefaultWord, int mImageResourceId, int mAudioResourceId) {
        this.mForeignWord = mForeignWord;
        this.mDefaultWord = mDefaultWord;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public void setmAudioResourceId(int mAudioResourceId) {
        this.mAudioResourceId = mAudioResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getmForeignWord() {
        return mForeignWord;
    }

    public void setmForeignWord(String mForeignWord) {
        this.mForeignWord = mForeignWord;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public void setmDefaultWord(String mDefaultWord) {
        this.mDefaultWord = mDefaultWord;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    @Override
    public String toString() {
        return "CustomWords{" +
                "mForeignWord='" + mForeignWord + '\'' +
                ", mDefaultWord='" + mDefaultWord + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
