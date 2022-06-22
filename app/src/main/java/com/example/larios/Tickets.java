package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class Tickets extends AppCompatActivity {
    DBHelper dbHelper;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        ListView Tickets = findViewById(R.id.listViewTickets);
        dbHelper = new DBHelper(this);
        ArrayList<Ticket> listaTickets = dbHelper.getTicket();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTickets);
        Tickets.setAdapter(adapter);
        Tickets.setOnItemClickListener((parent, view, position, id) -> {
            /*Al clickar en un ticket, obtendremos su información para luego ir a la siguiente clase y editarlo.*/
            Intent i = new Intent(Tickets.this,TicketFinal.class);
            int NumMesa = listaTickets.get(position).getNumMesa();
            String Platos = listaTickets.get(position).getPlatos();
            String PrecioPlatos = listaTickets.get(position).getPrecios();
            Double PrecioFinal = listaTickets.get(position).getPrecioTotal();
            i.putExtra("numMesa",NumMesa);
            i.putExtra("platos",Platos);
            i.putExtra("PrecioPlatos",PrecioPlatos);
            i.putExtra("PrecioFinal",PrecioFinal);
            startActivity(i);
        });
    }
}