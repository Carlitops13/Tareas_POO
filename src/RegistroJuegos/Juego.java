package RegistroJuegos;

public abstract class Juego {
    protected String nombre;
    protected String desarrollador;
    protected int anioLanzamiento;
    protected double calificacion;

    public Juego(String nombre, String desarrollador, int anioLanzamiento, double calificacion)
            throws DatosInvalidosException {
        validarDatos(nombre, desarrollador, anioLanzamiento, calificacion);
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.anioLanzamiento = anioLanzamiento;
        this.calificacion = calificacion;
    }

    public abstract String obtenerDetalles();

    protected void validarDatos(String nombre, String desarrollador,
                               int anioLanzamiento, double calificacion)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del juego no puede estar vacío");
        }
        if (desarrollador == null || desarrollador.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del desarrollador no puede estar vacío");
        }
        if (anioLanzamiento < 1980 || anioLanzamiento > 2025) {
            throw new DatosInvalidosException("El año de lanzamiento debe estar entre 1980 y 2025");
        }
        if (calificacion < 0.0 || calificacion > 10.0) {
            throw new DatosInvalidosException("La calificación debe estar entre 0.0 y 10.0");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setNombre(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del juego no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setDesarrollador(String desarrollador) throws DatosInvalidosException {
        if (desarrollador == null || desarrollador.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del desarrollador no puede estar vacío");
        }
        this.desarrollador = desarrollador;
    }

    public void setAnioLanzamiento(int anioLanzamiento) throws DatosInvalidosException {
        if (anioLanzamiento < 1980 || anioLanzamiento > 2025) {
            throw new DatosInvalidosException("El año de lanzamiento debe estar entre 1980 y 2025");
        }
        this.anioLanzamiento = anioLanzamiento;
    }

    public void setCalificacion(double calificacion) throws DatosInvalidosException {
        if (calificacion < 0.0 || calificacion > 10.0) {
            throw new DatosInvalidosException("La calificación debe estar entre 0.0 y 10.0");
        }
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                ", calificacion=" + calificacion +
                '}';
    }
}

