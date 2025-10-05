package Tarea2;

import java.util.Scanner;

class   Postulante {
     String nombre;
     String apellido;
     int edad;
     double altura;
     Postulante (String nombre, String apellido, int edad, double altura) {
         this.nombre = nombre;
         this.apellido = apellido;
         this.edad = edad;
         this.altura = altura;
     }
     public String  Estado(){
         if (this.edad >18 && this.altura>= 1.60) {
             return "Aceptado para el equipo";
         } else {
             return "No aceptado para el equipo";
         }
     }
}
public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Postulante[] postulantes = new Postulante[1];
        for (int i = 0; i < postulantes.length; i++) {
            String nombre;
            int edad;
            double altura ;
            do {
                System.out.print("Ingrese su nombre: ");
                nombre = lector.nextLine();
            } while (nombre.isEmpty());
            String apellido;
            do {
                System.out.print("Ingrese su apellido: ");
                apellido = lector.nextLine();
            } while (apellido.isEmpty());
            do {
                System.out.print("Ingrese su edad: ");
                edad = lector.nextInt();
                if (edad<0 || edad>100) {
                    System.out.println("Error: No se permite números negativos");
                }

        }while  (edad<0 || edad>100);
            do {
                System.out.print("Ingrese su altura (ej: 1.75): ");
                while (!lector.hasNextDouble()) {
                    System.out.println("Error, debe ingresar un número con decimales.");
                    lector.next();
                }
                altura = lector.nextDouble();
                if (altura < 0) {
                    System.out.println("La altura no puede ser negativa.");
                }
            } while (altura < 0);
            lector.nextLine();
            postulantes[i] = new Postulante(nombre, apellido, edad, altura);
    }
        for (Postulante postulante : postulantes) {
            System.out.println("El estudiante "+postulante.nombre+" " +postulante.apellido +" "+ postulante.Estado());
        }
        lector.close();
  }
}
