package com.example.tp3_apis3;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class byCatFragment extends LocationsFragment {

    String _categoria;
    public byCatFragment() {
        super();
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater,container,savedInstanceState);
        AsyncSearch myTask = new AsyncSearch(_elements,"buscar","categorias",_categoria);
        myTask.SetAdapterAndArray(_myAdapter,lvList);
        myTask.execute();
        return rootView;
    }

    public void getReferences(){
        super.getReferences();


    }
}
