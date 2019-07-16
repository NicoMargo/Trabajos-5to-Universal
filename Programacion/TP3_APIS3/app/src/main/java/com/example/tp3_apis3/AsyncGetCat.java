package com.example.tp3_apis3;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncGetCat extends AsyncTask<Void,Void,Void> {
    ArrayAdapter  _myAdapter;
    ListView _lvList;
    String _action;


    public void SetAdapterAndArray(ArrayAdapter  myAdapter, ListView myListView){
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
                ProcessJSON(responseReader);
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


    public void ProcessJSON(InputStreamReader ReadStream){//Read Past Tense :V
        JsonReader myJsonReader= new JsonReader(ReadStream);
        try{
            myJsonReader.beginObject();
            while(myJsonReader.hasNext()){
                String objName = myJsonReader.nextName();
                if(objName.equals("instancias")){
                    //Beginning to read array Instancias
                    myJsonReader.beginArray();
                    while(myJsonReader.hasNext()){
                        //Beginning to read object Instancia
                        myJsonReader.beginObject();
                        while(myJsonReader.hasNext()){
                            objName = myJsonReader.nextName();
                            String CategoryName;
                            switch(objName){
                                case "nombre" :
                                    CategoryName = myJsonReader.nextString();
                                    //getCatFragment.listCat.add(CategoryName);
                                    break;
                                case "clase" :
                                    CategoryName = myJsonReader.nextString();
                                    //getCatFragment.listCat.add(CategoryName);
                                    break;
                                default:
                                    myJsonReader.skipValue();
                            }
                        }
                        myJsonReader.endObject();
                    }
                    myJsonReader.endArray();
                }
            }
        }//Fin del try
        catch(Exception e){

        }

    }
}
