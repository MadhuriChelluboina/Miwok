package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayList<CustomWords> mFamilyArrayList = new ArrayList<>();
        mFamilyArrayList.add(new CustomWords("әpә","father",R.drawable.family_father));
        mFamilyArrayList.add(new CustomWords("әṭa","mother",R.drawable.family_mother));
        mFamilyArrayList.add(new CustomWords("angsi","son",R.drawable.family_son));
        mFamilyArrayList.add(new CustomWords("tune","daughter",R.drawable.family_daughter));
        mFamilyArrayList.add(new CustomWords("taachi","older brother",R.drawable.family_older_brother));
        mFamilyArrayList.add(new CustomWords("chalitti","younger brother",R.drawable.family_younger_brother));
        mFamilyArrayList.add(new CustomWords("teṭe","older sister",R.drawable.family_older_sister));
        mFamilyArrayList.add(new CustomWords("kolliti","young sister",R.drawable.family_younger_sister));
        mFamilyArrayList.add(new CustomWords("ama","grand mother",R.drawable.family_grandmother));
        mFamilyArrayList.add(new CustomWords("paapa","grand father",R.drawable.family_grandfather));

        ListView listView = findViewById(R.id.root_listView);
        CustomAdapter adapter = new CustomAdapter(this,mFamilyArrayList,R.color.family_color);
        listView.setAdapter(adapter);
    }
}
