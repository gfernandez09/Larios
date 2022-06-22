package com.example.larios;

public class PlatosyBebidas {
    private int Id;
    private String Nombre;
    private String Id_Categoria;
    private String Tipo;
    private Double Precio;
    private String Id_Ingrediente;

    public PlatosyBebidas(int id, String nombre, String id_Categoria, String tipo, Double precio, String id_Ingrediente) {
        Id = id;
        Nombre = nombre;
        Id_Categoria = id_Categoria;
        Tipo = tipo;
        Precio = precio;
        Id_Ingrediente = id_Ingrediente;
    }

    public PlatosyBebidas(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(String id_Categoria) {
        Id_Categoria = id_Categoria;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getId_Ingrediente() {
        return Id_Ingrediente;
    }

    public void setId_Ingrediente(String id_Ingrediente) {
        Id_Ingrediente = id_Ingrediente;
    }

    @Override
    public String toString() {
        return "Id del Plato: "+Id + "\nNombre: " + Nombre + "\nPrecio: "+ Precio + "\nCategoria: " + Id_Categoria +"\nIngredientes: "+Id_Ingrediente;
    }
}
