package com.example.larios;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Pedido extends AppCompatActivity {
    ArrayAdapter adapter;
    static String camareroPropietarioMesa;
    DBHelper dbHelper;
    static ArrayList<PlatosyBebidas> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        ListView listViewPedidos = findViewById(R.id.listViewPedidos);
        dbHelper = new DBHelper(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listViewPedidos.setAdapter(adapter);
        TextView txtPedido = findViewById(R.id.txtPedido);
        /*Si el usuario se equivoca haciendo el pedido de un plato, si le clickamos lo borramos y actualizamos la lista.*/
        listViewPedidos.setOnItemClickListener((parent, view, position, id) -> {
            lista.remove(position);
            listViewPedidos.setAdapter(adapter);
        });
        txtPedido.setOnClickListener(this::volverMesas);
    }
    /*Métodos usados por los botones para cambiar de clase.*/
    public void cartaPedido(View view){
        Intent i = new Intent(this,carta.class);
        startActivity(i);
    }
    public void volverMesas(View view){
        Intent i = new Intent(this,Mesas_Camarero.class);
        startActivity(i);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void enviarCocina(View view){
        /*Recogemos la información de los pedidos, ya que únicamente en cocina mostraremos el nombre de todos los platos
        * y su mesa, también guardaremos los precios de los platos y calcularemos el precio total para usarlo en los tickets,
        * pero sin mostrarlo en cocina.*/
        ListView listViewPedidos = findViewById(R.id.listViewPedidos);
        ArrayAdapter<PlatosyBebidas> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        HashMap<String,String> hashPedidos = new HashMap<>();
        for (int i = 0; i < listViewPedidos.getChildCount(); i++) {
            hashPedidos.put(adapter.getItem(i).getNombre(),adapter.getItem(i).getId_Ingrediente());
        }
        StringBuilder preciosPlatosS = new StringBuilder();
        ArrayList<Double> preciosPlatos = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            preciosPlatosS.append(lista.get(i).getPrecio()).append(",");
            preciosPlatos.add(lista.get(i).getPrecio());
        }
        /*Si el camarero que ha iniciado sesion, es diferente al propietario de la mesa, le creará un mensaje para que al iniciar sesion
        * el camarero de la mesa, lo pueda ver.*/
        if(!camareroPropietarioMesa.equals(LoginActivity.UsuarioInicioSesion)){
            Boolean insertarMensaje = dbHelper.crearMensaje(LoginActivity.UsuarioInicioSesion,camareroPropietarioMesa,"Se ha añadido 1 pedido.");
            if(insertarMensaje){
                Toast.makeText(Pedido.this, "Se ha avisado al camarero propietario de la mesa.", Toast.LENGTH_SHORT).show();
            }
        }
        Intent i = new Intent(this,Cocina.class);
        startActivity(i);
        lista.clear();
        /*Bucle para obtener el precio total de los platos.*/
        Double PrecioTotal = 0.1;
        for (int j = 0; j < preciosPlatos.size(); j++) {
            PrecioTotal += preciosPlatos.get(j);
        }
        Set keys = hashPedidos.keySet();
        ArrayList<String> Pedidos = new ArrayList<>();
        /*Recogemos los nombres de los platos.*/
        for(Object key: keys){
            Pedidos.add((String) key);
        }
        /*Creamos el objeto de cocina para luego añadirlo a la lista de la clase de Cocina.*/
        CocinaClass cc = new CocinaClass();
        cc.setNumMesa(editarPlato.numeroMesaPlato);
        cc.setPrecioTotal(PrecioTotal);
        cc.setPlatos(Pedidos);
        cc.setPrecioPlatos(preciosPlatosS.toString());
        Cocina.listaPedidosCocina.add(cc);
    }
}