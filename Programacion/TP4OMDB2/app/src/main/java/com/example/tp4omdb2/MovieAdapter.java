package com.example.tp4omdb2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private ArrayList<Movie> _movies;
    private Context _myContext;
    private TextView txtTitle;
    private TextView txtYear;
    private TextView txtType;
    private ImageView imgPoster;
    private Bitmap _convertedImage;
    public void setConvertedImage(Bitmap convertedImage){
        _convertedImage = convertedImage;
    }

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

    private void getViewReferences(View view){
        txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtYear = (TextView) view.findViewById(R.id.txtYear);
        txtType = (TextView) view.findViewById(R.id.txtType);
        imgPoster = (ImageView) view.findViewById(R.id.imgPoster);
    }

    public View getView(int pos, View view, ViewGroup group){
        LayoutInflater inflater = (LayoutInflater)_myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewToReturn = inflater.inflate(R.layout.listviewitem_movie,group,false);
        if(_movies.get(pos)!= null){
            getViewReferences(viewToReturn);
            txtTitle.setText("Title: "+_movies.get(pos).get_title());
            txtYear.setText("Year: "+(_movies.get(pos).get_year()).toString());
            txtType.setText("Type: "+_movies.get(pos).get_type());
            AsyncGetImage async = new AsyncGetImage(imgPoster);
            async.execute(_movies.get(pos).get_poster());
            async.set_onFinishListener(async_finish);
        }
        return viewToReturn;
    }

    AsyncGetImage.IOnFinishListener async_finish = new AsyncGetImage.IOnFinishListener() {
        @Override
        public void onFinish(Bitmap bitmapImage, ImageView imgPoster) {
            if(imgPoster!=null)
                imgPoster.setImageBitmap(bitmapImage);
        }
    };
}
