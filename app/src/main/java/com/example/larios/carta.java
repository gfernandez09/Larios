package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import java.util.ArrayList;

public class carta extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    static ListView listViewCarta;
    TextView txtCarta;
    DBHelper db;
    ImageButton btnEntrantes;
    ImageButton btnPrincipales;
    ImageButton btnPostre;
    ImageButton btnBebidas;
    SearchView searchView;
    ArrayAdapter adapter;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);
        /*Contexto para que se pueda usar la base de datos de SQLITE*/
        db = new DBHelper(this);
        /* Recogemos el ID del ListView para luego rellenarlo mediante el método de la base de datos,
        * que recoge los platos y bebidas de la base de datos. */
        listViewCarta = findViewById(R.id.listViewCarta);
        clickar();
        /* Finds para asignarlos a las variables para posterior uso*/
        txtCarta = findViewById(R.id.textViewCarta);
        btnEntrantes = findViewById(R.id.btnEntrante);
        btnPrincipales = findViewById(R.id.btnPrincipales);
        btnPostre = findViewById(R.id.btnPostre);
        btnBebidas = findViewById(R.id.btnBebidas);
        searchView = findViewById(R.id.searchViewCarta);

        /*Buscador para buscar los platos o bebidas.*/
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        /*Clickers de los botones para que o bien, listen los platos o filtren por categorias. */
        txtCarta.setOnClickListener(v -> listarDatos());

        btnEntrantes.setOnClickListener(v -> {
            String entrantes = "Entrante";
            checkTiposCategoria(entrantes);
        });
        btnPrincipales.setOnClickListener(v -> {
            String Principales = "Principales";
            checkTiposCategoria(Principales);
        });
        btnPostre.setOnClickListener(v -> {
            String Postre = "Postre";
            checkTiposCategoria(Postre);
        });
        btnBebidas.setOnClickListener(v -> {
            String Bebida = "Bebidas";
            checkTiposCategoria(Bebida);
        });
    }

    public void clickar(){
        listViewCarta = findViewById(R.id.listViewCarta);
        ArrayList<PlatosyBebidas> lista = db.checkPlatosyBebidas();
        /*Si la lista contiene datos de la base de datos, rellenamos el listview de la clase con los platos y su informacion.*/
        if(!lista.isEmpty()){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            listViewCarta.setAdapter(adapter);
        }
        if(menu_camarero.visualizarCarta){
            /*Si venimos desde las mesas, nos dejará clickar los platos en la carta, si no, solo será visible(Estamos en visualizar
            * carta en el menu de camarero).*/
            listViewCarta.setOnItemClickListener((parent, view, position, id) -> {
                /*Recogemos la información del plato clickado del ListView y la enviamos a otra Activity para editar los ingredientes.*/
                int posicion = position;
                int idPlato = lista.get(posicion).getId();
                String categoriaPlato = lista.get(posicion).getId_Categoria();
                String nombrePlato = lista.get(posicion).getNombre();
                Double precioPlato = lista.get(posicion).getPrecio();
                String Ingredientes = lista.get(posicion).getId_Ingrediente();
                i = new Intent(carta.this,editarPlato.class);
                i.putExtra("idPlato",idPlato);
                i.putExtra("categoriaPlato",categoriaPlato);
                i.putExtra("nombrePlato",nombrePlato);
                i.putExtra("precioPlato",precioPlato);
                i.putExtra("Ingredientes",Ingredientes);
                startActivity(i);
                menu_camarero.visualizarCarta = false;
            });
        }
    }
    /* Método usado para mostrar todos los platos y bebidas de la base de datos*/
    public void listarDatos(){
        listViewCarta = findViewById(R.id.listViewCarta);
        ArrayList<PlatosyBebidas> lista = db.checkPlatosyBebidas();
        if(!lista.isEmpty()){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            listViewCarta.setAdapter(adapter);
        }
        if(menu_camarero.visualizarCarta){
            listViewCarta.setOnItemClickListener((parent, view, position, id) -> {
                int posicion = position;
                int idPlato = lista.get(posicion).getId();
                String categoriaPlato = lista.get(posicion).getId_Categoria();
                String nombrePlato = lista.get(posicion).getNombre();
                Double precioPlato = lista.get(posicion).getPrecio();
                String Ingredientes = lista.get(posicion).getId_Ingrediente();
                i = new Intent(carta.this,editarPlato.class);
                i.putExtra("idPlato",idPlato);
                i.putExtra("categoriaPlato",categoriaPlato);
                i.putExtra("nombrePlato",nombrePlato);
                i.putExtra("precioPlato",precioPlato);
                i.putExtra("Ingredientes",Ingredientes);
                startActivity(i);
                menu_camarero.visualizarCarta = false;
            });
        }
    }
    /* Método usado para mostrar todos los platos y bebidas filtrados por categorias de la base de datos*/
    public void checkTiposCategoria(String categoria){
        listViewCarta = findViewById(R.id.listViewCarta);
        ArrayList<PlatosyBebidas> lista = db.checkCategorias(categoria);
        if(!lista.isEmpty()){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            listViewCarta.setAdapter(adapter);
        }
        if(menu_camarero.visualizarCarta){
            listViewCarta.setOnItemClickListener((parent, view, position, id) -> {
                int posicion = position;
                int idPlato = lista.get(posicion).getId();
                String categoriaPlato = lista.get(posicion).getId_Categoria();
                String nombrePlato = lista.get(posicion).getNombre();
                Double precioPlato = lista.get(posicion).getPrecio();
                String Ingredientes = lista.get(posicion).getId_Ingrediente();
                i = new Intent(carta.this,editarPlato.class);
                i.putExtra("idPlato",idPlato);
                i.putExtra("categoriaPlato",categoriaPlato);
                i.putExtra("nombrePlato",nombrePlato);
                i.putExtra("precioPlato",precioPlato);
                i.putExtra("Ingredientes",Ingredientes);
                startActivity(i);
                menu_camarero.visualizarCarta = false;
            });
        }

    }
}