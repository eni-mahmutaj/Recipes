package com.example.recipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.annotation.SuppressLint;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<recipes> recipesList;
    ListView inListView;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar ab = getSupportActionBar();

        ab.setLogo(R.drawable.logo);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

       recipesList = new ArrayList<>();
       inListView = (ListView)findViewById(R.id.inListView);

       recipesList.add(new recipes(R.drawable.chinese, "Chinese recipes"));
       recipesList.add(new recipes(R.drawable.italian, "Italian recipes"));
       recipesList.add(new recipes(R.drawable.mexican, "Mexican recipes"));
       recipesList.add(new recipes(R.drawable.southern, "Southern recipes"));

        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row, recipesList);

        inListView.setAdapter(adapter);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        inListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(new Intent(MainActivity.this,ChineseActivity.class));
                }
                if(position == 1){
                    startActivity(new Intent(MainActivity.this,ItalianActivity.class));
                }
                if(position == 2){
                    startActivity(new Intent(MainActivity.this,MexicanActivity.class));
                }
                if(position == 3){
                    startActivity(new Intent(MainActivity.this,SouthernActivity.class));
                }
            }
        });


    }
}
