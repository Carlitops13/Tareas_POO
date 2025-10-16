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
        if (precio > 0) { // La condición ahora busca lo que SÍ es válido
            this.precio = precio; // Asigna el valor bueno
        } else {
            System.out.println("Error: El precio debe ser un numero positivo");
        }
    }


    public void setNombre(String nombre) {
        if (!nombre.equals("")) { // Condición para un nombre VÁLIDO
            this.nombre = nombre; // Asigna el valor bueno
        } else {
            System.out.println("Error: El nombre del producto está vacío");
        }
    }


    public void mostrar() {
        System.out.println("Nombre del producto: " + this.nombre);
        System.out.println("Precio del producto: " + this.precio);
        System.out.println("--------------------"); // Separador para más claridad
    }
}