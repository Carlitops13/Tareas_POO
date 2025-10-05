package Tarea2;

import java.util.Scanner;

class Estudiante {
    String nombre;
    String apellido;
    double nota1;
    double nota2;
    double nota3;
    Estudiante(String nombre, String apellido, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    public double calcularPromedio() {
        return (this.nota1 + this.nota2 + this.nota3) / 3.0;
    }
}
public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        Estudiante[] estudiantes = new Estudiante[2];

        System.out.println("--- INGRESO DE NOTAS DE ESTUDIANTES ---");

        for (int i = 0; i < estudiantes.length; i++) {
            String nombre;
            String apellido;
            double nota1;
            double nota2;
            double nota3;
            System.out.println("\nDatos del Estudiante N°: " + (i + 1));
            do {
                System.out.print("Ingrese su nombre: ");
                nombre = lector.nextLine();
            } while (nombre.isEmpty());
            do {
                System.out.print("Ingrese su apellido: ");
                apellido = lector.nextLine();
            } while (apellido.isEmpty());

            do {
                System.out.print("Ingrese la nota 1 (0-10): ");
                nota1 = lector.nextDouble();
                if (nota1 < 0 || nota1 > 10) {
                    System.out.println("Error: La nota debe estar entre 0 y 10. Inténtelo de nuevo.");
                }
            } while (nota1 < 0 || nota1 > 10);
            lector.nextLine();
            do {
                System.out.print("Ingrese la nota 2 (0-10): ");
                nota2 = lector.nextDouble();
                if (nota2 < 0 || nota2 > 10) {
                    System.out.println("Error: La nota debe estar entre 0 y 10. Inténtelo de nuevo.");
                }
            } while (nota2 < 0 || nota2 > 10);
            lector.nextLine();
            do {
                System.out.print("Ingrese la nota 3 (0-10): ");
                nota3 = lector.nextDouble();
                if (nota3 < 0 || nota3 > 10) {
                    System.out.println("Error: La nota debe estar entre 0 y 10. Inténtelo de nuevo.");
                }
            } while (nota3 < 0 || nota3 > 10);
            lector.nextLine();
            estudiantes[i] = new Estudiante(nombre, apellido, nota1, nota2, nota3);
        }
        System.out.println("\n---PROMEDIOS FINALES ---");
        for (Estudiante estudiante : estudiantes) {
            double promedio = estudiante.calcularPromedio();
            String promedioFormateado = String.format("%.2f", promedio);
            String estado;
            if (promedio >= 7) {
                estado = "Aprueba";
            } else {
                estado = "Reprueba";
            }
            System.out.println(
                    "Estudiante: " + estudiante.nombre + " " + estudiante.apellido + " | Promedio: " + promedioFormateado + " | Estado: " + estado
            );
        }
        lector.close();
    }
}
