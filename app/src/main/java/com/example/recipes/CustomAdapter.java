package com.example.recipes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

class CustomAdapter extends ArrayAdapter<recipes> {

    List<recipes> recipesList;
    Context context;
    int resource;


    public CustomAdapter(Context context, int resource, List<recipes> recipesList) {
        super(context, R.layout.custom_row,recipesList);
        this.context = context;
        this.resource = resource;
        this.recipesList = recipesList;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {

        LayoutInflater buckyInflater=LayoutInflater.from(getContext());
        View customView= buckyInflater.inflate(R.layout.custom_row,parent,false);


        TextView chineseTextView= (TextView) customView.findViewById(R.id.chineseTextView);
        ImageView imgView=(ImageView)customView.findViewById(R.id.imgView);
        imgView.setImageResource(R.drawable.chinese);

        recipes recipe = recipesList.get(position);

        imgView.setImageDrawable(context.getResources().getDrawable(recipe.getImage()));
        chineseTextView.setText(recipe.getName());


        return customView;

    }
}