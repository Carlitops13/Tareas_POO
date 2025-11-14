package Banco.modelo;

import Banco.modelo.Empleado;

public class JefeAgencia extends Empleado {

    public JefeAgencia(String nombre, String cedula, String direccion, String telefono, String codigoEmpleado) {
        super(nombre, cedula, direccion, telefono, codigoEmpleado);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Jefe de Agencia.");
        System.out.println("Nombre: " + this.nombre);
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {
        if (monto > 50000) {
            System.out.println("Préstamo por $" + monto + " para " + cliente.getNombre() + " RECHAZADO (Supera límite de agencia).");
            return false;
        } else {
            System.out.println("Préstamo por $" + monto + " para " + cliente.getNombre() + " APROBADO.");
            cliente.setSaldoEnCuenta(cliente.getSaldoEnCuenta() + monto);
            System.out.println("Monto desembolsado en la cuenta del cliente.");
            return true;
        }
    }

    public void generarReporteOperaciones() {
        System.out.println("\n--- Reporte de Operaciones (Jefe) ---");
        System.out.println("Total depósitos hoy: $15,400.00");
        System.out.println("Total retiros hoy: $3,200.00");
        System.out.println("Préstamos aprobados: 1");
        System.out.println("Nuevos clientes: 1");
        System.out.println("--- Fin del Reporte ---");
    }

    public void evaluarEmpleado(Empleado empleado) {
        System.out.println("Evaluando desempeño de: " + empleado.getNombre());
        System.out.println("Desempeño: Satisfactorio.");
    }
}