package com.example.hshack.healthandhappiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyDay extends AppCompatActivity {

    ListView recentFoods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_day);

        recentFoods = (ListView)findViewById(R.id.myDayListView);
        String[] vals = new String[]{
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v"
        };

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,vals);

        recentFoods.setAdapter(stringArrayAdapter);

    }
}
