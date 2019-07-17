package com.example.tp3_apis3;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class byNameFragment extends LocationsFragment {

    String name;
    public void setName(String name){
        this.name = name;
    }


    public byNameFragment() {
        super();
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater,container,savedInstanceState);
        AsyncSearch myTask = new AsyncSearch(_elements,"buscar","texto",name);
        myTask.SetAdapterAndArray(_myAdapter,lvList);
        myTask.execute();
        return rootView;
    }

    public void getReferences(){
        super.getReferences();


    }
}
