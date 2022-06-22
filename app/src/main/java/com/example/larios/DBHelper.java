package com.example.larios;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "larios.db";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 56);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Usuarios(nUsuario TEXT primary key, password TEXT, rol TEXT)");
        db.execSQL("CREATE TABLE Mesas(numMesa TEXT primary key, numPersonas TEXT, nombreCamarero TEXT)");
        db.execSQL("CREATE TABLE PlatosyBebidas(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Id_Categoria TEXT, Tipo TEXT,Precio DOUBLE,Id_Ingrediente TEXT)");
        db.execSQL("CREATE TABLE Mensajes(Emisor TEXT,Receptor TEXT,Mensaje TEXT,FechaMensaje DATETIME)");
        db.execSQL("CREATE TABLE Ticket(numMesa TEXT, Platos TEXT, Precios TEXT,PrecioTotal DOUBLE)");
        db.execSQL("INSERT INTO Usuarios(nUsuario,password,rol) VALUES ('Admin','12345','Admin')");
        db.execSQL("INSERT INTO Usuarios(nUsuario,password,rol) VALUES ('Gustavo','12345','camarero')");
        db.execSQL("INSERT INTO Usuarios(nUsuario,password,rol) VALUES ('Juanma','12345','camarero')");
        db.execSQL("INSERT INTO Usuarios(nUsuario,password,rol) VALUES ('Estefania','12345','camarero')");
        db.execSQL("INSERT INTO Mesas(numMesa,numPersonas,nombreCamarero) VALUES ('1','5','Gustavo')");
        db.execSQL("INSERT INTO Mesas(numMesa,numPersonas,nombreCamarero) VALUES ('2','3','Juanma')");
        db.execSQL("INSERT INTO Mesas(numMesa,numPersonas,nombreCamarero) VALUES ('5','2','Estefania')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Ensalada Verde','Entrante','Entrante',6.5,'Verduras,Aceitunas,Harina,Lacteos')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Croquetas Variadas','Entrante','Entrante',9,'Harina,Pescado,Marisco,Arroz,Carne')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Tabla de Embutidos','Entrante','Entrante',12,'Marisco,Pescado')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Paella de Marisco','Principales','Arroces',14.5,'Huevos,Arroz')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Paella de Verduras','Principales','Arroces',12.5,'Arroz,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Paella Mixta','Principales','Arroces',13,'Arroz,Pescado,Marisco,Carne,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Paella Valenciana','Principales','Arroces',13,'Arroz,Carne,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Fideua','Principales','Arroces',13,'Huevos,Arroz')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Arroz Negro','Principales','Arroces',13.5,'Huevos,Arroz')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Arroz de Bogavante','Principales','Arroces',18,'Huevos,Arroz')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Solomillo a la Brasa','Principales','Carnes',24,'Carne,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Chuletón a la Brasa','Principales','Carnes',50,'Carne,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Entrecot a la Brasa','Principales','Carnes',18,'Carne,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Dorada a la sal','Principales','Pescado y Marisco',22,'Pescado,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Lubina a la espalda','Principales','Pescado y Marisco',22,'Pescado,Verduras')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Bacalao con constra de allioli','Principales','Pescado y Marisco',24,'Pescado,Verduras,FrutosSecos')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Parrillada de pescado','Principales','Pescado y Marisco',40,'Pescado,Marisco')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Coulant','Postre','Postre',4.5,'Lacteos,Chocolate,Huevos,FrutosSecos,Harina')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Tarta de queso','Postre','Postre',4.5,'Lacteos,Harina,Chocolate,FrutosSecos')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Brownie con helado','Postre','Postre',4.5,'Lacteos,Chocolate,Huevos,FrutosSecos,Harina')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Agua','Bebidas','Bebidas',2.5,'')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Refresco','Bebidas','Bebidas',3,'')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Cerveza','Bebidas','Bebidas',2.5,'')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Café','Bebidas','Bebidas',1.5,'')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Té','Bebidas','Bebidas',1.5,'')");
        db.execSQL("INSERT INTO PlatosyBebidas(Nombre,Id_Categoria,Tipo,Precio,Id_Ingrediente) VALUES ('Cortado','Bebidas','Bebidas',1.5,'')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS Mesas");
        db.execSQL("DROP TABLE IF EXISTS PlatosyBebidas");
        db.execSQL("DROP TABLE IF EXISTS Mensajes");
        db.execSQL("DROP TABLE IF EXISTS Ticket");
        onCreate(db);
    }
    /*Método que mira si el usuario que le pasamos por parámetro existe.*/
    public Boolean checkUser(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("SELECT * FROM Usuarios WHERE nUsuario = ?", new String[] {username});
        return cursor.getCount() > 0;
    }
    /*Método que mira si el usuario, la contraseña y el rol, existen*/
    public Boolean checkUserPasswordRol(String username, String password, String rol) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("SELECT * FROM Usuarios WHERE nUsuario = ? and password = ? and rol = ?", new String[] {username,password,rol});
        return cursor.getCount() > 0;
    }
    /* Método que devuelve el nombre del camarero según la mesa que le pasemos.*/
    public String returnNombreCamarero(int numMesa){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM Mesas WHERE numMesa = " + numMesa,null);
        if(cursor.moveToFirst()){
            String getNombreCamarero = cursor.getString(2);
            cursor.close();
            MyDB.close();
            if(getNombreCamarero != null){
                return getNombreCamarero;
            }else{
                return null;
            }
        }
        return "No hay camarero";
    }
    /*Metodo para devolver el numero de Personas en una Mesa.*/
    public String returnNumPersonas(int numMesa){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM Mesas WHERE numMesa = " + numMesa,null);
        if(cursor.moveToFirst()){
            String getNumPersonas = cursor.getString(1);
            cursor.close();
            MyDB.close();
            return getNumPersonas;
        }
        return "Cero Personas";
    }
    /*Método que devuelve un arraylist rellenado con los platos y bebidas de la base de datos.*/
    public ArrayList<PlatosyBebidas> checkPlatosyBebidas(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("SELECT * FROM PlatosyBebidas",null);
        ArrayList<PlatosyBebidas> lista = new ArrayList<>();
        while(cursor.moveToNext()){
            PlatosyBebidas pb = new PlatosyBebidas();
            pb.setId(cursor.getInt(0));
            pb.setNombre(cursor.getString(1));
            pb.setId_Categoria(cursor.getString(2));
            pb.setPrecio(cursor.getDouble(4));
            pb.setId_Ingrediente(cursor.getString(5));
            lista.add(pb);
        }
        MyDB.close();
        return lista;
    }
    /*Metodo para devolver si un camarero tiene algún mensaje en la base de datos.*/
    public ArrayList<Mensaje> getMensaje(String receptor){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("SELECT * FROM Mensajes WHERE Receptor = '"+receptor+"'",null);
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        while(cursor.moveToNext()){
            Mensaje mj = new Mensaje();
            mj.setEmisor(cursor.getString(0));
            mj.setReceptor(cursor.getString(1));
            mj.setMensaje(cursor.getString(2));
            mensajes.add(mj);
        }
        MyDB.close();
        return mensajes;
    }



    /*Método que devuelve un arraylist rellenado con los platos y bebidas de la base de datos filtrados por la categoria que queramos.*/
    public ArrayList<PlatosyBebidas> checkCategorias(String categoria){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("SELECT * FROM PlatosyBebidas WHERE Id_Categoria = '"+categoria+"'",null);
        ArrayList<PlatosyBebidas> lista = new ArrayList<>();
        while(cursor.moveToNext()){
            PlatosyBebidas pb = new PlatosyBebidas();
            pb.setId(cursor.getInt(0));
            pb.setNombre(cursor.getString(1));
            pb.setId_Categoria(cursor.getString(2));
            pb.setTipo(cursor.getString(3));
            pb.setPrecio(cursor.getDouble(4));
            pb.setId_Ingrediente(cursor.getString(5));
            lista.add(pb);
        }
        MyDB.close();
        return lista;
    }
    /*Método que devuelve un arraylist rellenado con un ticket de la base de datos filtrados por la mesa que queramos.*/
    public ArrayList<Ticket> getTicket(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("SELECT * FROM Ticket",null);
        ArrayList<Ticket> ticket = new ArrayList<>();
        while(cursor.moveToNext()){
            Ticket tick = new Ticket();
            tick.setNumMesa(cursor.getInt(0));
            tick.setPlatos(cursor.getString(1));
            tick.setPrecios(cursor.getString(2));
            tick.setPrecioTotal(cursor.getDouble(3));
            ticket.add(tick);
        }
        MyDB.close();
        return ticket;
    }
    /*Método que hace el update para reasignar un camarero a una mesa.*/
    public Boolean cambiarCamarero(String nombreCamarero, String numMesa){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("numMesa", numMesa);
        contentValues.put("nombreCamarero", nombreCamarero);
        sqLiteDatabase.update("Mesas",contentValues,"numMesa = ?",new String[] {numMesa});
        return true;
    }
    /*Método para hacer el insert a la tabla Mesas.*/
    public Boolean insertMesas(String numMesa, String numPersonas, String nombreCamarero){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("numMesa", numMesa);
        contentValues.put("numPersonas", numPersonas);
        contentValues.put("nombreCamarero", nombreCamarero);
        long result = sqLiteDatabase.insert("Mesas",null,contentValues);
        return result != -1;
    }

    /*Método para hacer el insert en la tabla de Usuarios.*/
    public Boolean insert(String username, String password, String rol) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nUsuario",username);
        contentValues.put("password",password);
        contentValues.put("rol",rol);
        long result = sqLiteDatabase.insert("Usuarios",null,contentValues);
        return result != -1;
    }

    /*Método para hacer el insert en la tabla de Tickets.*/
    public Boolean insertTicket(int NumMesa, String Platos, String Precios, Double PrecioTotal) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NumMesa",NumMesa);
        contentValues.put("Platos",Platos);
        contentValues.put("Precios",Precios);
        contentValues.put("PrecioTotal",PrecioTotal);
        long result = sqLiteDatabase.insert("Ticket",null,contentValues);
        return result != -1;
    }
    /*Método para hacer el insert en la tabla de Mensajes.*/
    public Boolean crearMensaje(String emisor,String receptor,String mensaje) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Emisor",emisor);
        contentValues.put("Receptor",receptor);
        contentValues.put("Mensaje",mensaje);
        long result = sqLiteDatabase.insert("Mensajes",null,contentValues);
        return result != -1;
    }
    /*Metodo para borrar un mensaje ya leído.*/
    public void deleteMensaje(String receptor) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Mensajes", "Receptor=?", new String[]{receptor});
        db.close();
    }
}