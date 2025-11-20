package Dispositivos;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Lista de dispositivos (Polimorfismo)
        ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();

        try {
            // 1. Creación de objetos válidos
            System.out.println("--- Registrando dispositivos ---");
            Laptop laptop1 = new Laptop("Dell", "XPS 15", 1500.00, 16);
            Telefono telefono1 = new Telefono("Samsung", "Galaxy S23", 900.50, "Android");
            
            listaDispositivos.add(laptop1);
            listaDispositivos.add(telefono1);

            // 2. Intento de registro con datos inválidos (Esto lanzará excepción)
            // Descomenta una de las siguientes líneas para probar el error:
            
            // Caso A: Precio negativo
            // Laptop laptopError = new Laptop("HP", "Pavilion", -500, 8); 
            
            // Caso B: Marca vacía
            // Telefono telefonoError = new Telefono("", "iPhone 15", 1200, "iOS");
        }catch(DatoInvalidoException e){
            System.out.println("Error al registrar: " + e.getMessage());
        }

        
        System.out.println("\n---Mostrando dispositivos---");
        for(Dispositivo dispositivo : listaDispositivos){
            dispositivo.mostrarInfo();
        }
    }
    

}
