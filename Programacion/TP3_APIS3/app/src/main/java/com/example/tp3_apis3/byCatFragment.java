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
        int top = listCat.size()/10>0? 10:listCat.size()%10;
        myAdapter = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_list_item_1, listCat);
        Log.d("API","API comienzo");
        AsyncGetCat myTask = new AsyncGetCat();
        myTask.SetAdapterAndArray(myAdapter,lvList);
        myTask.execute();
        return rootView;
    }

    private void getReferences(){
        lvList = (ListView) rootView.findViewById(R.id._lvList);
        btnPrevious = (Button)rootView.findViewById(R.id.btnPrevious);;
        btnNext = (Button)rootView.findViewById(R.id.btnNext);;
    }

    private void setListeners(){
        lvList.setOnItemClickListener(lvList_Item_Click);
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
