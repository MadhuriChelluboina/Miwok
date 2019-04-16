package com.example.miwok;

public class CustomWords {

    private String mForeignWord;
    private String mDefaultWord;

    public CustomWords(String mForeignWord, String mDefaultWord) {
        this.mForeignWord = mForeignWord;
        this.mDefaultWord = mDefaultWord;
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
}
