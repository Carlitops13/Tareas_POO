package Candidatas_Reina_de_Quito;

public class DatoInvalidoException extends Exception {



    public DatoInvalidoException (String mensaje) {
        super(mensaje);
    }
    public DatoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);

    }
    public static void validarNombre(String nombre) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("Nombre vacío o nulo");
        }
    }

    public static void validarEdad(int edad) throws DatoInvalidoException {
        if (edad <= 0) {
            throw new DatoInvalidoException("Edad inválida: debe ser mayor que 0");
        }
    }
    public static void validarPuntaje(double puntaje) throws DatoInvalidoException {
        if (puntaje < 0) {
            throw new DatoInvalidoException("Puntaje inválido: no puede ser negativo");
        }
    }

}
