package com.example.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CustomWords> {
    private int mColorId;

    public CustomAdapter(Context context, ArrayList<CustomWords> customWords, int mColorId) {
        super(context, 0, customWords);
        this.mColorId = mColorId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //for understanding we are renaming convertview as listitemview
        View listItemView = convertView;
        if (listItemView == null) {
            //last @param is false because we don't want to attach this textview's
            // layout to parent right now after setting text to textviews will manually attach it
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_itemview, parent, false);
        }
        //getting current object from the listview asking / requesting view for that position
        CustomWords mCurrent_CustomWords = getItem(position);

        TextView mForeignTextView = listItemView.findViewById(R.id.foreign_textView);
        mForeignTextView.setText(mCurrent_CustomWords.getmForeignWord());

        TextView mNativeTextView = listItemView.findViewById(R.id.native_textView);
        mNativeTextView.setText(mCurrent_CustomWords.getmDefaultWord());

        if (mCurrent_CustomWords.hasImage()) {
            ImageView mImageView = listItemView.findViewById(R.id.icon_imageView);
            mImageView.setImageResource(mCurrent_CustomWords.getmImageResourceId());
            mImageView.setVisibility(View.VISIBLE);
        } else {
            ImageView mImageView = listItemView.findViewById(R.id.icon_imageView);
            mImageView.setVisibility(View.GONE);
        }
         View container = listItemView.findViewById(R.id.listView_container);
        int color = ContextCompat.getColor(getContext(),mColorId);
        container.setBackgroundColor(color);
        //listview will take this return value and add this to itself as its child view
        return listItemView;
    }
}

