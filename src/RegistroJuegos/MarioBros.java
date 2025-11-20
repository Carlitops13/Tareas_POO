package RegistroJuegos;

public class MarioBros extends Juego  {
    private String personajePrincipal;

    public MarioBros(String nombre, double precio, int anioLanzamiento, String personajePrincipal) {
        super(nombre, precio, anioLanzamiento);
        this.personajePrincipal= personajePrincipal;
        //TODO Auto-generated constructor stub
    }


    public String getPersonajePrincipal() {
        return personajePrincipal;
    }

    public void setPersonajePrincipal(String personajePrincipal) {
        this.personajePrincipal = personajePrincipal;
    }
    
   
    @Override
    public void mostrarDetalles() {
        
        System.out.println("---Juego de Mario Bros---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Año:  " + anioLanzamiento);
        System.out.println("Personaje: " + personajePrincipal);
        System.out.println("-------------------------");
        
    }


}
