package com.example.tp3_apis3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;

public class MainActivity extends Activity {

    public static String _searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager adminFragment;
        FragmentTransaction transacFragment;
        Fragment fragmentMain = new MainFragment();

        adminFragment   = getFragmentManager();
        transacFragment = adminFragment.beginTransaction();
        transacFragment.replace(R.id.lytMain, fragmentMain);
        transacFragment.commit();
    }

    public static void setSearchString(String value){
        _searchString = value;
    }

    public static String getSearchString() {
        return _searchString;
    }
}
