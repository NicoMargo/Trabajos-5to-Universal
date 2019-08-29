package com.example.tp4omdb2;


import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsFragment extends Fragment {

    ListView lvList;
    View rootView;

    public static ArrayList<Movie> _movies;
    public ArrayAdapter _myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        getReferences();
        setListeners();

        rootView = super.onCreateView(inflater,container,savedInstanceState);
        AsyncSearch myTask = new AsyncSearch(_movies,"s",MainActivity.getSearchString());
        myTask.SetAdapterAndArray(_myAdapter,lvList);
        myTask.execute();
        return rootView;
    }

    private void getReferences(){
        lvList = (ListView) rootView.findViewById(R.id._lvList);
    }

    public void setListeners(){ lvList.setOnItemClickListener(lvList_Item_Click);};

    private ListView.OnItemClickListener lvList_Item_Click = new ListView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            String strCat = lvList.getItemAtPosition(position).toString();
            FragmentManager adminFragment;
            FragmentTransaction transacFragment;
            Fragment fragmentDetails = new DetailsFragment();

            adminFragment   = getFragmentManager();
            transacFragment = adminFragment.beginTransaction();
            transacFragment.replace(R.id.lytMain, fragmentDetails);
            transacFragment.commit();
        }
    };
}