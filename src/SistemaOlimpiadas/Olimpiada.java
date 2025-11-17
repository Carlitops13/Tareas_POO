package SistemaOlimpiadas;

import java.util.ArrayList;

public class Olimpiada {
    private String nombre;
    private String pais;
    private int ano;
    private ArrayList<Evento> eventos;

    public Olimpiada(String nombre, String pais, int ano)
            throws DatosInvalidosException {
        validarDatos(nombre, pais, ano);
        this.nombre = nombre;
        this.pais = pais;
        this.ano = ano;
        this.eventos = new ArrayList<>();
    }

    private void validarDatos(String nombre, String pais, int ano)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre de la olimpiada no puede estar vacio");
        }
        if (pais == null || pais.trim().isEmpty()) {
            throw new DatosInvalidosException("El pais no puede estar vacio");
        }
        if (ano < 1900 || ano > 2100) {
            throw new DatosInvalidosException("El ano debe estar entre 1900 y 2100");
        }
    }

    public void agregarEvento(Evento evento) throws DatosInvalidosException {
        if (evento == null) {
            throw new DatosInvalidosException("El evento no puede ser nulo");
        }
        eventos.add(evento);
    }

    public void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        System.out.println("Eventos de: " + nombre);
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println("\n[Evento " + (i + 1) + "]");
            System.out.println(eventos.get(i).obtenerDetalles());
        }
    }

    public String obtenerDetalles() {
        return "OLIMPIADA" + "\n" +
               "Nombre: " + nombre + "\n" +
               "Pais: " + pais + "\n" +
               "Ano: " + ano + "\n" +
               "Total de Eventos: " + eventos.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getAno() {
        return ano;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setNombre(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre de la olimpiada no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public void setPais(String pais) throws DatosInvalidosException {
        if (pais == null || pais.trim().isEmpty()) {
            throw new DatosInvalidosException("El pais no puede estar vacio");
        }
        this.pais = pais;
    }

    public void setAno(int ano) throws DatosInvalidosException {
        if (ano < 1900 || ano > 2100) {
            throw new DatosInvalidosException("El ano debe estar entre 1900 y 2100");
        }
        this.ano = ano;
    }
}

