package Tarea4.ejercicio2;

public class Producto {
    private double precio;
    private String nombre;

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }


    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: El precio debe ser un numero positivo");
        }
    }


    public void setNombre(String nombre) {
        if (!nombre.equals("")) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: El nombre del producto está vacío");
        }
    }


    public void mostrar() {
        System.out.println("Nombre del producto: " + this.nombre);
        System.out.println("Precio del producto: " + this.precio);
        System.out.println("--------------------");
    }
}