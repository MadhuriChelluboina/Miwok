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
        mFamilyArrayList.add(new CustomWords("әpә","father"));
        mFamilyArrayList.add(new CustomWords("әṭa","mother"));
        mFamilyArrayList.add(new CustomWords("angsi","son"));
        mFamilyArrayList.add(new CustomWords("tune","daughter"));
        mFamilyArrayList.add(new CustomWords("taachi","older brother"));
        mFamilyArrayList.add(new CustomWords("chalitti","younger brother"));
        mFamilyArrayList.add(new CustomWords("teṭe","older sister"));
        mFamilyArrayList.add(new CustomWords("kolliti","young sister"));
        mFamilyArrayList.add(new CustomWords("ama","grand mother"));
        mFamilyArrayList.add(new CustomWords("paapa","grand father"));

        ListView listView = findViewById(R.id.root_listView);
        CustomAdapter adapter = new CustomAdapter(this,mFamilyArrayList);
        listView.setAdapter(adapter);
    }
}
