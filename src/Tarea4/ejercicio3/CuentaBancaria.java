package Tarea4.ejercicio3;

public class CuentaBancaria {
    private double saldo = 0;
    private String titular;

    public CuentaBancaria(String titular) {
        this.titular = titular;
    }


    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso de $" + monto);
        } else {
            System.out.println("Error: El monto del depósito debe ser positivo.");
        }
    }


    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso de $" + monto);
        } else if (monto > saldo) {
            System.out.println("Error: Saldo insuficiente para retirar $" + monto);
        } else {
            System.out.println("Error: El monto del retiro debe ser positivo.");
        }
    }


    public double getSaldo() {
        return saldo;
    }
}