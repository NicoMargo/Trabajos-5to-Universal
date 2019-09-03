package com.example.tp4omdb2;


import android.app.Fragment;
import android.os.Bundle;
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
public class DetailsFragment extends Fragment {
    ListView lvList;
    Button btnPrevious;
    Button btnNext;
    View rootView;
    private int ElementPage = 0;

    public static ArrayList _elements;
    public MovieAdapter _myAdapter;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Details Fragment 1","Details Fragment 1");
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        AsyncSearch myTask = new AsyncSearch(_elements, "i", "xd");
        myTask.SetAdapterAndArray(_myAdapter, lvList);
        myTask.execute();
        return rootView;
    }

    protected void getReferences() {
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        btnPrevious = (Button)rootView.findViewById(R.id.btnPrevious);;
        btnNext = (Button)rootView.findViewById(R.id.btnNext);;
    }
}