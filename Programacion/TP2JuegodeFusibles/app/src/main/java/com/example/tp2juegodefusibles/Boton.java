package com.example.tp2juegodefusibles;

import android.widget.Button;

public class Boton{
    private Button btnButton;
    private boolean bActivo;
    public Boton (Button unBoton, boolean Activo){
        this.btnButton = unBoton;
        this.bActivo = Activo;
        if(Activo){
            this.btnButton.setBackgroundResource(R.drawable.fusible_verde);
        }
        else{
            this.btnButton.setBackgroundResource(R.drawable.fusible_rojo);
        }
    }

    public Button getButton(){
        return this.btnButton;
    }
    public boolean getActivo(){
        return this.bActivo;
    }
    public void changeActivo(){
        this.bActivo = !this.bActivo;
        if(this.bActivo){
            this.btnButton.setBackgroundResource(R.drawable.fusible_verde);
        }
        else{
            this.btnButton.setBackgroundResource(R.drawable.fusible_rojo);
        }
    }
    public void setActivo(boolean Activo){
        bActivo = Activo;
        if(Activo){
            this.btnButton.setBackgroundResource(R.drawable.fusible_verde);
        }
        else{
            this.btnButton.setBackgroundResource(R.drawable.fusible_rojo);
        }
    }

}
