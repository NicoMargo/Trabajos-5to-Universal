package com.example.tp4omdb2;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

//the asynchronous task that get the details of an specified movie
public class AsyncGetDetails extends AsyncSearch {
    //Selected movie instance
    Movie _movie;

    public AsyncGetDetails( String value, Movie movie){
        super("i",value);
        _movie = movie;

    }

    AsyncGetDetails.IOnFinishListener _event;
    public void set_onFinishListener(AsyncGetDetails.IOnFinishListener onFinishListener){
        _event = onFinishListener;
    }

    @Override
    protected Void doInBackground(Void ... voids){
        try{
            Log.d("AccesoApi","1");
            URL myRoute = new URL("http://www.omdbapi.com"+ _action);
            HttpURLConnection myConection =(HttpURLConnection) myRoute.openConnection();
            Log.d("AccesoApi","Primer Conectando...");
            if(myConection.getResponseCode() ==200){
                Log.d("AccesoApi","OK!");
                InputStream bodyResponse = myConection.getInputStream();
                InputStreamReader responseReader = new InputStreamReader(bodyResponse,"UTF-8");
                ProcessJSON(responseReader);
            }
            else{
            }
            myConection.disconnect();
        }
        catch(MalformedURLException error){
            Log.d("AccesoAPI","Url incorrecta");
        } catch (IOException error) {
            Log.d("AccesoAPI","IO");
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        _event.onFinish(_movie);
    }

    //process the json to the details of selected movie
    public void ProcessJSON(InputStreamReader ReadStream) {//Read Past Tense :V
        JsonParser MyJsonParser;
        MyJsonParser = new JsonParser();
        JsonObject objJson;
        objJson = MyJsonParser.parse(ReadStream).getAsJsonObject();
        _movie.resetDetails();
        for (String key:Movie.getMapKeys() ) {
            try{
            _movie.addDetail(key,objJson.get(key).getAsString());
            }catch (Exception e){}
        }
    }

    //event called when postExecute finishes
    public interface IOnFinishListener{
        void onFinish(Movie movie);
    }
}