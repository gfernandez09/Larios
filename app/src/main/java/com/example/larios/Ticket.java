package com.example.larios;

import android.os.Parcelable;

import java.util.ArrayList;

public class Ticket extends ArrayList<Parcelable> {
    int NumMesa;
    String Platos;
    String Precios;
    Double PrecioTotal;

    public Ticket(int numMesa, String platos, String precios, Double precioTotal) {
        NumMesa = numMesa;
        Platos = platos;
        Precios = precios;
        PrecioTotal = precioTotal;
    }

    public Ticket(){

    }

    public int getNumMesa() {
        return NumMesa;
    }

    public void setNumMesa(int numMesa) {
        NumMesa = numMesa;
    }

    public String getPlatos() {
        return Platos;
    }

    public void setPlatos(String platos) {
        Platos = platos;
    }

    public String getPrecios() {
        return Precios;
    }

    public void setPrecios(String precios) {
        Precios = precios;
    }

    public Double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        PrecioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Numero de Mesa: " + NumMesa + "\n" + "Platos: " + Platos + "\n" + "Precios: " + Precios + "\n"
                + "PrecioTotal: " + PrecioTotal;
    }
}
