package Banco.modelo;


public abstract class Persona {
    protected String nombre;
    protected String cedula;
    protected String direccion;
    protected String telefono;

    public Persona(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void actualizarDatos(String direccion, String telefono) {
        this.direccion = direccion;
        this.telefono = telefono;
        System.out.println("Datos actualizados para: " + this.nombre);
    }

    public abstract void mostrarRol();

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
}
