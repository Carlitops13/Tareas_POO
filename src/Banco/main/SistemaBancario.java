package Banco.main;


import Banco.excepciones.Operaciones;
import Banco.modelo.BalconServicios;
import Banco.modelo.Cajero;
import Banco.modelo.Cliente;
import Banco.modelo.JefeAgencia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Cliente clienteDePrueba = new Cliente("Ana Torres", "1712345678", "Av. Siempre Viva", "0998765432");
        clienteDePrueba.registrarCuenta("Ahorros");
        clienteDePrueba.setSaldoEnCuenta(1000.0);

        Cajero cajeroDePrueba = new Cajero("Carlos Ruiz", "1700000001", "Oficina Central", "0991112223", "C-001");
        BalconServicios balconDePrueba = new BalconServicios("Marta Vera", "1700000002", "Oficina Central", "0994455667", "B-001");
        JefeAgencia jefeDePrueba = new JefeAgencia("Roberto Jefe", "1700000003", "Oficina Central", "0991234567", "J-001");


        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- BIENVENIDO AL SISTEMA BANCARIO ---");
            System.out.println("1. Ingresar como Cliente");
            System.out.println("2. Ingresar como Cajero");
            System.out.println("3. Ingresar como Balcón de Servicios");
            System.out.println("4. Ingresar como Jefe de Agencia");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = 0;

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar solo números. Intente de nuevo.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    menuCliente(scanner, clienteDePrueba);
                    break;
                case 2:
                    menuCajero(scanner, cajeroDePrueba, clienteDePrueba);
                    break;
                case 3:
                    menuBalconServicios(scanner, balconDePrueba, clienteDePrueba);
                    break;
                case 4:
                    menuJefeAgencia(scanner, jefeDePrueba, clienteDePrueba, cajeroDePrueba);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    public static void menuCliente(Scanner scanner, Cliente cliente) {
        System.out.println("\n--- Menú Cliente ---");
        cliente.mostrarRol();
        cliente.verResumenFinanciero();
    }

    public static <OperacionException> void menuCajero(Scanner scanner, Cajero cajero, Cliente cliente) {
        System.out.println("\n--- Menú Cajero ---");
        cajero.mostrarRol();
        System.out.println("Atendiendo a cliente: " + cliente.getNombre());
        System.out.println("1. Realizar Depósito");
        System.out.println("2. Realizar Retiro");
        System.out.print("Seleccione una opción: ");

        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar solo números.");
            scanner.next();
            return;
        }

        double monto = 0;
        try {
            if (opcion == 1 || opcion == 2) {
                System.out.print("Ingrese el monto: ");
                monto = scanner.nextDouble();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Monto no válido. Debe ser un número.");
            scanner.next();
            return;
        }

        if (opcion == 1) {
            cajero.procesarDeposito(cliente, monto);
        } else if (opcion == 2) {
            try {
                cajero.procesarRetiro(cliente, monto);
            } catch (Operaciones e) {
                System.out.println("\n¡Error en la operación! " + e.getMessage());
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void menuBalconServicios(Scanner scanner, BalconServicios balcon, Cliente cliente) {
        System.out.println("\n--- Menú Balcón de Servicios ---");
        balcon.mostrarRol();
        System.out.println("1. Registrar Nuevo Cliente");
        System.out.println("2. Actualizar Datos Cliente Existente");
        System.out.print("Seleccione una opción: ");

        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar solo números.");
            scanner.next();
            return;
        }
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Ingrese nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese cédula: ");
            String cedula = scanner.nextLine();
            System.out.print("Ingrese dirección: ");
            String dir = scanner.nextLine();
            System.out.print("Ingrese teléfono: ");
            String tel = scanner.nextLine();
            Cliente nuevo = balcon.registrarNuevoCliente(nombre, cedula, dir, tel);
            nuevo.verResumenFinanciero();
        } else if (opcion == 2) {
            System.out.println("Actualizando datos para: " + cliente.getNombre());
            System.out.print("Ingrese nueva dirección: ");
            String nuevaDir = scanner.nextLine();
            System.out.print("Ingrese nuevo teléfono: ");
            String nuevoTel = scanner.nextLine();
            balcon.actualizarDatosCliente(cliente, nuevaDir, nuevoTel);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void menuJefeAgencia(Scanner scanner, JefeAgencia jefe, Cliente cliente, Cajero cajero) {
        System.out.println("\n--- Menú Jefe de Agencia ---");
        jefe.mostrarRol();
        System.out.println("1. Aprobar Préstamo");
        System.out.println("2. Generar Reporte de Operaciones");
        System.out.println("3. Evaluar Empleado (Cajero)");
        System.out.print("Seleccione una opción: ");

        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar solo números.");
            scanner.next();
            return;
        }

        if (opcion == 1) {
            System.out.println("Cliente solicitante: " + cliente.getNombre());
            System.out.print("Ingrese monto a aprobar: ");
            double monto = 0;
            try {
                monto = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Monto no válido.");
                scanner.next();
                return;
            }
            jefe.aprobarPrestamo(cliente, monto);
            cliente.verResumenFinanciero();
        } else if (opcion == 2) {
            jefe.generarReporteOperaciones();
        } else if (opcion == 3) {
            jefe.evaluarEmpleado(cajero);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}