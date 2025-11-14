package Banco.modelo;

public abstract class Empleado extends Persona {

    private String codigoEmpleado;

    public Empleado(String nombre, String cedula, String direccion, String telefono, String codigoEmpleado) {
        super(nombre, cedula, direccion, telefono);
        this.codigoEmpleado = codigoEmpleado;
    }

    public boolean autenticarEmpleado(String usuario, String clave) {
        return this.codigoEmpleado.equals(usuario) && "1234".equals(clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Empleado del Banco.");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Código: " + this.codigoEmpleado);
    }
}