package com.example.tp4omdb2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private ArrayList<Movie> _movies;
    private Context _myContext;

    public MovieAdapter(ArrayList<Movie> movies, Context myContext){
        _movies = movies;
        _myContext = myContext;
    }

    public int getCount(){
        return _movies.size();
    }

    public Movie getItem(int index){
        if(_movies.size()>index)
        { return _movies.get(index); }
        else return null;
    }

    public long getItemId(int index){
        if(_movies.size()>index)
        { return index; }
        else return -1;
    }

    public View getView(int pos, View view, ViewGroup group){
        View viewToReturn;
        viewToReturn = null;


        LayoutInflater inflater = (LayoutInflater)_myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewToReturn = inflater.inflate(R.layout.listviewitem_movie,group,false);
        TextView txtTitle = viewToReturn.findViewById(R.id.txtTitle);
        txtTitle.setText();

        return viewToReturn;
    }
}
