package com.example.larios;

import java.util.ArrayList;

public class CocinaClass {
    int NumMesa;
    ArrayList<String> Platos;
    String precioPlatos;
    Double PrecioTotal;

    public CocinaClass(int numMesa, ArrayList<String> platos, String precioPlatos, Double precioTotal) {
        NumMesa = numMesa;
        Platos = platos;
        this.precioPlatos = precioPlatos;
        PrecioTotal = precioTotal;
    }

    public CocinaClass(){

    }

    public int getNumMesa() {
        return NumMesa;
    }

    public void setNumMesa(int numMesa) {
        NumMesa = numMesa;
    }

    public ArrayList<String> getPlatos() {
        return Platos;
    }

    public void setPlatos(ArrayList<String> platos) {
        Platos = platos;
    }

    public String getPrecioPlatos() {
        return precioPlatos;
    }

    public void setPrecioPlatos(String precioPlatos) {
        this.precioPlatos = precioPlatos;
    }

    public Double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        PrecioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Numero de Mesa: " + NumMesa +"\n" +"Platos: " + Platos;
    }
}
