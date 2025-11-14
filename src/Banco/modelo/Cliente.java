package Banco.modelo;

import Banco.modelo.Persona;

public class Cliente extends Persona {

    private double saldoEnCuenta;

    public Cliente(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono);
        this.saldoEnCuenta = 0.0;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cliente del Banco.");
        System.out.println("Nombre: " + this.nombre);
    }

    public void registrarCuenta(String tipo) {
        System.out.println("Cuenta " + tipo + " registrada para " + this.nombre);
        this.saldoEnCuenta = 50.0;
    }

    public void verResumenFinanciero() {
        System.out.println("--- Resumen Financiero de " + this.nombre + " ---");
        System.out.println("Saldo disponible: $" + this.saldoEnCuenta);
        System.out.println("-------------------------------------------");
    }

    public double getSaldoEnCuenta() {
        return saldoEnCuenta;
    }

    public void setSaldoEnCuenta(double saldoEnCuenta) {
        this.saldoEnCuenta = saldoEnCuenta;
    }
}