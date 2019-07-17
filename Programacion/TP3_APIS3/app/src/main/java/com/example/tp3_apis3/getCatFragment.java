package com.example.tp3_apis3;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;


public class getCatFragment extends LocationsFragment {
    private int ElementPage = 0;

    public getCatFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = super.onCreateView(inflater,container,savedInstanceState);
        int top = _elements.size()/10>0? 10:_elements.size()%10;
        AsyncGetCat myTask = new AsyncGetCat();
        myTask.SetAdapterAndArray(_myAdapter,lvList);
        myTask.execute();
        return rootView;
    }

    @Override
    protected void setListeners() {
        super.setListeners();
        lvList.setOnItemClickListener(lvList_Item_Click);
    }

    private ListView.OnItemClickListener lvList_Item_Click = new ListView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            String strCat = lvList.getItemAtPosition(position).toString();
            FragmentManager adminFragment;
            FragmentTransaction transacFragment;
            Fragment fragmentResult = new ResultFragment();

            adminFragment   = getFragmentManager();
            transacFragment = adminFragment.beginTransaction();
            transacFragment.replace(R.id.lytMain, fragmentResult);
            transacFragment.commit();
        }
    };
}
