package try_catch_deber.Ejercicio3;

public class Estudiante {
    private String nombre;
    private int edad;

    public Estudiante(String nombre, int edad){
        setNombre(nombre);
        setEdad(edad);

    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        validarEdad(edad);
        this.edad = edad;
    }

    private void validarEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Error: La edad debe estar entre 0 y 120.");
        }

    }

    private void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre.trim();
    }

    private void validarNombre(String nombre) {
        if (nombre==null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El nombre no puede estar vacío.");
        }
    }
    public String toString(){
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}
