
package Candidatas_Reina_de_Quito;

public class CandidataEstudiante extends Candidata {
    private String universidad;
    private String carrera;

    public CandidataEstudiante(int id, String nombre, int edad, String tipo, double puntajeJurado,
                               String universidad, String carrera, String distrito) throws DatoInvalidoException {
        super(id, nombre, edad, tipo, puntajeJurado, distrito);
        this.universidad = universidad;
        this.carrera = carrera;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Candidata Estudiante:");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Tipo: " + tipo);
        System.out.println("Distrito: " + distrito);
        System.out.println("Puntaje del Jurado: " + puntajeJurado);
        System.out.println("Universidad: " + universidad);
        System.out.println("Carrera: " + carrera);
    }
}