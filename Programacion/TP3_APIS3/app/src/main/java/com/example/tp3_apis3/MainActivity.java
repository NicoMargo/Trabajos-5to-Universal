package com.example.tp3_apis3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public static String name;
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

    public void CambiarByName(String name){
        FragmentManager adminFragment;
        FragmentTransaction transacFragment;

        Fragment nameFragment = new byNameFragment();
        ((byNameFragment) nameFragment).setName(name);

        adminFragment = getFragmentManager();
        transacFragment = adminFragment.beginTransaction();
        transacFragment.replace(R.id.lytMain, nameFragment);
        transacFragment.commit();
    }
}
