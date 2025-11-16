package try_catch_deber;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;  //variable boolean para controlar el bucle

        while (continuar) {
            try{
                //Mostrar menú
                System.out.println("\n====Menú====");
                System.out.println("1. Calcular la suma");
                System.out.println("2. Calcular la resta");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción (1-3): ");

                // AQUI SE LEE LA OPCION
                int opcion = Integer.parseInt(scanner.nextLine());
                //validar rango de opciones
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Error: Opción inválida. Por favor, seleccione una opción entre 1 y 3.");
                    continue; //volver al inicio del bucle
                }
                switch (opcion){
                    case 1:
                        System.out.println("Aqui se realiza la suma");
                        break;
                    case 2:
                        System.out.println("Aqui se realiza la resta");
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                    case 4:
                        continuar= false;
                        System.out.println("Adios");
                        break;
                }
            }catch (NumberFormatException e ){
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número válido.");
            } catch (Exception e){
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

}
