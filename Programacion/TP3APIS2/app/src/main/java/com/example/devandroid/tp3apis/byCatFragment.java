package com.example.devandroid.tp3apis;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class byCatFragment extends Fragment {
    ListView lvList;
    Button btnPrevious;
    Button btnNext;
    View rootView;
    private int ElementPage = 0;

    public static ArrayList listCat;
    public ArrayAdapter myAdapter;

    public byCatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        getReferences();
        setListeners();
        listCat = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1,listCat);
        Log.d("API","API comienzo");
        AsynchronicTask myTask = new AsynchronicTask();
        myTask.SetAdapterAndArray(myAdapter,lvList);
        myTask.execute();
        Log.d("API Finish","API Finish Ready");
        return rootView;
    }

    private void getReferences(){
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        btnPrevious = (Button)rootView.findViewById(R.id.btnPrevious);;
        btnNext = (Button)rootView.findViewById(R.id.btnNext);;
    }

    private void setListeners(){
        //lvList.setOnItemClickListener();
        btnPrevious.setOnClickListener(btnPrevious_Click);
        btnNext.setOnClickListener(btnNext_Click);
    }


    private View.OnClickListener btnPrevious_Click= new View.OnClickListener() {

        public void onClick(View v) {
            if(ElementPage>0) ElementPage--;
            _lvList.subList(10*ElementPage,10*(ElementPage+1)).setAdapter(_myAdapter);;
        }
    };

    private View.OnClickListener btnNext_Click= new View.OnClickListener() {

        public void onClick(View v) {
            if(ElementPage<_lvList.length()/10+1) {
                ElementPage++;
            }
            _lvList.subList(10*ElementPage,10*(ElementPage+1)).setAdapter(_myAdapter);;
        }
    };
}