package RegistroJuegos;


public abstract class Juego {

    protected String nombre;
    protected double  precio;
    protected int anioLanzamiento;

    public Juego (String  nombre, double precio, int anioLanzamiento){
        this.nombre = nombre;
        this.precio = precio;
        this.anioLanzamiento= anioLanzamiento;

    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    //Para que las clases hijas la implementen
    public abstract void mostrarDetalles();
    

}
