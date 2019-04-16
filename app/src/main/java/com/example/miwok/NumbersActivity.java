package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
//        LinearLayout mNumbers_rootView  = findViewById(R.id.numbers_rootView);

        ArrayList<CustomWords> mNumbersList = new ArrayList<>();
        mNumbersList.add(new CustomWords("lutti","one",R.drawable.number_one));
        mNumbersList.add(new CustomWords("otiiko","two",R.drawable.number_two));
        mNumbersList.add(new CustomWords("tolookosu","three",R.drawable.number_three));
        mNumbersList.add(new CustomWords("oyyisa","four",R.drawable.number_four));
        mNumbersList.add(new CustomWords("massokka","five",R.drawable.number_five));
        mNumbersList.add(new CustomWords("temmokka","six",R.drawable.number_six));
        mNumbersList.add(new CustomWords("kenekaku","seven",R.drawable.number_seven));
        mNumbersList.add(new CustomWords("kawinta","eight",R.drawable.number_eight));
        mNumbersList.add(new CustomWords("wo’e","nine",R.drawable.number_nine));
        mNumbersList.add(new CustomWords("na’aacha","ten",R.drawable.number_ten));


//        for(int index=0;index<mNumbersList.size();index++)
//        {
//            TextView mNumbers_textView = new TextView(this);
//            mNumbers_textView.setText(mNumbersList.get(index));
//            mNumbers_rootView.addView(mNumbers_textView);
//        }

        CustomAdapter customAdapter = new CustomAdapter(this,mNumbersList);
        ListView mNumbers_ListView = findViewById(R.id.root_listView);
        mNumbers_ListView.setAdapter(customAdapter);

    }
}
