
package Candidatas_Reina_de_Quito;

public abstract class Candidata {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String tipo;
    protected double puntajeJurado;
    protected String distrito;
    private static final String[] TIPOS_VALIDOS = {"ESTUDIANTE", "PROFESIONAL", "OTROS"};

    public Candidata(int id, String nombre, int edad, String tipo, double puntajeJurado, String distrito) throws DatoInvalidoException {
        this.id = id;
        setNombre(nombre);
        setEdad(edad);
        setTipo(tipo);
        setPuntajeJurado(puntajeJurado);
        setDistrito(distrito);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatoInvalidoException {
        DatoInvalidoException.validarNombre(nombre);
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws DatoInvalidoException {
        DatoInvalidoException.validarEdad(edad);
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws DatoInvalidoException {
        validarTipo(tipo);
        this.tipo = normalizeTipo(tipo);
    }

    public double getPuntajeJurado() {
        return puntajeJurado;
    }

    public void setPuntajeJurado(double puntajeJurado) throws DatoInvalidoException {
        DatoInvalidoException.validarPuntaje(puntajeJurado);
        this.puntajeJurado = puntajeJurado;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) throws DatoInvalidoException {
        if (distrito == null || distrito.trim().isEmpty()) {
            throw new DatoInvalidoException("Distrito no puede ser nulo o vacío");
        }
        this.distrito = distrito.trim();
    }

    public void validar() throws DatoInvalidoException {
        DatoInvalidoException.validarNombre(nombre);
        DatoInvalidoException.validarEdad(edad);
        DatoInvalidoException.validarPuntaje(puntajeJurado);
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new DatoInvalidoException("Tipo no puede ser nulo o vacío");
        }
        validarTipo(tipo);
        if (distrito == null || distrito.trim().isEmpty()) {
            throw new DatoInvalidoException("Distrito no puede ser nulo o vacío");
        }
    }

    private static void validarTipo(String tipo) throws DatoInvalidoException {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new DatoInvalidoException("Tipo vacío o nulo");
        }
        String t = tipo.trim().toUpperCase();
        for (String v : TIPOS_VALIDOS) {
            if (v.equals(t)) return;
        }
        throw new DatoInvalidoException("Tipo inválido: " + tipo);
    }

    private static String normalizeTipo(String tipo) {
        String t = tipo.trim().toUpperCase();
        switch (t) {
            case "ESTUDIANTE": return "Estudiante";
            case "PROFESIONAL": return "Profesional";
            default: return "Otros";
        }
    }

    @Override
    public String toString() {
        return "Candidata{id=" + id +
               ", nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", tipo=" + tipo +
               ", distrito=" + distrito +
               ", puntajeJurado=" + puntajeJurado + '}';
    }

    public abstract void mostrarDetalles();
}