package com.example.tp2juegodefusibles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;

import java.io.Console;
import java.util.logging.ConsoleHandler;

public class GameActivity extends AppCompatActivity {

    private Boton Buttons[][];

    private final int iCantElementosX = 3;
    private final int iCantElementosY = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Buttons = new Boton[iCantElementosX][iCantElementosY];
        Log.d("xd","xd");

    }

    private void getReferences(){
        Buttons[0][0] = new Boton((Button)findViewById(R.id.btn00),false);
        Buttons[0][1] = new Boton((Button)findViewById(R.id.btn01),false);
        Buttons[0][2] = new Boton((Button)findViewById(R.id.btn02),false);
        Buttons[1][0] = new Boton((Button)findViewById(R.id.btn03),false);
        Buttons[1][1] = new Boton((Button)findViewById(R.id.btn04),false);
        Buttons[1][2] = new Boton((Button)findViewById(R.id.btn05),false);
        Buttons[2][0] = new Boton((Button)findViewById(R.id.btn06),false);
        Buttons[2][1] = new Boton((Button)findViewById(R.id.btn07),false);
        Buttons[2][2] = new Boton((Button)findViewById(R.id.btn08),false);
    }

    private void SetearListeners() {
        for(int i = 0; i<iCantElementosX;i++){
            for(int j = 0; j<iCantElementosY;j++){
               // Buttons[i][j].getButton().setOnClickListener(Buttons[i][j].getButton());
            }
        }
    }


    private View.OnClickListener btnTest_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };//Fin de la funcion onClickListener

}
