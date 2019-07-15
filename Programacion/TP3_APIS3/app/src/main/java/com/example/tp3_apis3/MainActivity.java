package com.example.tp3_apis3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnByCat;
    Button btnByName;
    Button btnByGeo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setListeners();
    }

    private void getReferences(){
        btnByCat = (Button) findViewById(R.id.btnByCat);
        btnByName = (Button) findViewById(R.id.btnByName);
        btnByGeo = (Button) findViewById(R.id.btnByGeo);
    }

    private void setListeners(){
        btnByCat.setOnClickListener(btnCat_Click);
        btnByName.setOnClickListener(btnGeo_Click);
        btnByGeo.setOnClickListener(btnName_Click);
    }

    private View.OnClickListener btnCat_Click= new View.OnClickListener() {

        public void onClick(View v) {
            FragmentManager adminFragment;
            FragmentTransaction transacFragment;
            Fragment fragmentByCat = new byCatFragment();

            adminFragment   = getFragmentManager();
            transacFragment = adminFragment.beginTransaction();
            transacFragment.replace(R.id.lytMain, fragmentByCat);
            transacFragment.commit();
        }
    };
    private View.OnClickListener btnName_Click= new View.OnClickListener() {

        public void onClick(View v) {

        }
    };

    private View.OnClickListener btnGeo_Click= new View.OnClickListener() {

        public void onClick(View v) {

        }
    };

}
