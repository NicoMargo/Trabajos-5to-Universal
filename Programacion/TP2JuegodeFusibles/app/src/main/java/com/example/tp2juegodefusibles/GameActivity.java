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
    }


    @Override
    public void onClick(View v) {
        if(WinGame()){
            IniciarSegundaActividad("ganeste");
        }
        else {
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
        }
    }//Fin de la funcion onClickListener

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
    private void IniciarSegundaActividad(String msg){
        Intent nuevaActividad = new Intent(GameActivity.this, ResultActivity.class);
        //Pasar parametros xd
        Bundle datos = new Bundle();
        nuevaActividad.putExtras(datos);
        startActivity(nuevaActividad);
    }

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

}
