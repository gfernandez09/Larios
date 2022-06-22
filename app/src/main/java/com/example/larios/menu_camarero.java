package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class menu_camarero extends AppCompatActivity {
    static Boolean visualizarCarta = false;
    String getNombreCamarero;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_camarero);
        TextView nombreCamarero = findViewById(R.id.txtvSaludoCamarero);
        /* Variable que recibe los valores de la pantalla anterior para asignar el nombre del camarero a la actual.*/
        getNombreCamarero = LoginActivity.UsuarioInicioSesion;
        nombreCamarero.setText("Welcome Back, Mr " + getNombreCamarero + "!");
        ImageView imageView = findViewById(R.id.fotoCamarero);
        /*Según el camarero, pondremos una foto u otra.*/
        switch (getNombreCamarero) {
            case "Juanma":
                imageView.setImageResource(R.drawable.juanma);
                break;
            case "Estefania":
                imageView.setImageResource(R.drawable.estefania);
                break;
            case "Gustavo":
                imageView.setImageResource(R.drawable.gustavo);
                break;
        }
    }
    /* Métodos que son usados para los botones.*/
    public void salirMenuCamarero(View view){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }

    public void visualizarCarta(View view){
        Intent i = new Intent(this,carta.class);
        visualizarCarta = false;
        startActivity(i);
    }

    public void cambiarAMesasCamarero(View view){
        Intent i = new Intent(this,Mesas_Camarero.class);
        startActivity(i);
    }
}