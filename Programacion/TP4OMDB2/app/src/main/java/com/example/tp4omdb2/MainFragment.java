package com.example.tp4omdb2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainFragment extends Fragment {
    EditText edtSearch;
    Button btnSearch;
    ListView lvList;
    View rootView;
    public static ArrayList listCat;
    public ArrayAdapter myAdapter;
    public MainFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        getReferences();
        setListeners();
        Log.d("Main Fragment 1","Main Fragment 1");

        return rootView;
    }

    private void getReferences(){
        edtSearch = (EditText) rootView.findViewById(R.id.edtSearch);
        btnSearch = (Button) rootView.findViewById(R.id.btnSearch);
    }

    private void setListeners(){
        btnSearch.setOnClickListener(btnSearch_Click);
    }

    private View.OnClickListener btnSearch_Click= new View.OnClickListener() {
        public void onClick(View v) {
            MainActivity.setSearchString(edtSearch.getText().toString());
            StartResultsFragment();
        }
    };

    private void StartResultsFragment(){
        FragmentManager adminFragment;
        FragmentTransaction transacFragment;
        ResultsFragment fragmentResults = new ResultsFragment();

        adminFragment   = getFragmentManager();
        transacFragment = adminFragment.beginTransaction();
        transacFragment.replace(R.id.lytMain, fragmentResults);
        transacFragment.commit();
    }

}
