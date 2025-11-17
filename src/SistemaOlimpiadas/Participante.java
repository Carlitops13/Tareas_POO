package SistemaOlimpiadas;

public abstract class Participante {
    protected String nombre;
    protected String pais;
    protected int anoRegistro;

    public Participante(String nombre, String pais, int anoRegistro)
            throws DatosInvalidosException {
        validarDatos(nombre, pais, anoRegistro);
        this.nombre = nombre;
        this.pais = pais;
        this.anoRegistro = anoRegistro;
    }

    protected void validarDatos(String nombre, String pais, int anoRegistro)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre no puede estar vacio");
        }
        if (pais == null || pais.trim().isEmpty()) {
            throw new DatosInvalidosException("El pais no puede estar vacio");
        }
        if (anoRegistro < 2000 || anoRegistro > 2100) {
            throw new DatosInvalidosException("El ano de registro debe estar entre 2000 y 2100");
        }
    }

    public abstract String obtenerDetalles();

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getAnoRegistro() {
        return anoRegistro;
    }

    public void setNombre(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public void setPais(String pais) throws DatosInvalidosException {
        if (pais == null || pais.trim().isEmpty()) {
            throw new DatosInvalidosException("El pais no puede estar vacio");
        }
        this.pais = pais;
    }

    public void setAnoRegistro(int anoRegistro) throws DatosInvalidosException {
        if (anoRegistro < 2000 || anoRegistro > 2100) {
            throw new DatosInvalidosException("El ano de registro debe estar entre 2000 y 2100");
        }
        this.anoRegistro = anoRegistro;
    }
}

