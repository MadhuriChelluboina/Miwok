package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayList<CustomWords> colorsArrayList = new ArrayList<>();

        colorsArrayList.add(new CustomWords("weṭeṭṭi","red",R.drawable.color_red));
        colorsArrayList.add(new CustomWords("chokokki","green",R.drawable.color_green));
        colorsArrayList.add( new CustomWords("ṭakaakki","brown",R.drawable.color_brown));
        colorsArrayList.add(new CustomWords("ṭopoppi","gray",R.drawable.color_gray));
        colorsArrayList.add(new CustomWords("kululli","black",R.drawable.color_black));
        colorsArrayList.add(new CustomWords("kelelli","white",R.drawable.color_white));
        colorsArrayList.add(new CustomWords("ṭakaakki","dusty yellow",R.drawable.color_dusty_yellow));
        colorsArrayList.add(new CustomWords("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow));

        ListView listView = findViewById(R.id.root_listView);
        CustomAdapter customAdapter = new CustomAdapter(this,colorsArrayList);
        listView.setAdapter(customAdapter);


//        for(int i=0;i<colorsList.size();i++)
//        {
//            TextView textView = new TextView(this);
//            textView.setText(colorsList.get(i));
//            rootView.addView(textView);
//        }


    }
}
