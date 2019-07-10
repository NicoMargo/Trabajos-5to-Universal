package com.example.devandroid.tp3apis;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadByCatFragment();
    }

    private void LoadByCatFragment(){
        FragmentManager adminFragment;
        FragmentTransaction transacFragment;
        Fragment fragmentByCat = new byCatFragment();

        adminFragment   = getFragmentManager();
        transacFragment = adminFragment.beginTransaction();
        transacFragment.replace(R.id.lytMain, fragmentByCat);
        transacFragment.commit();
    }
}
