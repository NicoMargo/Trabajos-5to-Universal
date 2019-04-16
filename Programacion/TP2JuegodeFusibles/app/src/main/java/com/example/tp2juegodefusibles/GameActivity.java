package com.example.tp2juegodefusibles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.widget.Button;

import java.io.Console;
import java.util.logging.ConsoleHandler;

public class GameActivity extends AppCompatActivity {

    private Boton Botones[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent elIntent = getIntent();
        Bundle datos = elIntent.getExtras();
        String Paremeter1 = datos.getString ("PARAMETER1");

        final int iCantElementosX = 3;
        final int iCantElementosY = 3;
        Botones = new Boton[iCantElementosX][iCantElementosY];
        Log.d("xd","xd");

    }

    private void getReferences(){


    }
}
