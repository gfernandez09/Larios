package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TicketFinal extends AppCompatActivity {
    int nummesa;
    String platos;
    String PlatosPrecio;
    Double PrecioTotal;
    TextView ticketNumMesa;
    TextView ticketPlatos;
    TextView ticketPrecioPlatos;
    TextView ticketPrecioFinal;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_final);
        ticketNumMesa = findViewById(R.id.txtTicketFinalNumMesa);
        ticketPlatos = findViewById(R.id.txtTicketFinalPlatos);
        ticketPrecioPlatos = findViewById(R.id.txtTicketFinalPrecioPlatos);
        ticketPrecioFinal = findViewById(R.id.txtTicketFinalPrecioTotal);
        Bundle i = getIntent().getExtras();
        /*Intents para obtener los valores de las variables.*/
        nummesa = i.getInt("numMesa");
        platos = i.getString("platos");
        PlatosPrecio = i.getString("PrecioPlatos");
        PrecioTotal = i.getDouble("PrecioFinal");
        ticketNumMesa.setText("Numero de Mesa: " + nummesa);
        ticketPlatos.setText("Platos: " + platos);
        ticketPrecioPlatos.setText("Precio de los Platos: " + PlatosPrecio);
        ticketPrecioFinal.setText("PrecioTotal: " + PrecioTotal);
    }
    /*Método para regalar un plato al azar y actualizar el precio de los platos.*/
    @SuppressLint("SetTextI18n")
    public void regalarPlato(View view) {
        System.out.println(PlatosPrecio);
        String[] precios = PlatosPrecio.split(",");
        int rnd = new Random().nextInt(precios.length);
        precios[rnd] = String.valueOf(0.00);
        double suma = 0.00;
        for (String precio : precios) {
            suma += Double.parseDouble(precio);
        }
        ticketPrecioFinal.setText("Precio Total: " + suma);
        ticketPrecioPlatos.setText("Precio de los Platos: " + Arrays.toString(precios));
    }
    /*Método para realizar un cincuenta por ciento de descuento en todos los platos y actualizar el precio total.*/
    @SuppressLint("SetTextI18n")
    public void descuento(View view){
        String[] precios = PlatosPrecio.split(",");
        double valorDescontado;
        ArrayList<Double> arrayList = new ArrayList<>();
        for (String precio : precios) {
            double campo = Double.parseDouble(precio);
            valorDescontado = campo / 2;
            arrayList.add(valorDescontado);
        }
        ticketPrecioPlatos.setText("Precio de los Platos: " + arrayList + ",");
        double suma = 0.00;
        for (double sumas: arrayList){
            suma += sumas;
        }
        ticketPrecioFinal.setText("Precio Total: " + suma);
    }

    public void volverMenuAdmin(View view){
        Intent i = new Intent(this,menuAdmin.class);
        startActivity(i);
    }
}