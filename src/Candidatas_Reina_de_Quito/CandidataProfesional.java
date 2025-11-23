
package Candidatas_Reina_de_Quito;

public class CandidataProfesional extends Candidata {
    private String profesion;
    private int anosExperiencia;

    public CandidataProfesional(int id, String nombre, int edad, String tipo, double puntajeJurado,
                                String distrito, String profesion, int anosExperiencia) throws DatoInvalidoException {
        super(id, nombre, edad, tipo, puntajeJurado, distrito);
        this.profesion = profesion;
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Candidata Profesional:");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Tipo: " + tipo);
        System.out.println("Distrito: " + distrito);
        System.out.println("Puntaje del Jurado: " + puntajeJurado);
        System.out.println("Profesión: " + profesion);
        System.out.println("Años de Experiencia: " + anosExperiencia);
    }
}