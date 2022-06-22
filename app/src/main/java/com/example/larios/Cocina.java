package com.example.larios;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Cocina extends AppCompatActivity {
    DBHelper dbHelper;
    ArrayAdapter<CocinaClass> adapter;
    static ArrayList<CocinaClass> listaPedidosCocina = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);
        ListView listCocina = findViewById(R.id.listCocina);
        TextView labelCocina = findViewById(R.id.labelCocina);
        labelCocina.setOnClickListener(this::volver);
        dbHelper = new DBHelper(this);
        /*Generamos la lista en el ListView con el Adaptador.*/
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPedidosCocina);
        listCocina.setAdapter(adapter);

        listCocina.setOnItemClickListener((parent, view, position, id) -> {
            /*Al pedido en cocina clickado, le generamos su ticket y lo borramos de la lista.*/
            int numMesa = listaPedidosCocina.get(position).getNumMesa();
            String nombrePlatos = listaPedidosCocina.get(position).getPlatos().toString();
            String precioPlatos = listaPedidosCocina.get(position).getPrecioPlatos();
            double PrecioPlato = listaPedidosCocina.get(position).getPrecioTotal();
            dbHelper.insertTicket(numMesa,nombrePlatos,precioPlatos,PrecioPlato);
            Toast.makeText(Cocina.this, "Ticket Creado", Toast.LENGTH_SHORT).show();
            listaPedidosCocina.remove(position);
            listCocina.setAdapter(adapter);
        });
    }

    public void volver(View view){
        Intent i = new Intent(this,Mesas_Camarero.class);
        startActivity(i);
    }
}