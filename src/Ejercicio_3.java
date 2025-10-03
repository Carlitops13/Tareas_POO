import java.util.Scanner;

class Postulante {
    String nombre;
    String apellido;
    int edad;
    double estatura;


    Postulante(String nombre, String apellidos, int edad, double estatura) {
        this.nombre = nombre;
        this.apellido = apellidos;
        this.edad = edad;
        this.estatura = estatura;
    }


    public String obtenerEstado() {
        if (this.edad >= 18 && this.estatura >= 1.60) {
            return "Cumple con los requisitos";
        } else {
            return "No cumple con los requisitos";
        }
    }


    public void MostrarDatos() {
        System.out.println("--- Ficha del Postulante ---");
        System.out.println("Nombres: " + this.nombre);
        System.out.println("Apellidos: " + this.apellido);
        System.out.println("Edad: " + this.edad);
        System.out.println("Altura: " + this.estatura + " m");
        System.out.println("Estado: " + this.obtenerEstado());
        System.out.println("-------------------------");
    }
}
public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);


        Postulante[] postulantes = new Postulante[2];

        System.out.println("\n--- REGISTRO DE POSTULANTES ---");


        for (int i = 0; i < postulantes.length; i++) {
            System.out.println("\n--- Registrando Postulante N°: " + (i + 1) + " ---");

            String nombre;
            String apellido;
            int edad;
            double altura;


            do {
                System.out.print("Ingrese su nombre: ");
                nombre = lector.nextLine();
            } while (nombre.isEmpty());


            do {
                System.out.print("Ingrese su apellido: ");
                apellido = lector.nextLine();
            } while (apellido.isEmpty());


            do {
                System.out.print("Ingrese su edad: ");
                while (!lector.hasNextInt()) {
                    System.out.println("Error, debe ingresar un número.");
                    lector.next();
                }
                edad = lector.nextInt();
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa.");
                }
            } while (edad < 0);
            lector.nextLine();
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
            System.out.println("Postulante registrado con éxito!");
        }
        System.out.println("\n--- MOSTRANDO FICHAS DE POSTULANTES ---");
        for (Postulante p : postulantes) {
            p.MostrarDatos();
        }

        lector.close();
    }
}