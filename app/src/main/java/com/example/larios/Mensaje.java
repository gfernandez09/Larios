package com.example.larios;

import androidx.annotation.NonNull;

public class Mensaje {
    String emisor;
    String receptor;
    String mensaje;

    public Mensaje(String emisor, String receptor, String mensaje) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
    }

    public Mensaje(){

    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @NonNull
    @Override
    public String toString() {
        return "Mensaje{" + "emisor='" + emisor + '\'' + ", receptor='" + receptor + '\'' + ", mensaje='" + mensaje + '\'' + '}';
    }
}
