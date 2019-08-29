package com.example.tp4omdb2;


import android.os.Bundle;
import android.app.Fragment;
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
public abstract class  LocationsFragment extends Fragment {

    ListView lvList;
    Button btnPrevious;
    Button btnNext;
    View rootView;
    private int ElementPage = 0;

    public static ArrayList _elements;
    public ArrayAdapter _myAdapter;

    public LocationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);

        getReferences();
        setListeners();

        _elements = new ArrayList<>();
        _myAdapter = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_list_item_1, _elements);

        return rootView;
    }

    protected void getReferences(){
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        btnPrevious = (Button)rootView.findViewById(R.id.btnPrevious);;
        btnNext = (Button)rootView.findViewById(R.id.btnNext);;
    }

    protected void setListeners(){
        //lvList.setOnItemClickListener();
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




