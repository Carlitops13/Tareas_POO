package GestionPrecios;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionPrecios {
    private static ArrayList<Double> precios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    ingresarPrecio();
                    break;
                case 2:
                    mostrarPrecios();
                    break;
                case 3:
                    precioMasAlto();
                    break;
                case 4:
                    precioMasBajo();
                    break;
                case 5:
                    precioIguales();
                    break;
                case 6:
                    buscarPrecio();
                    break;
                case 7:
                    salir = true;
                    System.out.println("\nHasta luego!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU DE PRECIOS INMOBILIARIOS =====");
        System.out.println("1. Ingresar precio");
        System.out.println("2. Mostrar todos los precios");
        System.out.println("3. Mostrar precio mas alto");
        System.out.println("4. Mostrar precio mas bajo");
        System.out.println("5. Mostrar precios iguales");
        System.out.println("6. Buscar un precio especifico");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int obtenerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void ingresarPrecio() {
        System.out.print("\nIngrese el precio: ");
        try {
            double precio = scanner.nextDouble();
            scanner.nextLine();

            if (precio <= 0) {
                System.out.println("Error: El precio debe ser mayor a cero.");
                return;
            }

            precios.add(precio);
            System.out.println("Precio ingresado exitosamente.");
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Error: Ingrese un numero valido.");
        }
    }

    private static void mostrarPrecios() {
        System.out.println("\n===== PRECIOS REGISTRADOS =====");
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        for (int i = 0; i < precios.size(); i++) {
            System.out.println((i + 1) + ". $" + precios.get(i));
        }
    }

    private static void precioMasAlto() {
        System.out.println("\n===== PRECIO MAS ALTO =====");
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        double maximo = precios.get(0);
        for (double precio : precios) {
            if (precio > maximo) {
                maximo = precio;
            }
        }

        System.out.println("El precio mas alto es: $" + maximo);
    }

    private static void precioMasBajo() {
        System.out.println("\n===== PRECIO MAS BAJO =====");
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        double minimo = precios.get(0);
        for (double precio : precios) {
            if (precio < minimo) {
                minimo = precio;
            }
        }

        System.out.println("El precio mas bajo es: $" + minimo);
    }

    private static void precioIguales() {
        System.out.println("\n===== PRECIOS IGUALES =====");
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        System.out.print("Ingrese el precio a buscar duplicados: ");
        try {
            double precioBuscado = scanner.nextDouble();
            scanner.nextLine();

            int contador = 0;
            for (double precio : precios) {
                if (precio == precioBuscado) {
                    contador++;
                }
            }

            if (contador > 0) {
                System.out.println("Se encontraron " + contador + " precio(s) igual(es) a $" + precioBuscado);
            } else {
                System.out.println("No se encontraron precios iguales a $" + precioBuscado);
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Error: Ingrese un numero valido.");
        }
    }

    private static void buscarPrecio() {
        System.out.println("\n===== BUSCAR PRECIO =====");
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }

        System.out.print("Ingrese el precio a buscar: ");
        try {
            double precioBuscado = scanner.nextDouble();
            scanner.nextLine();

            if (precios.contains(precioBuscado)) {
                System.out.println("El precio $" + precioBuscado + " fue encontrado en la lista.");
            } else {
                System.out.println("El precio $" + precioBuscado + " no se encuentra en la lista.");
            }
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Error: Ingrese un numero valido.");
        }
    }
}

