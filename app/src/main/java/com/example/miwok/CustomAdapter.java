package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CustomWords> {
    public CustomAdapter(Context context, ArrayList<CustomWords> customWords) {
        super(context, 0, customWords);
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

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

            //listview will take this return value and add this to itself as its child view
            return listItemView;
        }
    }
