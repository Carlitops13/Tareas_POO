package try_catch_deber.Ejercicio4;

public class PagoInvalidoException extends Exception{
    public PagoInvalidoException(String mensaje){
        super(mensaje);
    }
}
