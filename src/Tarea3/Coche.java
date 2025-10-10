package Tarea3;

public class Coche {
    private int velocidad;
    public Coche(){
        this.velocidad = 0;
    }
    public void acelerar (int cantidad ){
        if (cantidad > 0){
            this.velocidad += cantidad;
            System.out.println("Velocidad actual: "+ this.velocidad);
        }
    }
}
