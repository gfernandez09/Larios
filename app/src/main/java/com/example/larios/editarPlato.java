package com.example.larios;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class editarPlato extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    String nombrePlato;
    String categoriaPlato;
    Double precioPlato;
    Integer idPlato;
    String Ingredientes;
    Button btnEnviarPedido;
    static int numeroMesaPlato = 0;
    DBHelper db;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_plato);
        GridLayout gridLayout = findViewById(R.id.gridLayoutPlatos);
        btnEnviarPedido = findViewById(R.id.btnEnviarPedido);
        db = new DBHelper(this);
        /* Instanciamos los TextViews para almacenar valores. */
        TextView editnombrePlato = findViewById(R.id.txtNombrePlato);
        TextView editIdPlato = findViewById(R.id.txtIdPlato);
        TextView editPrecioPlato = findViewById(R.id.txtPrecio);
        TextView editIngredientes = findViewById(R.id.txtIngredientes);
        TextView editCategoria = findViewById(R.id.txtCategoria);

        /* Recogemos del intent los valores seleccionados por el Usuario.*/
        Bundle i = getIntent().getExtras();
        nombrePlato = i.getString("nombrePlato");
        precioPlato = i.getDouble("precioPlato");
        String precioPlatoS = String.valueOf(precioPlato);
        categoriaPlato = i.getString("categoriaPlato");
        idPlato = i.getInt("idPlato");
        String idPlatoS = String.valueOf(idPlato);
        Ingredientes = i.getString("Ingredientes");


        /* Seteamos los valores a los TextViews*/
        editnombrePlato.setText(nombrePlato);
        editIdPlato.setText("Id del Plato: " + idPlatoS);
        editPrecioPlato.setText("Precio: " + precioPlatoS);
        editIngredientes.setText(Ingredientes);
        editCategoria.setText("Categoria: " + categoriaPlato);

        ArrayList<String> nombresCheckBox = new ArrayList<>();
        nombresCheckBox.add("Verduras");
        nombresCheckBox.add("Aceitunas");
        nombresCheckBox.add("Harina");
        nombresCheckBox.add("Lacteos");
        nombresCheckBox.add("Carne");
        nombresCheckBox.add("Pescado");
        nombresCheckBox.add("Marisco");
        nombresCheckBox.add("Arroz");
        nombresCheckBox.add("Pasta");
        nombresCheckBox.add("Azucar");
        nombresCheckBox.add("Chocolate");
        nombresCheckBox.add("Huevos");
        nombresCheckBox.add("FrutosSecos");

        /* Hacemos Split al TextView de Ingredientes para recoger cada valor individual
        * y meterlo en un array, para después proceder marcar su checkbox.*/
        String[] values = Ingredientes.split(",");
        List<String> al = new ArrayList<>(Arrays.asList(values));
        if(!Ingredientes.isEmpty()){
            /* Instanciamos los CheckBoxs */
            for (int j = 0; j < nombresCheckBox.size(); j++) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(nombresCheckBox.get(j));
                gridLayout.addView(checkBox);
            }
            /*Bucle para marcar y poder desmarcar los CheckBoxs según los ingredientes que tengan.*/
            for (int a = 0; a < gridLayout.getChildCount(); a++) {
                View v = gridLayout.getChildAt(a);
                if (v instanceof CheckBox) {
                    if(al.contains(((CheckBox) v).getText().toString())){
                        ((CheckBox) v).setChecked(true);
                        al.remove(((CheckBox) v).getText().toString());
                    }
                    ((CheckBox)v).setOnCheckedChangeListener (this);
                }
            }
        }
        /*Al clickar el botón, ejecutaremos el siguiente método.*/
        btnEnviarPedido.setOnClickListener(this::EnviarPedido);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        TextView editIngredientes = findViewById(R.id.txtIngredientes);
        String valoresDefecto = editIngredientes.getText().toString();
        String[] values = valoresDefecto.split(",");
        List<String> al = new ArrayList<>(Arrays.asList(values));
        /*Si está checkeado y el arraylist no está vacio, insertaremos primero una coma y luego el text del checkbox clickado.*/
        if (isChecked) {
            if(!al.isEmpty()) {
                    valoresDefecto += ","+ buttonView.getText().toString();
                    editIngredientes.setText(valoresDefecto);
            }
        }else{
            /*Borraremos el texto del botón del array y actualizaremos el textView.*/
            al.remove(buttonView.getText().toString());
            String citiesCommaSeparated = String.join(",", al);
            editIngredientes.setText(citiesCommaSeparated);
        }
    }

    public void EnviarPedido(View view){
        TextView editIngredientes = findViewById(R.id.txtIngredientes);
        Intent i = new Intent(this,Pedido.class);
        /*Creamos el objeto de platos y bebidas con su informacion y lo asignamos a la lista de la siguiente clase.*/
        PlatosyBebidas pb = new PlatosyBebidas();
        pb.setId(idPlato);
        pb.setNombre(nombrePlato);
        pb.setPrecio(precioPlato);
        pb.setId_Categoria(categoriaPlato);
        pb.setId_Ingrediente(editIngredientes.getText().toString());
        Pedido.lista.add(pb);
        menu_camarero.visualizarCarta = true;
        startActivity(i);
    }
}