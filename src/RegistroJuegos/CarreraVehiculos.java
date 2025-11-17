package RegistroJuegos;

public class CarreraVehiculos extends Juego {
    private int numeroCircuitos;
    private String tipoVehiculos;
    private boolean tieneIAadaptable;
    private int maxJugadores;

    public CarreraVehiculos(String nombre, String desarrollador, int anioLanzamiento,
                            double calificacion, int numeroCircuitos, String tipoVehiculos,
                            boolean tieneIAadaptable, int maxJugadores) throws DatosInvalidosException {
        super(nombre, desarrollador, anioLanzamiento, calificacion);
        validarDatosCarrera(numeroCircuitos, tipoVehiculos, maxJugadores);
        this.numeroCircuitos = numeroCircuitos;
        this.tipoVehiculos = tipoVehiculos;
        this.tieneIAadaptable = tieneIAadaptable;
        this.maxJugadores = maxJugadores;
    }

    private void validarDatosCarrera(int numeroCircuitos, String tipoVehiculos, int maxJugadores)
            throws DatosInvalidosException {
        if (numeroCircuitos <= 0) {
            throw new DatosInvalidosException("El número de circuitos debe ser mayor a 0");
        }
        if (tipoVehiculos == null || tipoVehiculos.trim().isEmpty()) {
            throw new DatosInvalidosException("El tipo de vehículos no puede estar vacío");
        }
        if (maxJugadores <= 0) {
            throw new DatosInvalidosException("El número máximo de jugadores debe ser mayor a 0");
        }
    }

    @Override
    public String obtenerDetalles() {
        return "=== JUEGO CARRERA DE VEHÍCULOS ===" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Desarrollador: " + desarrollador + "\n" +
               "Año de Lanzamiento: " + anioLanzamiento + "\n" +
               "Calificación: " + calificacion + "/10" + "\n" +
               "Número de Circuitos: " + numeroCircuitos + "\n" +
               "Tipo de Vehículos: " + tipoVehiculos + "\n" +
               "IA Adaptable: " + (tieneIAadaptable ? "Sí" : "No") + "\n" +
               "Máximo de Jugadores: " + maxJugadores + "\n";
    }

    public int getNumeroCircuitos() {
        return numeroCircuitos;
    }

    public String getTipoVehiculos() {
        return tipoVehiculos;
    }

    public boolean isTieneIAadaptable() {
        return tieneIAadaptable;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setNumeroCircuitos(int numeroCircuitos) throws DatosInvalidosException {
        if (numeroCircuitos <= 0) {
            throw new DatosInvalidosException("El número de circuitos debe ser mayor a 0");
        }
        this.numeroCircuitos = numeroCircuitos;
    }

    public void setTipoVehiculos(String tipoVehiculos) throws DatosInvalidosException {
        if (tipoVehiculos == null || tipoVehiculos.trim().isEmpty()) {
            throw new DatosInvalidosException("El tipo de vehículos no puede estar vacío");
        }
        this.tipoVehiculos = tipoVehiculos;
    }

    public void setTieneIAadaptable(boolean tieneIAadaptable) {
        this.tieneIAadaptable = tieneIAadaptable;
    }

    public void setMaxJugadores(int maxJugadores) throws DatosInvalidosException {
        if (maxJugadores <= 0) {
            throw new DatosInvalidosException("El número máximo de jugadores debe ser mayor a 0");
        }
        this.maxJugadores = maxJugadores;
    }
}

