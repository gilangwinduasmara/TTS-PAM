package com.gilangwinduasmara.simplenewsapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class NewsAdapter extends TwoLineArrayAdapter<News> {

    private ArrayList<News> news;
    public NewsAdapter(@NonNull Context context, ArrayList<News> news) {
        super(context, news);
        this.news = news;
    }

    @Override
    public android.view.View getView(
            int position,
            View convertView,
            ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.news_item, parent, false);

        TextView textViewTitle = (TextView)view.findViewById(R.id.textViewTitle);
        TextView textViewBody = (TextView)view.findViewById(R.id.textViewBody);

        News news = (News)getItem(position);
        textViewTitle.setText(lineOneText(news));
        textViewBody.setText(lineTwoText(news));

        if(lineOneText(news).length()>10){
            textViewTitle.setText(lineOneText(news).substring(0, 10)+"...");
        }
        if(lineTwoText(news).length()>30){
            textViewBody.setText(lineTwoText(news).substring(0, 30)+"...");
        }

        return view;
    }


    @Override
    public int getCount(){
        return this.news.size();
    }

    @Override
    public String lineOneText(News news) {
        return news.getTitle();
    }

    @Override
    public String lineTwoText(News news) {
        return news.getBody();
    }

}
