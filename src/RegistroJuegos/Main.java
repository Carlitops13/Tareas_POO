package RegistroJuegos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestorJuegos gestor = new GestorJuegos();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE REGISTRO DE JUEGOS ---");
            System.out.println("1. Registrar Juego de Mario Bros");
            System.out.println("2. Registrar Juego de Carreras");
            System.out.println("3. Mostrar todos los juegos");
            System.out.println("4. Buscar juego por nombre");
            System.out.println("5. Filtrar por tipo de juego");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        registrarMario(gestor, scanner);

                        break;
                    case 2:
                        registrarCarrera(gestor, scanner);
                        break;
                    case 3:
                        gestor.listarJuegos();
                        break;
                    case 4:
                        System.out.println("Ingrese nombre a buscar: ");
                        String nombre = scanner.nextLine();
                        gestor.buscarPorNombre(nombre);
                        break;
                    case 5:
                        filtrarJuegos(gestor, scanner);
                        break;
                    case 6:
                        System.out.println("Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. ");

                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número ");
                scanner.nextLine();
            } catch (ExcepcionJuego e) {
                System.out.println("Error de validación: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());

            }
        } while (opcion != 6);
    }

    private static void registrarMario(GestorJuegos gestor, Scanner scanner) throws ExcepcionJuego {
        System.out.println("\n---Nuevo Mario Bros ---");
        String nombre = leerTexto(scanner, "Nombre:: ");
        double precio = leerDouble(scanner, "Precio: ");
        int anio = leerInt(scanner, "Año: ");
        String personaje = leerTexto(scanner, "Personaje Principal: ");

        gestor.registrarJuego(new MarioBros(nombre, precio, anio, personaje));
    }

    private static void registrarCarrera(GestorJuegos gestor, Scanner scanner) throws ExcepcionJuego {
        System.out.println("\n--- Nuevo Juego de Carreras ---");
        String nombre = leerTexto(scanner, "Nombre: ");
        double precio = leerDouble(scanner, "Precio: ");
        int anio = leerInt(scanner, "Año: ");
        String vehiculo = leerTexto(scanner, "Tipo de Vehículo: ");

        gestor.registrarJuego(new CarreraVehiculos(nombre, precio, anio, vehiculo));
    }

    private static void filtrarJuegos(GestorJuegos gestor, Scanner scanner) {
        System.out.println("1. Mario Bros | 2. Carreras");
        int tipo = scanner.nextInt();
        if (tipo == 1) {
            gestor.filtrarPorTipo(MarioBros.class);

        } else if (tipo == 2) {
            gestor.filtrarPorTipo(CarreraVehiculos.class);

        } else {
            System.out.println("Tipo incorrecto");
        }

    }

    private static int leerInt(Scanner scanner, String msg) throws ExcepcionJuego {
        System.out.println(msg);

        try {
            int val = scanner.nextInt();
            scanner.nextLine();
            if (val < 0)
                throw new ExcepcionJuego("El valor no puede ser negativo ");
            return val;

        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new ExcepcionJuego("Debe ser un numero entero válido ");
        }
    }

    private static double leerDouble(Scanner scanner, String msg) throws ExcepcionJuego {
        System.out.print(msg);
        try {
            double val = scanner.nextDouble();
            scanner.nextLine();
            if (val < 0)
                throw new ExcepcionJuego("El valor no puede ser negativo.");
            return val;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new ExcepcionJuego("Debe ser un número decimal válido.");
        }
    }

    private static String leerTexto(Scanner scanner, String msg) throws ExcepcionJuego {
        System.out.println(msg);
        String texto = scanner.nextLine();
        if (texto.trim().isEmpty())
            throw new ExcepcionJuego("El texto no puede estar vacío");
        return texto;
    }

}
