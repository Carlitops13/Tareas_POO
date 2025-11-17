package SistemaOlimpiadas;

public class Equipo extends Participante {
    private String nombreEquipo;
    private int cantidadMiembros;
    private String deporte;

    public Equipo(String nombre, String pais, int anoRegistro, String nombreEquipo,
                  int cantidadMiembros, String deporte) throws DatosInvalidosException {
        super(nombre, pais, anoRegistro);
        validarDatosEquipo(nombreEquipo, cantidadMiembros, deporte);
        this.nombreEquipo = nombreEquipo;
        this.cantidadMiembros = cantidadMiembros;
        this.deporte = deporte;
    }

    private void validarDatosEquipo(String nombreEquipo, int cantidadMiembros, String deporte)
            throws DatosInvalidosException {
        if (nombreEquipo == null || nombreEquipo.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del equipo no puede estar vacio");
        }
        if (cantidadMiembros < 2 || cantidadMiembros > 100) {
            throw new DatosInvalidosException("La cantidad de miembros debe estar entre 2 y 100");
        }
        if (deporte == null || deporte.trim().isEmpty()) {
            throw new DatosInvalidosException("El deporte no puede estar vacio");
        }
    }

    @Override
    public String obtenerDetalles() {
        return "EQUIPO" + "\n" +
               "Nombre Pais: " + nombre + "\n" +
               "Pais: " + pais + "\n" +
               "Ano Registro: " + anoRegistro + "\n" +
               "Nombre Equipo: " + nombreEquipo + "\n" +
               "Cantidad de Miembros: " + cantidadMiembros + "\n" +
               "Deporte: " + deporte;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setNombreEquipo(String nombreEquipo) throws DatosInvalidosException {
        if (nombreEquipo == null || nombreEquipo.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del equipo no puede estar vacio");
        }
        this.nombreEquipo = nombreEquipo;
    }

    public void setCantidadMiembros(int cantidadMiembros) throws DatosInvalidosException {
        if (cantidadMiembros < 2 || cantidadMiembros > 100) {
            throw new DatosInvalidosException("La cantidad de miembros debe estar entre 2 y 100");
        }
        this.cantidadMiembros = cantidadMiembros;
    }

    public void setDeporte(String deporte) throws DatosInvalidosException {
        if (deporte == null || deporte.trim().isEmpty()) {
            throw new DatosInvalidosException("El deporte no puede estar vacio");
        }
        this.deporte = deporte;
    }
}

