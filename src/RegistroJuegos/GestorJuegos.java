package RegistroJuegos;

import java.util.ArrayList;


public class GestorJuegos{

    private ArrayList<Juego> listaJuegos;

    public GestorJuegos(){
        this.listaJuegos = new ArrayList<>();

    }

public void registrarJuego (Juego juego){
        listaJuegos.add(juego);
        System.out.println("Juego reegistrado!");
    }

    public void listarJuegos(){
        if(listaJuegos.isEmpty()){
            System.out.println("No hay juegos registrados");

        }else{
            for (Juego juego : listaJuegos){
                juego.mostrarDetalles();
            }
        }
    }

    public void buscarPorNombre(String nombre){
        boolean encontrado = false;

        for (Juego juego : listaJuegos) {
            if (juego.getNombre().equalsIgnoreCase(nombre)) {
                juego.mostrarDetalles();
                encontrado=true;
                
            }
            
        }
        if (encontrado) {
            System.out.println("No se encontró ningún juego con el nombre: " + nombre);

            
        }
    }

    public void filtrarPorTipo(Class<?> tipo){
        System.out.println("\n---Filtrando por "+ tipo.getSimpleName() + " ---");
        boolean hayResultados= false;
        for (Juego juego : listaJuegos) {
            if (tipo.isInstance(tipo)) {
                juego.mostrarDetalles();
                hayResultados=true;
                
            }
            
        }
        if (hayResultados) {
            System.out.println("No hay juegos de este tipo");
            
        }
    }

}
