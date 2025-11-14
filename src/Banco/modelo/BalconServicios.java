package Banco.modelo;

import Banco.modelo.Cliente;
import Banco.modelo.Empleado;

public class BalconServicios extends Empleado {

    public BalconServicios(String nombre, String cedula, String direccion, String telefono, String codigoEmpleado) {
        super(nombre, cedula, direccion, telefono, codigoEmpleado);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Balcón de Servicios.");
        System.out.println("Nombre: " + this.nombre);
    }

    public Cliente registrarNuevoCliente(String nombre, String cedula, String dir, String tel) {
        System.out.println("Registrando nuevo cliente: " + nombre);
        Cliente nuevoCliente = new Cliente(nombre, cedula, dir, tel);
        nuevoCliente.registrarCuenta("Ahorros");
        System.out.println("Cliente " + nombre + " registrado con éxito.");
        return nuevoCliente;
    }

    public void actualizarDatosCliente(Cliente cliente, String nuevaDir, String nuevoTel) {
        cliente.actualizarDatos(nuevaDir, nuevoTel);
        System.out.println("Datos del cliente " + cliente.getNombre() + " actualizados.");
    }
}