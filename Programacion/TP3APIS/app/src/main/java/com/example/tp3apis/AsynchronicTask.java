package com.example.tp3apis;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class AsynchronicTask extends AsyncTask<Void,Void,Void> {
    ArrayAdapter  _myAdapter;
    ListView _lvList;
    public void SetAdapterAndArray(ArrayAdapter  myAdapter, ListView myListView ){
        _myAdapter = myAdapter;
        _lvList = myListView;
    }
    @Override
    protected Void doInBackground(Void ... voids){
        try{
            URL myRoute = new URL("http://epok.buenosaires.gob.ar/getCategorias");
            HttpURLConnection myConection =(HttpURLConnection) myRoute.openConnection();
            Log.d("AccesoApi","Primer Conectando...");
            Log.d("AccesoAPI", "" + myConection.getResponseCode());
            if(myConection.getResponseCode() ==200){
                Log.d("AccesoApi","OK!");
                InputStream bodyResponse = myConection.getInputStream();
                InputStreamReader responseReader = new InputStreamReader(bodyResponse,"UTF-8");
            }
            else{
                Log.d("AccesoApi","Alto Fail We xd!");
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
}
