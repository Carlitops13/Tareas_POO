package try_catch_deber.Ejercicio3;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        try{
//            System.out.println("Nombre: ");
//            String nombre = sc.nextLine();
//            System.out.println("Edad: ");
//            int edad = Integer.parseInt(sc.nextLine());
//            Estudiante estudiante = new Estudiante(nombre, edad);
//            System.out.println("Creado estudiante: " + estudiante);

            Estudiante e = new Estudiante("Carlos", -5);
            System.out.println(e);

        } catch (NumberFormatException ex){
            System.out.println("Error: Edad debe ser un número entero válido.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Validación fallida: " + ex.getMessage());
        } catch (Exception ex){
            System.out.println("Error inesperado: " + ex.getMessage());
        } finally {
            sc.close();
        }
    }
}
