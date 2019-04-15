package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
//        LinearLayout mNumbers_rootView  = findViewById(R.id.numbers_rootView);

        ArrayList<String> mNumbersList = new ArrayList<>();
        mNumbersList.add("one");
        mNumbersList.add("two");
        mNumbersList.add("three");
        mNumbersList.add("four");
        mNumbersList.add("five");
        mNumbersList.add("six");
        mNumbersList.add("seven");
        mNumbersList.add("eight");
        mNumbersList.add("nine");
        mNumbersList.add("ten");


//        for(int index=0;index<mNumbersList.size();index++)
//        {
//            TextView mNumbers_textView = new TextView(this);
//            mNumbers_textView.setText(mNumbersList.get(index));
//            mNumbers_rootView.addView(mNumbers_textView);
//        }

        ArrayAdapter<String> numbersAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mNumbersList);
        ListView mNumbers_ListView = findViewById(R.id.numbers_rootView);
        mNumbers_ListView.setAdapter(numbersAdapter);

    }
}
