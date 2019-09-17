package com.example.tp4omdb2;

import android.os.AsyncTask;
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

public abstract class AsyncSearch extends AsyncTask<Void,Void,Void> {
    String _action;

    public AsyncSearch(String param, String value){
        super();
        _action = "/?apikey=bf466bc4&"+param+"="+value;
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
    }

    protected abstract void ProcessJSON(InputStreamReader ReadStream);

}