package try_catch_deber.Ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {
    private static GestorProductos gestor = new GestorProductos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Gestor de Productos");

        while (true) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion){

                case 1:
                registrarProducto();
                break;
                case 2:
                    mostrarListaProductos();
                    break;
                case 3:
                    mostrarPromedioPrecios();
                    break;
                case 4:
                    System.out.println("Gracias por usar el gestor de productos.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        }




}

    private static void mostrarPromedioPrecios() {
        try{
            double promedio= gestor.calcularPromedioPrecios();
            System.out.println(String.format("Promedio de precios finales: %.2f", promedio));
            System.out.println("Total de productos: " + gestor.getTotalProductos());
        } catch (DatosInvalidosException e){
            System.out.println("Error: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private static void mostrarListaProductos() {
        try {
            gestor.mostrarProductos();
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarProducto() {
        try {
            System.out.println("Codigo del producto:");
            String codigo = scanner.nextLine();
            System.out.println("Nombre del producto:");
            String nombre = scanner.nextLine();
            System.out.println("Precio base del producto:");
            double precio = Double.parseDouble(scanner.nextLine());
            System.out.println("Tipo de producto (1. Nacional, 2. Importado):");
            int tipo = Integer.parseInt(scanner.nextLine());

            Producto producto;
            if (tipo == 1) {
                producto = new ProductoNacional(codigo, nombre, precio);
            } else if (tipo == 2) {
                producto = new ProductoImportado(codigo, nombre, precio);
            } else {
                throw new IllegalArgumentException("Tipo de producto inválido.");

            }

            gestor.agregarProducto(producto);

        }catch (NumberFormatException e){
            System.out.println("Error: Entrada numérica inválida. ");
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    private static int leerOpcion() {
        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        }
        return opcion;
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Mostrar Lista de Productos");
        System.out.println("3. Calcular Promedio de Precios");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    }