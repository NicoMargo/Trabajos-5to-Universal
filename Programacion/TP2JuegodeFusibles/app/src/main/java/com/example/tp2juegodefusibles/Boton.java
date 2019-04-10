package com.example.tp2juegodefusibles;

import android.widget.Button;

public class Boton{
    private Button Boton;
    private boolean bActivo;
    public Boton (Button unBoton, boolean Activo){
        this.Boton = unBoton;
        this.bActivo = Activo;
    }
    public Button getBoton(){
        return this.Boton;
    }
    public boolean getActivo(){
        return this.bActivo;
    }
    public void setActivo(){
        this.bActivo = !this.bActivo;
    }
}
