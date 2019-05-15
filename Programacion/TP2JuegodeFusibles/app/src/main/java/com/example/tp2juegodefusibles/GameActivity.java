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
import android.widget.ToggleButton;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Random;
import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.ConsoleHandler;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PARAMETERVICTORY = "com.example.tp2juegodefusibles.GameActivity.bVictoria";
    public static final String PARAMETERHISTORIAL = "com.example.tp2juegodefusibles.GameActivity.HistoryMoves";
    public static final String PARAMETERSCREEN = "com.example.tp2juegodefusibles.GameActivity.LastScreen";
    private static Timer timer = new Timer();
    private static int iMilisecs = 0;
    public boolean bAutoModeOn = false;
    private Boton Buttons[][];
    private int iCantMoves = 0;
    public int getCantMoves(){
        return iCantMoves;
    }
    private static final int iCantButtonsX = 3;
    private static final int iCantButtonsY = 3;
    private Button btnBot;
    private Button btnRandom;
    private Button btnMenu;
    private ArrayList<Integer> HistoryMoves = new ArrayList<Integer>();
    private ArrayList<Integer> LastScreen = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent elIntent = getIntent();
        Bundle datos = elIntent.getExtras();
        String Paremeter1 = datos.getString (MainActivity.PAREMETER1);

        Buttons = new Boton[iCantButtonsX][iCantButtonsY];

        Log.d("xd","xd");
        GetReferences();
        SetListeners();

    }

    //Funcion que obtiene las referencias de los elementos del design
    private void GetReferences(){
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

    private void SetListeners() {
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

    }//Fin de funcionSetListeners

    @Override
    public void onClick(View v) {
        if(bAutoModeOn){
            bAutoModeOn = false;
            btnBot.setText("Auto On");
        }
        int iButtonPos = SearchButtonPos(v.getId());
        ToggleButton(iButtonPos);
    }//Fin de la funcion onClickListener

    public void ToggleButton(int iButtonPos){//Funcion que se llama cuando se hace la accion de interactuar con un boton
        HistoryMoves.add(iButtonPos);
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
            if(bAutoModeOn){
                bAutoModeOn = false;
                btnBot.setText("Auto On");
            }
            IniciarSegundaActividad(true);
        }
    }//Fin de funcion ToggleButton

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
    }//Fin de funcion SearchButtonPos

    //Fucion una mandar a una nueva activity
    private void IniciarSegundaActividad(boolean bVictory){
        Intent nuevaActividad = new Intent(GameActivity.this, ResultActivity.class);

        for(int i = 0; i<iCantButtonsX;i++){
            for(int j = 0; j<iCantButtonsY;j++){
                if(Buttons[i][j].getActivo()) {
                    LastScreen.add(1);
                }
                else{
                    LastScreen.add(0);
                }
            }
        }
        //Pasar parametros xd
        Bundle datos = new Bundle();

        datos.putIntegerArrayList(PARAMETERHISTORIAL, HistoryMoves);
        datos.putBoolean(PARAMETERVICTORY,bVictory);
        datos.putIntegerArrayList(PARAMETERSCREEN,LastScreen);

        nuevaActividad.putExtras(datos);
        startActivity(nuevaActividad);
    }//Fin de Funcon IniciarSegundaActividad

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
    }//Fin de funcion WinGame

    private View.OnClickListener btnBot_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!bAutoModeOn) {
                MyTimer();
                bAutoModeOn = true;
                btnBot.setText("Auto Off");
            }
            else{
                bAutoModeOn = false;
                btnBot.setText("Auto On");
            }
        }
    };//Fin de la funcion onClickListener de btnBOt

    public void MyTimer() {

        TimerTask task;

        task = new TimerTask() {
            @Override
            public void run() {
                if(bAutoModeOn) {
                    Random GeneradorRandom = new Random();
                    ToggleButton(GeneradorRandom.nextInt(iCantButtonsX * iCantButtonsY));
                }
                else {
                    // stop the timer
                    cancel();
                }
            }

        };
        timer.schedule(task, 0,500);
    }

    private View.OnClickListener btnRandom_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(bAutoModeOn){
                bAutoModeOn = false;
                btnBot.setText("Auto On");
            }
            for(int i = 0; i<iCantButtonsX; i++){
                for(int j = 0; j<iCantButtonsY; j++){
                    Buttons[i][j].setActivo(false);
                }
            }
            Random GeneradorRandom = new Random();
            Buttons[GeneradorRandom.nextInt(iCantButtonsX-0)][GeneradorRandom.nextInt(iCantButtonsY-0)].setActivo(true);
            HistoryMoves.clear();
        }
    };//Fin de la funcion onClickListener de btnRandom

    private View.OnClickListener btnMenu_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(bAutoModeOn){
                bAutoModeOn = false;
                btnBot.setText("Auto On");
            }
            IniciarSegundaActividad(false);
        }
    };//Fin de la funcion onClickListener de BtnMenu
}
