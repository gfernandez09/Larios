package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;

public class reasignar_camarero extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasignar_camarero);
        DB = new DBHelper(this);
        TextView tvReasignarCamarero = findViewById(R.id.textReasignarCamarero);
        /* Si el TextView de la pantalla es clickado, vuelve a la pantalla anterior.*/
        tvReasignarCamarero.setOnClickListener(this::volverMenuReasignarCamarero);
    }

    public void volverMenuReasignarCamarero(View view){
        Intent i = new Intent(this,menuAdmin.class);
        startActivity(i);
    }
    /* Método que lo usamos para reasignar el camarero a una mesa si hay un camarero ya asignado, y si está vacía,
    * lo asignamos diciendole al usuario que dicha mesa estaba vacía.*/
    public void reasignarCamarero(View view) {
        EditText numMesa = findViewById(R.id.reasignar_camarero_mesa_destino);
        EditText nombreCamarero = findViewById(R.id.reasignar_camarero_Nombre);
        String SnumMesa = numMesa.getText().toString();
        String SnombreCamarero = nombreCamarero.getText().toString();

        if(SnumMesa.equals("") || SnombreCamarero.equals("")){
            Toast.makeText(reasignar_camarero.this, "Porfavor, rellena todos los campos.", Toast.LENGTH_SHORT).show();
        }else{
            int numeroAleatorio = (int) (Math.random() * 5 + 1);
            String aleatorioString = Integer.toString(numeroAleatorio);
            Boolean insertarCamareroMesa = DB.insertMesas(SnumMesa,aleatorioString,SnombreCamarero);
            if(insertarCamareroMesa){
                Toast.makeText(reasignar_camarero.this, "La mesa número " + SnumMesa + "se encontraba vacía y se le ha asignado el camarero " + SnombreCamarero, Toast.LENGTH_SHORT).show();
            }else{
                Boolean reasignarCamareroBoolean = DB.cambiarCamarero(SnombreCamarero,SnumMesa);
                if (reasignarCamareroBoolean){
                    Toast.makeText(reasignar_camarero.this, "Camarero reasignado con éxito", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(reasignar_camarero.this, "No se ha podido reasignar el camarero.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}