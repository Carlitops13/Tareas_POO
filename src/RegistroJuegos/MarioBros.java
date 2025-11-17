package RegistroJuegos;

public class MarioBros extends Juego {
    private int numeroMundos;
    private boolean tieneMultiplayer;
    private String plataforma;

    public MarioBros(String nombre, String desarrollador, int anioLanzamiento,
                     double calificacion, int numeroMundos, boolean tieneMultiplayer,
                     String plataforma) throws DatosInvalidosException {
        super(nombre, desarrollador, anioLanzamiento, calificacion);
        validarDatosMarioBros(numeroMundos, plataforma);
        this.numeroMundos = numeroMundos;
        this.tieneMultiplayer = tieneMultiplayer;
        this.plataforma = plataforma;
    }

    private void validarDatosMarioBros(int numeroMundos, String plataforma)
            throws DatosInvalidosException {
        if (numeroMundos <= 0) {
            throw new DatosInvalidosException("El número de mundos debe ser mayor a 0");
        }
        if (plataforma == null || plataforma.trim().isEmpty()) {
            throw new DatosInvalidosException("La plataforma no puede estar vacía");
        }
    }

    @Override
    public String obtenerDetalles() {
        return "=== JUEGO MARIO BROS ===" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Desarrollador: " + desarrollador + "\n" +
               "Año de Lanzamiento: " + anioLanzamiento + "\n" +
               "Calificación: " + calificacion + "/10" + "\n" +
               "Número de Mundos: " + numeroMundos + "\n" +
               "Multiplayer: " + (tieneMultiplayer ? "Sí" : "No") + "\n" +
               "Plataforma: " + plataforma + "\n";
    }

    public int getNumeroMundos() {
        return numeroMundos;
    }

    public boolean isTieneMultiplayer() {
        return tieneMultiplayer;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setNumeroMundos(int numeroMundos) throws DatosInvalidosException {
        if (numeroMundos <= 0) {
            throw new DatosInvalidosException("El número de mundos debe ser mayor a 0");
        }
        this.numeroMundos = numeroMundos;
    }

    public void setTieneMultiplayer(boolean tieneMultiplayer) {
        this.tieneMultiplayer = tieneMultiplayer;
    }

    public void setPlataforma(String plataforma) throws DatosInvalidosException {
        if (plataforma == null || plataforma.trim().isEmpty()) {
            throw new DatosInvalidosException("La plataforma no puede estar vacía");
        }
        this.plataforma = plataforma;
    }
}

