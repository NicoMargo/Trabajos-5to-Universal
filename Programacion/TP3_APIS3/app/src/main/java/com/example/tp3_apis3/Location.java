package com.example.tp3_apis3;

public class Location {
    private String _nombre;
    private String _clase;

    public Location(String nombre, String clase){
        _nombre = nombre;
        _clase = clase;
    }

    public String getNombre(){
        return _nombre;
    }

    public String getClase(){
        return _clase;
    }
}
