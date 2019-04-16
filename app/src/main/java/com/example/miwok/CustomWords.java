package com.example.miwok;

public class CustomWords {

    private String mForeignWord;
    private String mDefaultWord;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED =-1;

    public CustomWords(String mForeignWord, String mDefaultWord) {
        this.mForeignWord = mForeignWord;
        this.mDefaultWord = mDefaultWord;
    }


    public CustomWords(String mForeignWord, String mDefaultWord, int mImageResourceId) {
        this.mForeignWord = mForeignWord;
        this.mDefaultWord = mDefaultWord;
        this.mImageResourceId = mImageResourceId;
    }
    public boolean hasImage(){
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
}
