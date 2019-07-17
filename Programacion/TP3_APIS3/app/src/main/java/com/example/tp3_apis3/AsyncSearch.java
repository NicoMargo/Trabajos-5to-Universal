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
import java.util.ArrayList;

public class AsyncSearch extends AsyncTask<Void,Void,Void> {
    ArrayAdapter  _myAdapter;
    ListView _lvList;
    String _action;
    ArrayList<String> _locations;

    public AsyncSearch(ArrayList<String> locations,String action, String param, String value){
        super();
        _locations = locations;
        _action = action +"/?"+param+"="+value;
    }

    public AsyncSearch(ArrayList<String> locations, String action, float x, float y ){
        super();
        _locations = locations;
        _action = action +"/?x="+x+"&y="+y;
    }

    public void SetAdapterAndArray(ArrayAdapter  myAdapter, ListView myListView){
        _myAdapter = myAdapter;
        _lvList = myListView;
    }
    @Override
    protected Void doInBackground(Void ... voids){
        try{
            URL myRoute = new URL("http://epok.buenosaires.gob.ar/"+ _action);
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
                                _locations.add(LocationName);
                            }
                            else{
                                myJsonReader.skipValue();
                            }
                        }
                        myJsonReader.endObject();
                    }
                    myJsonReader.endArray();
                }
                else{
                    myJsonReader.skipValue();
                }
            }
        }//Fin del try
        catch(Exception e){

        }

    }
}
