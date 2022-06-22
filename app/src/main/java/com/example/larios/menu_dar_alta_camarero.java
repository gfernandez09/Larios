package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class menu_dar_alta_camarero extends AppCompatActivity {

    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dar_alta_camarero);
        DB = new DBHelper(this);
        TextView tvDarAltaCamarero = findViewById(R.id.textDarAltaCamarero);
        /* On Click para que cuando el usuario clique en el textView Dar Alta Camarero, pueda volver atrás al menú.*/
        tvDarAltaCamarero.setOnClickListener(this::volverDarAltaCamarero);
    }
    /* Método para dar de alta a un camarero que si detecta que el usuario, ya existe en la base de datos, no se puede dar de alta y
    * necesita otro nombre para posteriormente, realizar su registro en la base de datos.*/
    public void darAltaCamarero(View view){
        EditText username = findViewById(R.id.registrarCamareroNombre);
        EditText password = findViewById(R.id.registrarCamareroPass);
        String sUsernameRegistroCamarero = username.getText().toString();
        String sPasswordRegistroCamarero = password.getText().toString();
        String rol = "camarero";

        if(sUsernameRegistroCamarero.equals("") || sPasswordRegistroCamarero.equals("")){
            Toast.makeText(menu_dar_alta_camarero.this, "Porfavor, rellena todos los campos.", Toast.LENGTH_SHORT).show();
        }else{
            Boolean checkuser = DB.checkUser(sUsernameRegistroCamarero);
            if(!checkuser){
                Boolean insert = DB.insert(sUsernameRegistroCamarero,sPasswordRegistroCamarero,rol);
                if(insert){
                    Toast.makeText(menu_dar_alta_camarero.this, "Registro Realizado Correctamente", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(menu_dar_alta_camarero.this, "El Camarero ya existe.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void volverDarAltaCamarero(View view){
        Intent i = new Intent(this,menuAdmin.class);
        startActivity(i);
    }
}