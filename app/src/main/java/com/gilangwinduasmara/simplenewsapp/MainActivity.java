package com.gilangwinduasmara.simplenewsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String SELECTED_NEWS_TITLE_KEY = "selected_news_title";
    public static final String SELECTED_NEWS_BODY_KEY = "selected_news_body";
    public static final String SELECTED_NEWS = "selected_news";
    public static final String CREATED_NEWS = "created_news";
    public static final int CREATE_NEWS_RESULT_CODE = 900;
    ArrayList<News> newsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setSelectedNews(News news){
        Bundle bundle = new Bundle();
        bundle.putParcelable(SELECTED_NEWS, news);
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayoutNews, newsFragment)
                .addToBackStack(null)
                .commit();
    }
}
