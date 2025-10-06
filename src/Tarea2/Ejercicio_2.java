package Tarea2;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Cuantos números va a ingresar?: ");
        int numeros= lector.nextInt();
        int contadorPares=0;

        for (int i = 1; i <= numeros; i++) {
            System.out.println("Ingresa el número "+ (i)+ ":");
            int num= lector.nextInt();
            if (num%2==0) {
                contadorPares++;
            }

        }
        System.out.println("Se ingresaron " + contadorPares + " números pares");
    }
}
