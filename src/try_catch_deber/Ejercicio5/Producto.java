package try_catch_deber.Ejercicio5;

public abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected double precioBase;

    public Producto(String codigo, String nombre, double precioBase) {
        validarDatos(codigo, nombre, precioBase);
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    private void validarDatos(String codigo, String nombre, double precioBase) {
        if (codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (precioBase < 0){
            throw new IllegalArgumentException("El precio base no puede ser negativo.");
        }
    }

    public abstract double calcularPrecioFinal();
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio Base: " + precioBase;
    }
}
