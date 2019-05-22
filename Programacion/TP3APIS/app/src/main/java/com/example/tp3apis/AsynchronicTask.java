package com.example.tp3apis;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class AsynchronicTask extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void ... voids){
        try{
            URL myRoute = new URL("http://epok.buenosaires.gob.ar/getCategorias");
            HttpsURLConnection myConection =(HttpsURLConnection)myRoute.openConnection();
            Log.d("AccesoApi","Conectando...");
            if(myConection.getResponseCode()==200){
                Log.d("AccesoApi","OK!");
                InputStream bodyResponse = myConection.getInputStream();
            }

        }
        catch(Exception error){

        }
        return null;
    }
}
