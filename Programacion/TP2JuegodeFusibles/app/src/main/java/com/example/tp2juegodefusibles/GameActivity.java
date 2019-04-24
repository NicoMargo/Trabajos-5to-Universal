package com.example.tp2juegodefusibles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.security.KeyStore;
import java.util.Random;
import java.io.Console;
import java.util.logging.ConsoleHandler;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Boton Buttons[][];
    private int iCantMoves = 0;
    public int getCantMoves(){
        return iCantMoves;
    }
    private final int iCantButtonsX = 3;
    private final int iCantButtonsY = 3;
    private Button btnBot;
    private Button btnRandom;
    private Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent elIntent = getIntent();
        Bundle datos = elIntent.getExtras();
        String Paremeter1 = datos.getString (MainActivity.PAREMETER1);

        Buttons = new Boton[iCantButtonsX][iCantButtonsY];

        Log.d("xd","xd");
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
        Random GeneradorRandom = new Random();
        Buttons[GeneradorRandom.nextInt(iCantButtonsX-0)][GeneradorRandom.nextInt(iCantButtonsY-0)].setActivo(true);
        btnBot = (Button)findViewById(R.id.btnBot);
        btnRandom = (Button)findViewById(R.id.btnRandom);;
        btnMenu = (Button)findViewById(R.id.btnMenu);;
    }

    private void SetearListeners() {
        for(int i = 0; i<iCantButtonsX;i++){
            for(int j = 0; j<iCantButtonsY;j++){
                Button btnButton = Buttons[i][j].getButton();
                btnButton.setOnClickListener(this);
                TableLayout tblyTable =(TableLayout)findViewById(R.id.tblyTable);
                btnButton.getLayoutParams().width =  tblyTable.getLayoutParams().width/iCantButtonsX;
                btnButton.getLayoutParams().height =  btnButton.getLayoutParams().width;
            }
        }
        btnBot.setOnClickListener(btnBot_Click);
        btnRandom.setOnClickListener(btnRandom_Click);
        btnMenu.setOnClickListener(btnMenu_Click);

    }

    @Override
    public void onClick(View v) {

        int iButtonPos = SearchButtonPos(v.getId());
        int iX = iButtonPos / iCantButtonsX;
        int iY = iButtonPos % iCantButtonsX;
        Buttons[iX][iY].changeActivo();
        if (iX > 0) {
            Buttons[iX - 1][iY].changeActivo();
        }
        if (iY > 0) {
            Buttons[iX][iY - 1].changeActivo();
        }
        if (iX < iCantButtonsX - 1 && iCantButtonsX - 1 != 0) {
            Buttons[iX + 1][iY].changeActivo();
        }
        if (iY < iCantButtonsY - 1 && iCantButtonsY - 1 != 0) {
            Buttons[iX][iY + 1].changeActivo();
        }
        if(WinGame()){
            IniciarSegundaActividad(true);
        }
    }//Fin de la funcion onClickListener
    //Funcion que devuelve que boton se toco dada una id
    public int SearchButtonPos(int id){
        int i = 0;
        int j = 0;
        boolean bFound = false;
        while( !bFound && i<iCantButtonsX){
            j = 0;
            while(!bFound && j<iCantButtonsY){
                if(Buttons[i][j].getButton().getId()==id){
                    bFound= true;
                }
                else j++;
            }
            if(!bFound) i++;
        }
        int iNmberOfButton = i * iCantButtonsX + j;
        return iNmberOfButton;
    }
    //Fucion una mandar a una nueva activity
    private void IniciarSegundaActividad(boolean bVictoria){
        Intent nuevaActividad = new Intent(GameActivity.this, ResultActivity.class);
        //Pasar parametros xd
        Bundle datos = new Bundle();
        if(bVictoria){

        }
        else{

        }
        nuevaActividad.putExtras(datos);
        startActivity(nuevaActividad);
    }
    //Funcion que devuelve un bool, true si el jugador gano(tiene todos los botones verdes), o false si no gano
    private boolean WinGame(){
        boolean bWin = true;
        int i = 0;
        int j;
        while( bWin && i<iCantButtonsX){
            j = 0;
            while(bWin && j<iCantButtonsY){
                if(!Buttons[i][j].getActivo()){
                    bWin= false;
                }
                else j++;
            }
            if(bWin) i++;
        }
        return bWin;
    }

    private View.OnClickListener btnBot_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };//Fin de la funcion onClickListener

    private View.OnClickListener btnRandom_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };//Fin de la funcion onClickListener

    private View.OnClickListener btnMenu_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            IniciarSegundaActividad(false);
        }
    };//Fin de la funcion onClickListener
}
