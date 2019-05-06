package com.example.tp2juegodefusibles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private Boton Buttons[][];
    private Button btnBack;
    private Button btnFoward;
    private Button btnGame;
    private final int iCantButtonsX = 3;
    private final int iCantButtonsY = 3;
    private ArrayList<Integer> MOVES;
    private ArrayList<Integer> EstadoActual;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent elIntent = getIntent();
        Bundle datos = elIntent.getExtras();
        MOVES = datos.getIntegerArrayList (MainActivity.PAREMETER1);
        EstadoActual = datos.getIntegerArrayList(MainActivity.PAREMETER2);
        Buttons = new Boton[iCantButtonsX][iCantButtonsY];
        getReferences();
        SetearListeners();
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
        btnBack = (Button)findViewById(R.id.btnBack);
        btnFoward = (Button)findViewById(R.id.btnFoward);
        btnGame = (Button)findViewById(R.id.btnGame);
    }
    private void SetearListeners() {
        for(int i = 0; i<iCantButtonsX;i++){
            for(int j = 0; j<iCantButtonsY;j++){
                Button btnButton = Buttons[i][j].getButton();
                TableLayout tblyTable =(TableLayout)findViewById(R.id.tblyTable);
                btnButton.getLayoutParams().width =  tblyTable.getLayoutParams().width/iCantButtonsX;
                btnButton.getLayoutParams().height =  btnButton.getLayoutParams().width;
            }
        }

        for (int y = 0; y <= iCantButtonsY  ; y++){
            for (int x = 0; x <= iCantButtonsX; x++){
                if (EstadoActual.get(i) == 1){
                    Buttons[x][y].changeActivo();
                }
                i++;
            }
        }

        btnBack.setOnClickListener(btnBack_Click);
        btnFoward.setOnClickListener(btnFoward_Click);
        btnGame.setOnClickListener(btnGame_Click);
    }
    private View.OnClickListener btnBack_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };//Fin de la funcion onClickListener

    private View.OnClickListener btnFoward_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };//Fin de la funcion onClickListener

    private View.OnClickListener btnGame_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };//Fin de la


}
