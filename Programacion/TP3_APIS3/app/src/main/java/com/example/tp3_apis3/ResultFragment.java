package com.example.tp3_apis3;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ResultFragment extends Fragment {
    ListView lvList;
    View rootView;
    Button btnPrevious;
    Button btnNext;
    public static ArrayList resultList;
    public ArrayAdapter myAdapterResult;
    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        getReferences();
        setListeners();
        resultList = new ArrayList<>();
        int top = resultList.size()/10>0? 10:resultList.size()%10;
        myAdapterResult = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_list_item_1, resultList);
        Log.d("API","API comienzo");
        AsyncGetCat myTask = new AsyncGetCat();
        myTask.SetAdapterAndArray(myAdapterResult,lvList);
        myTask.execute();
        return rootView;
    }

    private void getReferences(){
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        btnPrevious = (Button)rootView.findViewById(R.id.btnPrevious);;
        btnNext = (Button)rootView.findViewById(R.id.btnNext);;
    }

    private void setListeners(){
        btnPrevious.setOnClickListener(btnPrevious_Click);
        btnNext.setOnClickListener(btnNext_Click);
    }


    private View.OnClickListener btnPrevious_Click= new View.OnClickListener() {
        public void onClick(View v) {
        }
    };

    private View.OnClickListener btnNext_Click= new View.OnClickListener() {
        public void onClick(View v) {

        }
    };

}
