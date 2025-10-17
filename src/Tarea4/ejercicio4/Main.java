package Tarea4.ejercicio4;

public class Main {
    static void main(String[] args) {
        Vehiculo v = new Vehiculo("Toyota", "Corolla", 220);


        System.out.println("Marca (pública): " + v.marca);
        v.marca = "Honda";
        System.out.println("Marca actualizada: " + v.marca);


        v.setModelo("Civic");
        System.out.println("Modelo: " + v.getModelo());


        System.out.println("Velocidad Máxima: " + v.getVelocidadMaxima());

        //  Intentar leer código de seguridad (no existe getter)
        // System.out.println(v.codigoSeguridad); // ERROR: private
        // System.out.println(v.getCodigoSeguridad()); // ERROR: no existe


        v.setCodigoSeguridad("ABC123");


        v.setColor("verde");
        v.setColor("rojo");

        v.mostrarInfo();
    }
}

