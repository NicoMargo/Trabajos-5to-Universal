package com.example.tp4omdb2;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
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

public class AsyncSearch extends AsyncTask<Void,Void,Void> {
    ArrayAdapter  _myAdapter;
    ListView _lvList;
    String _action;
    ArrayList<Movie> _movies;

    public AsyncSearch(ArrayList<Movie> movies, String param, String value){
        super();
        _movies = movies;
        _action = "/?apikey=bf466bc4&"+param+"="+value;
    }

    public void SetAdapterAndArray(ArrayAdapter  myAdapter, ListView myListView){
        _myAdapter = myAdapter;
        _lvList = myListView;
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
        _lvList.setAdapter(_myAdapter);
    }



    public void ProcessJSON(InputStreamReader ReadStream) {//Read Past Tense :V

        JsonParser MyJsonParser;
        MyJsonParser = new JsonParser();
        JsonObject objJson;
        objJson = MyJsonParser.parse(ReadStream).getAsJsonObject();
        JsonArray arrMovies;
        arrMovies = objJson.get("Search").getAsJsonArray();
    }}/*

        //while(arrMovies.)

       /* JsonReader myJsonReader= new JsonReader(ReadStream);
        try{
            myJsonReader.beginObject();
            while(myJsonReader.hasNext()){
                String objName;
                try{ objName = myJsonReader.nextName();}
                catch(Exception e){objName = "";}
                if("instancias".equals(objName)){
                    //Beginning to read array Instancias
                    myJsonReader.beginArray();
                    while(myJsonReader.hasNext()){
                        //Beginning to read object Instancia
                        myJsonReader.beginObject();
                        while(myJsonReader.hasNext()){
                            objName = myJsonReader.nextName();
                            if(objName.equals("nombre")){
                                String LocationName = myJsonReader.nextString();
                                //_movies.add(LocationName);

    }
}
*/