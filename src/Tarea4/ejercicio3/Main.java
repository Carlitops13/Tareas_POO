package Tarea4.ejercicio3;
public class Main{
    static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria("Carlos");


        // c.saldo = 500; //ERROR: saldo tiene acceso privado


        c.depositar(300);
        c.retirar(100);
        c.retirar(500);


        System.out.println("Saldo final: $" + c.getSaldo());

    }

}

