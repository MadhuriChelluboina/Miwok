package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ListView listView = findViewById(R.id.root_listView);

        ArrayList<CustomWords> mPhrasesArrayList = new ArrayList<>();
        mPhrasesArrayList.add(new CustomWords("minto wuksus","Where are you going?"));
        mPhrasesArrayList.add(new CustomWords("tinnә oyaase'nә","What is your name?"));
        mPhrasesArrayList.add(new CustomWords("oyaaset...","My name is..."));
        mPhrasesArrayList.add(new CustomWords("michәksәs?","How are you feeling?"));
        mPhrasesArrayList.add(new CustomWords("kuchi achit","I’m feeling good."));
        mPhrasesArrayList.add(new CustomWords("әәnәs'aa?","Are you coming?"));
        mPhrasesArrayList.add(new CustomWords("hәә’ әәnәm","Yes, I’m coming."));
        mPhrasesArrayList.add(new CustomWords("әәnәm","I’m coming."));
        mPhrasesArrayList.add(new CustomWords("yoowutis","Let’s go."));
        mPhrasesArrayList.add(new CustomWords("әnni'nem","Come here."));

        CustomAdapter adapter = new CustomAdapter(this,mPhrasesArrayList,R.color.phrases_color);
        listView.setAdapter(adapter);
    }
}
