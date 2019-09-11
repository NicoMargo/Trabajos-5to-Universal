package com.example.tp4omdb2;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AsyncGetMovies extends AsyncSearch {
    MovieAdapter  _myAdapter;
    ListView _lvList;
    ArrayList<Movie> _movies;

    public AsyncGetMovies(ArrayList<Movie> movies, String value){
        super("s",value);
        _movies = movies;
    }

    public void setAdapterAndArray(MovieAdapter myAdapter, ListView myListView){
        _myAdapter = myAdapter;
        _lvList = myListView;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        if(_movies.size()>0) {
            _myAdapter.setMoviesList(Helpers.getSubListMovies(_movies, 0, FResultFragment.ITEMS_PER_PAGE));
            _lvList.setAdapter(_myAdapter);
        }
    }

    protected void ProcessJSON(InputStreamReader ReadStream) {//Read Past Tense :V
        _movies.clear();
        JsonParser MyJsonParser;
        MyJsonParser = new JsonParser();
        JsonObject objJson;
        objJson = MyJsonParser.parse(ReadStream).getAsJsonObject();
        JsonArray arrMovies;
        if(objJson.has("Search")){
            arrMovies = objJson.get("Search").getAsJsonArray();
            for (int i = 0; i < arrMovies.size(); i++) {
                JsonObject jsonObj;
                jsonObj = arrMovies.get(i).getAsJsonObject();
                Movie thisMovie = new Movie(jsonObj.get("Title").getAsString(), jsonObj.get("Year").getAsString(), jsonObj.get("imdbID").getAsString(), jsonObj.get("Type").getAsString(), jsonObj.get("Poster").getAsString());
                _movies.add(thisMovie);
            }
        }
    }
}