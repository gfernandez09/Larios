package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.os.*;
import android.view.*;

public class menuAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }
    /* Métodos usados en los botones para cambiar de pantallas.*/
    public void botonDarAltaNuevoCamarero(View view){
        Intent buttonNewCamarero = new Intent(this,menu_dar_alta_camarero.class);
        startActivity(buttonNewCamarero);
    }

    public void botonReasignarCamarero(View view){
        Intent intentReasignarCamarero = new Intent(this,reasignar_camarero.class);
        startActivity(intentReasignarCamarero);
    }

    public void mesasAdmin(View view){
        Intent mesasAdmin = new Intent(this,Mesas_Camarero.class);
        startActivity(mesasAdmin);
    }

    public void editarComandas(View view){
        Intent i = new Intent(this,Tickets.class);
        startActivity(i);
    }
    public void SalirMenuAdmin(View view){
        Intent salirAdm = new Intent(this,LoginActivity.class);
        startActivity(salirAdm);
    }

}