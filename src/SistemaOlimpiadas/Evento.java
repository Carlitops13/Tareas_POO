package SistemaOlimpiadas;

import java.util.ArrayList;

public class Evento {
    private String nombre;
    private String disciplina;
    private String fecha;
    private ArrayList<Participante> participantes;

    public Evento(String nombre, String disciplina, String fecha)
            throws DatosInvalidosException {
        validarDatos(nombre, disciplina, fecha);
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.fecha = fecha;
        this.participantes = new ArrayList<>();
    }

    private void validarDatos(String nombre, String disciplina, String fecha)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del evento no puede estar vacio");
        }
        if (disciplina == null || disciplina.trim().isEmpty()) {
            throw new DatosInvalidosException("La disciplina no puede estar vacia");
        }
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new DatosInvalidosException("La fecha no puede estar vacia");
        }
    }

    public void agregarParticipante(Participante participante) throws DatosInvalidosException {
        if (participante == null) {
            throw new DatosInvalidosException("El participante no puede ser nulo");
        }
        participantes.add(participante);
    }

    public void mostrarParticipantes() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes registrados en este evento.");
            return;
        }

        System.out.println("Participantes del evento: " + nombre);
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println("\n[Participante " + (i + 1) + "]");
            System.out.println(participantes.get(i).obtenerDetalles());
        }
    }

    public String obtenerDetalles() {
        return "EVENTO" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Disciplina: " + disciplina + "\n" +
               "Fecha: " + fecha + "\n" +
               "Total de Participantes: " + participantes.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setNombre(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del evento no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public void setDisciplina(String disciplina) throws DatosInvalidosException {
        if (disciplina == null || disciplina.trim().isEmpty()) {
            throw new DatosInvalidosException("La disciplina no puede estar vacia");
        }
        this.disciplina = disciplina;
    }

    public void setFecha(String fecha) throws DatosInvalidosException {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new DatosInvalidosException("La fecha no puede estar vacia");
        }
        this.fecha = fecha;
    }
}

