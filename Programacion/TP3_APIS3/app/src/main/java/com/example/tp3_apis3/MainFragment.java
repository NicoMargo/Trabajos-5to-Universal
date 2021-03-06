package com.example.tp3_apis3;

import android.app.Activity;
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
    Button btnByCat;
    Button btnByName;
    Button btnByGeo;
    ListView lvList;
    View rootView;
    EditText edtName;
    EditText edtX;
    EditText edtY;
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
        btnByCat = (Button) rootView.findViewById(R.id.btnByCat);
        edtName = (EditText) rootView.findViewById(R.id.edtName);
        btnByName = (Button) rootView.findViewById(R.id.btnByName);
        edtX = (EditText) rootView.findViewById(R.id.edtX);
        edtY = (EditText) rootView.findViewById(R.id.edtY);
        btnByGeo = (Button) rootView.findViewById(R.id.btnByGeo);
    }

    private void setListeners(){
        btnByCat.setOnClickListener(btnCat_Click);
        btnByName.setOnClickListener(btnName_Click);
        btnByGeo.setOnClickListener(btnGeo_Click);
    }

    private View.OnClickListener btnCat_Click= new View.OnClickListener() {
        public void onClick(View v) {
            FragmentManager adminFragment;
            FragmentTransaction transacFragment;
            getCatFragment fragmentByCat = new getCatFragment();

            adminFragment   = getFragmentManager();
            transacFragment = adminFragment.beginTransaction();
            transacFragment.replace(R.id.lytMain, fragmentByCat);
            transacFragment.commit();

        }
    };
    private View.OnClickListener btnName_Click= new View.OnClickListener() {
        public void onClick(View v) {
            MainActivity Main = (MainActivity)getActivity();
            Main.CambiarByName(edtName.getText().toString());

        }
    };

    private View.OnClickListener btnGeo_Click= new View.OnClickListener() {
        public void onClick(View v) {
            FragmentManager adminFragment;
            FragmentTransaction transacFragment;
            byGeoFragment geoFragment = new byGeoFragment();

            adminFragment   = getFragmentManager();
            transacFragment = adminFragment.beginTransaction();
            transacFragment.replace(R.id.lytMain, geoFragment);
            transacFragment.commit();
        }
    };

}
