package com.gilangwinduasmara.simplenewsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewBody = view.findViewById(R.id.textViewBody);

        try{
            String title = getArguments().getString(MainActivity.SELECTED_NEWS_TITLE_KEY);
            String body = getArguments().getString(MainActivity.SELECTED_NEWS_BODY_KEY);
            News news = getArguments().getParcelable(MainActivity.SELECTED_NEWS);
            if(news != null){
                textViewTitle.setText(news.getTitle());
                textViewBody.setText(news.getBody());
            }
        }catch (Exception e){

        }
        return view;
    }
}