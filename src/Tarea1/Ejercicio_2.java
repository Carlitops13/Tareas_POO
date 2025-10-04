package Tarea1;

import java.util.Scanner;

class registroClientes {
    String nombres;
    String apellidos;
    String cedula;
    String telefono;
    String mail;
   registroClientes (String nombres, String apellidos, String cedula, String telefono, String mail){
       this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.mail= mail;
   }
public void MostrarDatos(){
    System.out.println("--- Ficha del Cliente ---");
    System.out.println("Nombres: " + this.nombres);
    System.out.println("Apellidos: " + this.apellidos);
    System.out.println("Cédula: " + this.cedula);
    System.out.println("Teléfono: " + this.telefono);
    System.out.println("Mail: " + this.mail);
    System.out.println("-------------------------");
}
}

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        registroClientes[] clientes = new  registroClientes[2];
        System.out.println("\n---REGISTRO DE CLIENTES---");
        for (int i = 0; i < clientes.length; i++) {
            System.out.println("\n---Registrando cliente N°: " + (i + 1) + "---");
            String nombres;
            String apellidos;
            String cedula;
            String telefono;
            String mail;
            do {
                System.out.println("Ingrese sus nombres: ");
                nombres = lector.nextLine();
                if (nombres.isEmpty()) {
                    System.out.println("Error! No ha ingresado sus nombres, inténtelo de nuevo ");

                }
            } while (nombres.isEmpty());
            do {
                System.out.println("Ingrese sus apellidos: ");
                apellidos = lector.nextLine();
                if (apellidos.isEmpty()) {
                    System.out.println("Error! No ha ingresado sus apellidos, inténtelo de nuevo ");

                }
            } while (apellidos.isEmpty());
            do {
                System.out.println("Ingrese su cédula: ");
                cedula = lector.nextLine();
                if (cedula.isEmpty()) {
                    System.out.println("Error! No ha ingresado su cédula, inténtelo de nuevo ");

                }
            } while (cedula.isEmpty());
            do {
                System.out.println("Ingrese su teléfono: ");
                telefono = lector.nextLine();
                if (telefono.isEmpty()) {
                    System.out.println("Error! No ha ingresado su teléfono, inténtelo de nuevo ");

                }
            } while (telefono.isEmpty());
            do {
                System.out.println("Ingrese su e-mail: ");
                mail = lector.nextLine();
                if (mail.isEmpty() || !mail.contains("@")) {
                    System.out.println("Error! No ha ingresado su email y debe incluir un @, inténtelo de nuevo ");
                }
            } while (mail.isEmpty());

            clientes[i]= new registroClientes(nombres, apellidos, cedula, telefono, mail);
            System.out.println("\n---Cliente  N°: "+ (i+1)+ " registrado con éxito---");
        }
        System.out.println("\n---Usuarios Registrados---");
        for (registroClientes cliente: clientes ){
            cliente.MostrarDatos();
        }



    }
}
