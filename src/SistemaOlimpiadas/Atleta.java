package SistemaOlimpiadas;

public class Atleta extends Participante {
    private String deporte;
    private int edad;
    private double altura;

    public Atleta(String nombre, String pais, int anoRegistro, String deporte,
                  int edad, double altura) throws DatosInvalidosException {
        super(nombre, pais, anoRegistro);
        validarDatosAtleta(deporte, edad, altura);
        this.deporte = deporte;
        this.edad = edad;
        this.altura = altura;
    }

    private void validarDatosAtleta(String deporte, int edad, double altura)
            throws DatosInvalidosException {
        if (deporte == null || deporte.trim().isEmpty()) {
            throw new DatosInvalidosException("El deporte no puede estar vacio");
        }
        if (edad < 10 || edad > 100) {
            throw new DatosInvalidosException("La edad debe estar entre 10 y 100 anos");
        }
        if (altura <= 0 || altura > 3) {
            throw new DatosInvalidosException("La altura debe estar entre 0 y 3 metros");
        }
    }

    @Override
    public String obtenerDetalles() {
        return "ATLETA" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Pais: " + pais + "\n" +
               "Ano Registro: " + anoRegistro + "\n" +
               "Deporte: " + deporte + "\n" +
               "Edad: " + edad + " anos" + "\n" +
               "Altura: " + altura + " m";
    }

    public String getDeporte() {
        return deporte;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setDeporte(String deporte) throws DatosInvalidosException {
        if (deporte == null || deporte.trim().isEmpty()) {
            throw new DatosInvalidosException("El deporte no puede estar vacio");
        }
        this.deporte = deporte;
    }

    public void setEdad(int edad) throws DatosInvalidosException {
        if (edad < 10 || edad > 100) {
            throw new DatosInvalidosException("La edad debe estar entre 10 y 100 anos");
        }
        this.edad = edad;
    }

    public void setAltura(double altura) throws DatosInvalidosException {
        if (altura <= 0 || altura > 3) {
            throw new DatosInvalidosException("La altura debe estar entre 0 y 3 metros");
        }
        this.altura = altura;
    }
}

