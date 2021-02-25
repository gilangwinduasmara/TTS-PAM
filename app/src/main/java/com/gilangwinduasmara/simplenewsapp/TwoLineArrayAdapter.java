package com.gilangwinduasmara.simplenewsapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class TwoLineArrayAdapter<T> extends ArrayAdapter<T> {
    private int id;
    protected ArrayList<T> objects;
    public TwoLineArrayAdapter(Context context, ArrayList<T> objects) {
        this(context, android.R.layout.two_line_list_item, (T[]) objects.toArray());
        this.objects = objects;
    }

    public TwoLineArrayAdapter(
            Context context,
            int listItemLayoutResourceId,
            T[] ts) {
        super(context, listItemLayoutResourceId, ts);
        id = listItemLayoutResourceId;
    }

    @Override
    public android.view.View getView(
            int position,
            View convertView,
            ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItemView = convertView;
        if (null == convertView) {
            listItemView = inflater.inflate(
                    id,
                    parent,
                    false);
        }

        TextView lineOneView = (TextView)listItemView.findViewById(
                android.R.id.text1);
        TextView lineTwoView = (TextView)listItemView.findViewById(
                android.R.id.text2);

        T t = (T)getItem(position);
        lineOneView.setText(lineOneText(t));
        lineTwoView.setText(lineTwoText(t));
        return listItemView;
    }

    @Override
    public int getCount(){
        return this.objects.size();
    }


    public abstract String lineOneText(T t);

    public abstract String lineTwoText(T t);
}
