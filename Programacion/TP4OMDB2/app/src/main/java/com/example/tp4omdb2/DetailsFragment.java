package com.example.tp4omdb2;


import android.app.Fragment;
import android.os.Bundle;
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
public class DetailsFragment extends LocationsFragment {
    ListView lvList;
    Button btnPrevious;
    Button btnNext;
    View rootView;
    private int ElementPage = 0;

    public static ArrayList listCat;
    public ArrayAdapter myAdapter;

    float x;
    float y;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        AsyncSearch myTask = new AsyncSearch(_elements, "i", "xd");
        myTask.SetAdapterAndArray(_myAdapter, lvList);
        myTask.execute();
        return rootView;
    }

    protected void getReferences() {
        super.getReferences();
    }
}