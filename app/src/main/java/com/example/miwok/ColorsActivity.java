package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        LinearLayout rootView  = findViewById(R.id.rootView);
        ArrayList<String> colorsList = new ArrayList<>();
        colorsList.add("red");
        colorsList.add("green");
        colorsList.add("yellow");
        colorsList.add("blue");

        for(int i=0;i<colorsList.size();i++)
        {
            TextView textView = new TextView(this);
            textView.setText(colorsList.get(i));
            rootView.addView(textView);
        }


    }
}
