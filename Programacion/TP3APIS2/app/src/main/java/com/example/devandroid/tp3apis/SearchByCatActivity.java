package com.example.devandroid.tp3apis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchByCatActivity extends AppCompatActivity {

    public static ArrayList listCat;
    public ListView  lvListOfCats;
    public ArrayAdapter myAdapter;
    private Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search_by_cat);
        getReferences();
        setListeners();
        listCat = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCat);
        Log.d("API","API comienzo");
        AsynchronicTask myTask = new AsynchronicTask();
        myTask.SetAdapterAndArray(myAdapter,lvListOfCats);
        myTask.execute();
        Log.d("API Finish","API Finish Ready");
    }

    void getReferences(){
       // lvListOfCats = (ListView) findViewById(R.id.ListCats);
       // btnSearch = (Button) findViewById(R.id.btnSearch);
    }
    void  setListeners(){
        btnSearch.setOnClickListener(btnSearch_Click);
    }
    View.OnClickListener btnSearch_Click = new View.OnClickListener(){
        public void onClick(View v){
            AsynchronicTask myTask = new AsynchronicTask();
            myTask.SetAdapterAndArray(myAdapter,lvListOfCats);
            myTask.execute();
        }
    };
}
