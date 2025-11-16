package try_catch_deber.Ejercicio6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaProductos {
    private static final List<Producto> productos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PRODUCTOS ===");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    System.out.println("Saliendo... ¡Gracias por usar el sistema!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            String linea = scanner.nextLine();
            return Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número válido.");
            return -1; // fuerza default en el switch
        } catch (Exception e) {
            System.out.println("Error inesperado al leer la opción: " + e.getMessage());
            return -1;
        }
    }

    private static void registrarProducto() {
        try {
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio: $");
            String precioTexto = scanner.nextLine();
            double precio = Double.parseDouble(precioTexto.trim());

            Producto p = new Producto(nombre, precio);
            productos.add(p);
            System.out.println("Producto registrado: " + p);
        } catch (NumberFormatException e) {
            System.out.println("Error: El precio debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Datos inválidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al registrar: " + e.getMessage());
        }
    }

    private static void mostrarProductos() {
        try {
            if (productos.isEmpty()) {
                System.out.println("No hay productos registrados por el momento.");
                return;
            }

            System.out.println("\n=== LISTA DE PRODUCTOS ===");
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error inesperado al mostrar productos: " + e.getMessage());
        }
    }
}

