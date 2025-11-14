package Banco.modelo;

import Banco.excepciones.Operaciones;
import Banco.modelo.Empleado;


public class Cajero extends Empleado {

    public Cajero(String nombre, String cedula, String direccion, String telefono, String codigoEmpleado) {
        super(nombre, cedula, direccion, telefono, codigoEmpleado);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cajero de Agencia.");
        System.out.println("Nombre: " + this.nombre);
    }

    public void procesarDeposito(Cliente cliente, double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a depositar debe ser positivo.");
            return;
        }
        double saldoActual = cliente.getSaldoEnCuenta();
        cliente.setSaldoEnCuenta(saldoActual + monto);
        System.out.println("Depósito exitoso. Nuevo saldo: $" + cliente.getSaldoEnCuenta());
    }

    public void procesarRetiro(Cliente cliente, double monto) throws Operaciones {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser positivo.");
            return;
        }

        double saldoActual = cliente.getSaldoEnCuenta();

        if (monto > saldoActual) {
            throw new Operaciones("Fondos insuficientes. Saldo: $" + saldoActual + ", Retiro: $" + monto);
        }

        cliente.setSaldoEnCuenta(saldoActual - monto);
        System.out.println("Retiro exitoso. Saldo restante: $" + cliente.getSaldoEnCuenta());
    }
}