package com.gilangwinduasmara.simplenewsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.gilangwinduasmara.simplenewsapp.MainActivity.CREATE_NEWS_RESULT_CODE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListNewsFragment extends Fragment {

    private ListView listViewNews;
    private ArrayList<News> newsList = new ArrayList<>();;
    private Button buttonAdd;
    private NewsAdapter adapter;

    public ListNewsFragment() {
        // Required empty public constructor
    }

    public static ListNewsFragment newInstance(String param1, String param2) {
        ListNewsFragment fragment = new ListNewsFragment();
        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CREATE_NEWS_RESULT_CODE){
            if(resultCode == RESULT_OK){
                Log.d("tes", "result ok");
                Log.d("tes", data.getParcelableExtra(MainActivity.CREATED_NEWS).toString());
                newsList.add((News) data.getParcelableExtra(MainActivity.CREATED_NEWS));
                adapter = new NewsAdapter(getContext(), newsList);
                listViewNews.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_news, container, false);
        listViewNews = view.findViewById(R.id.listViewNews);
        buttonAdd = view.findViewById(R.id.buttonAdd);
        newsList.add(new News("Berita 1", "isi 1"));
        newsList.add(new News("Berita 2", "isi 2"));
        adapter = new NewsAdapter(getContext(), newsList);
        listViewNews.setAdapter(adapter);
        listViewNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                News selectedNews = (News)newsList.get(i);
                Log.d("list", selectedNews.getTitle());
                MainActivity parent = (MainActivity)getActivity();
                parent.setSelectedNews(selectedNews);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNews();
            }
        });
        return view;
    }

    public void createNews(){
        Intent intent = new Intent(getActivity(), CreateNewsActivity.class);
        startActivityForResult(intent, CREATE_NEWS_RESULT_CODE);
    }
}