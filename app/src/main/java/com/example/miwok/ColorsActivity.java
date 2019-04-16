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

        colorsArrayList.add(new CustomWords("weṭeṭṭi","red"));
        colorsArrayList.add(new CustomWords("chokokki","green"));
        colorsArrayList.add( new CustomWords("ṭakaakki","brown"));
        colorsArrayList.add(new CustomWords("ṭopoppi","gray"));
        colorsArrayList.add(new CustomWords("kululli","black"));
        colorsArrayList.add(new CustomWords("kelelli","white"));
        colorsArrayList.add(new CustomWords("ṭakaakki","dusty yellow"));
        colorsArrayList.add(new CustomWords("chiwiiṭә","mustard yellow"));

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
