package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    EditText nombreUsuarioEdit;
    EditText passwdEdit;
    EditText rolEdit;
    Button login;
    DBHelper DB;
    public static String UsuarioInicioSesion = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*Contexto que incia la base de datos.*/
        DB = new DBHelper(this);
    }

    public void loginUser(View view) {
        nombreUsuarioEdit = findViewById(R.id.username);
        login = findViewById(R.id.boton_login);
        passwdEdit = findViewById(R.id.password);
        rolEdit = findViewById(R.id.rol);
        String SnombreUsuarioEdit = nombreUsuarioEdit.getText().toString();
        String SpasswdEdit = passwdEdit.getText().toString();
        String SrolEdit = rolEdit.getText().toString();
        /*If que chequea si el usuario,la contraseña y el rol existen en la base de datos, dependiendo de si es camarero o administrador
        * inicie una pantalla u otra.*/
        if (SnombreUsuarioEdit.equals("") || SpasswdEdit.equals("")) {
            Toast.makeText(LoginActivity.this, "Porfavor, rellena todos los campos.", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkuserpass = DB.checkUserPasswordRol(SnombreUsuarioEdit, SpasswdEdit, SrolEdit);
            if (checkuserpass) {
                if(SrolEdit.equals("camarero")){
                    UsuarioInicioSesion = SnombreUsuarioEdit;
                    Intent i = new Intent(this,menu_camarero.class);
                    startActivity(i);
                    vaciarEdits();
                    Toast.makeText(LoginActivity.this, "Sesión Iniciada", Toast.LENGTH_SHORT).show();
                }else{
                    UsuarioInicioSesion = SnombreUsuarioEdit;
                    Intent i = new Intent(this,menuAdmin.class);
                    startActivity(i);
                    vaciarEdits();
                    Toast.makeText(LoginActivity.this, "Sesión Iniciada", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(LoginActivity.this, "No se ha podido iniciar sesión, intentelo de nuevo!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    /*Método que vacía los EditTexts.*/
    public void vaciarEdits(){
        nombreUsuarioEdit.setText("");
        rolEdit.setText("");
        passwdEdit.setText("");
    }
}