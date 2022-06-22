package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Mesas_Camarero extends AppCompatActivity {
    ImageButton btnMesa1;
    ImageButton btnMesa2;
    ImageButton btnMesa3;
    ImageButton btnMesa4;
    ImageButton btnMesa5;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas_camarero);
        ImageView imgLariosCamarero = findViewById(R.id.imgViewMesasCamarero);
        /* On click usado para que si el usuario clicka en la imagen del restaurante, vuelva atrás.*/
        imgLariosCamarero.setOnClickListener(v -> {
         Intent i = new Intent(Mesas_Camarero.this,menu_camarero.class);
         startActivity(i);
        });
        DB = new DBHelper(this);
        btnMesa1 = findViewById(R.id.imgBtnAdminMesa1);
        btnMesa2 = findViewById(R.id.imgBtnAdminMesa2);
        btnMesa3 = findViewById(R.id.imgBtnAdminMesa3);
        btnMesa4 = findViewById(R.id.imgBtnAdminMesa4);
        btnMesa5 = findViewById(R.id.imgBtnAdminMesa5);
        /* Botones que según el que sea clickado, retorne el nombre del camarero que está asignado en la mesa que le pasamos,
        * mirando el número de la mesa en la base de datos y mandando el nombre y el número de la mesa a la siguiente pantalla,
        * para posteriormente, cambiar el número de la mesa y el nombre del camarero.*/
        btnMesa1.setOnClickListener(v -> {
            int numMesa = 1;
            String nombreCamarero = getNombreCamarero(numMesa);
            Intent i = new Intent(Mesas_Camarero.this,mesas_info.class);
            i.putExtra("NumMesa",numMesa);
            i.putExtra("NombreCamarero",nombreCamarero);
            startActivity(i);
        });
        btnMesa2.setOnClickListener(v -> {
            int numMesa = 2;
            String nombreCamarero = getNombreCamarero(numMesa);
            Intent i = new Intent(Mesas_Camarero.this,mesas_info.class);
            i.putExtra("NumMesa",numMesa);
            i.putExtra("NombreCamarero",nombreCamarero);
            startActivity(i);
        });
        btnMesa3.setOnClickListener(v -> {
            int numMesa = 3;
            String nombreCamarero = getNombreCamarero(numMesa);
            Intent i = new Intent(Mesas_Camarero.this,mesas_info.class);
            i.putExtra("NumMesa",numMesa);
            i.putExtra("NombreCamarero",nombreCamarero);
            startActivity(i);
        });
        btnMesa4.setOnClickListener(v -> {
            int numMesa = 4;
            String nombreCamarero = getNombreCamarero(numMesa);
            Intent i = new Intent(Mesas_Camarero.this,mesas_info.class);
            i.putExtra("NumMesa",numMesa);
            i.putExtra("NombreCamarero",nombreCamarero);
            startActivity(i);
        });
        btnMesa5.setOnClickListener(v -> {
            int numMesa = 5;
            String nombreCamarero = getNombreCamarero(numMesa);
            Intent i = new Intent(Mesas_Camarero.this,mesas_info.class);
            i.putExtra("NumMesa",numMesa);
            i.putExtra("NombreCamarero",nombreCamarero);
            startActivity(i);
        });
    }
    /* Método para retornar el nombre del camarero realizando la consulta a la base de datos pasandole un número de mesa.*/
    public String getNombreCamarero(int numeroMesa){
        return DB.returnNombreCamarero(numeroMesa);
    }
}