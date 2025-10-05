package Tarea2;

import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        System.out.print("Ingrese el número para sacar su tabla de multiplicar: ");
        int numero = ingreso.nextInt();
        for (int i = 1; i <= 10; i++) {

            System.out.print(numero + " X " + i + " = " + (numero * i)+ "\n");
        }

    }

}
