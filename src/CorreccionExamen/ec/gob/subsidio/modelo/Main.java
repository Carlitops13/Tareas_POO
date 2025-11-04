package CorreccionExamen.ec.gob.subsidio.modelo;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SolicitanteSubsidio.mostrarReglasSubsidio();


        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese sus ingresos mensuales: ");
        double ingresos = scanner.nextDouble();

        System.out.print("Ingrese la cantidad de vehiculos registrados: ");
        int vehiculos = scanner.nextInt();

        System.out.print("¿Vive en Ecuador? (true/false): ");
        boolean viveEcuador = scanner.nextBoolean();


        SolicitanteSubsidio solicitante = new SolicitanteSubsidio(nombre, cedula, ingresos, vehiculos, viveEcuador);


        System.out.println(solicitante.toString());


        solicitante.generarResultado();

        System.out.println("\n===== Cálculo de consumo mensual =====");


        double consumoBase = solicitante.calcularConsumoMensual();
        System.out.println("Consumo mensual estimado (sin km extra): " + consumoBase + " galones");


        double kmAdicionales = 80.0;
        double consumoExtra = solicitante.calcularConsumoMensual(kmAdicionales);
        System.out.println("Consumo con kilómetros extra (" + kmAdicionales + " km adicionales): " + consumoExtra + " galones");

        scanner.close();
    }
}



