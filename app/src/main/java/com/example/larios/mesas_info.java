package com.example.larios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class mesas_info extends AppCompatActivity {
    ImageView imgView;
    Integer getnumMesa;
    String getNombreCamarero;
    DBHelper dbHelper;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas_info);
        imgView = findViewById(R.id.imgVMesaVolver);
        TextView tvNumMesa = findViewById(R.id.txtNumMesa);
        TextView tvNombreCamarero = findViewById(R.id.txtNombreCamareroMesa);
        TextView tvNumPers = findViewById(R.id.txtNumeroPersonas);
        dbHelper = new DBHelper(this);
        /* Variables para modificar los TextViews con el Nombre del Camarero y el Número de la mesa.*/
        Bundle i = getIntent().getExtras();
        getNombreCamarero = i.getString("NombreCamarero");
        getnumMesa = i.getInt("NumMesa");
        tvNumMesa.setText("Mesa Número: "+getnumMesa);
        tvNombreCamarero.setText("Camarero: " + getNombreCamarero);
        ArrayList<Mensaje> checkMensaje = dbHelper.getMensaje(getNombreCamarero);
        /*Checkeamos si tenemos algun mensaje y el camarero de la mesa es el que ha iniciado sesión. Después,
        * mostraremos un alert con el mensaje.*/
        if(!checkMensaje.isEmpty() && getNombreCamarero.equals(LoginActivity.UsuarioInicioSesion)){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("El Camarero " + checkMensaje.get(0).getEmisor() + " te ha añadido un plato.");
            alert.setTitle("Mensaje de otro camarero.");
            alert.setCancelable(true);
            alert.show();
            dbHelper.deleteMensaje(getNombreCamarero);
        }
        /*Si en la mesa no hay camarero, asignaremos al camarero que ha iniciado sesión y ha entrado en la mesa,
        * con unas personas aleatorias para que pueda realizar pedidos.*/
        if(getNombreCamarero.equals("No hay camarero")){
            int numeroAleatorio = (int) (Math.random() * 5 + 1);
            String aleatorioString = Integer.toString(numeroAleatorio);
            Boolean insertarCamareroMesa = dbHelper.insertMesas(String.valueOf(getnumMesa),aleatorioString,LoginActivity.UsuarioInicioSesion);
            Pedido.camareroPropietarioMesa = LoginActivity.UsuarioInicioSesion;
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("La mesa se encontraba vacía, asignandote a la mesa para atender.");
            builder1.setTitle("Insertando Camarero");
            builder1.setCancelable(true);
            builder1.show();
            if(insertarCamareroMesa){
                getNombreCamarero = LoginActivity.UsuarioInicioSesion;
                Toast.makeText(mesas_info.this,"Insertando camarero a la mesa.", Toast.LENGTH_SHORT).show();
                tvNombreCamarero.setText("Camarero: " + LoginActivity.UsuarioInicioSesion);
            }
        }
        /*Al entrar a una mesa que no es la suya(Camarero que haya iniciado sesión) mostraremos un alert
        * de quien es el camarero de la mesa*/
        if(!LoginActivity.UsuarioInicioSesion.equals(getNombreCamarero)){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Camarero actual de la mesa: " + getNombreCamarero);
            builder1.setTitle("Detector Camarero");
            builder1.setCancelable(true);
            builder1.show();
        }
        String numPersonas = dbHelper.returnNumPersonas(getnumMesa);
        tvNumPers.setText("Numero de Comensales: "+numPersonas);
    }
    /*Métodos usados por los botones.*/
    public void volverMenuCamarero(View view){
        Intent i = new Intent(this,menu_camarero.class);
        startActivity(i);
    }

    public void mirarCartaMesa(View view){
        Intent i = new Intent(this,carta.class);
        Pedido.camareroPropietarioMesa = getNombreCamarero;
        menu_camarero.visualizarCarta = true;
        editarPlato.numeroMesaPlato = getnumMesa;
        startActivity(i);
    }
}