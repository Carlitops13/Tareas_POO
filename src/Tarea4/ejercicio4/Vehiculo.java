package Tarea4.ejercicio4;

public class Vehiculo {
    // Atributos
    public String marca;
    private String modelo;
    private double velocidadMaxima;
    private String codigoSeguridad;
    private String color;

    public Vehiculo(String marca, String modelo, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }


    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equalsIgnoreCase("rojo") ||
                color.equalsIgnoreCase("azul") ||
                color.equalsIgnoreCase("blanco")) {
            this.color = color;
        } else {
            System.out.println("Color no permitido. Use 'rojo', 'azul' o 'blanco'.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Vehículo:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
        System.out.println("Color: " + color);
    }
}