package Tarea3;

public class Coche {
    String marca;
    String modelo;
    int velocidad = 0;
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    public void acelerar(int cantidad) {
        this.velocidad += cantidad;
        System.out.println("El " + this.marca + " acelera. Velocidad actual: " + this.velocidad + " km/h");
    }
    public String obtenerDescripcion() {
        return "Coche: " + this.marca + " " + this.modelo;
    }
}
