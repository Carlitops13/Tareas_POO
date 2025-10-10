package Tarea3;

public class Transmision {
    public void iniciar(){
        Motor motor = new Motor();
        motor.conectarTrasmision(this);
    }
}
