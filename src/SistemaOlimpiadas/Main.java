package SistemaOlimpiadas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Olimpiada> olimpiadas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean salir = false;

        System.out.println("=== BIENVENIDO AL SISTEMA DE OLIMPIADAS ===");

        while (!salir) {
            mostrarMenuPrincipal();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    crearOlimpiada();
                    break;
                case 2:
                    crearEvento();
                    break;
                case 3:
                    registrarAtleta();
                    break;
                case 4:
                    registrarEquipo();
                    break;
                case 5:
                    mostrarOlimpiadas();
                    break;
                case 6:
                    mostrarEventosOlimpiada();
                    break;
                case 7:
                    mostrarParticipantesEvento();
                    break;
                case 8:
                    salir = true;
                    System.out.println("\nHasta luego!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Crear Olimpiada");
        System.out.println("2. Crear Evento");
        System.out.println("3. Registrar Atleta");
        System.out.println("4. Registrar Equipo");
        System.out.println("5. Mostrar Olimpiadas");
        System.out.println("6. Mostrar Eventos de Olimpiada");
        System.out.println("7. Mostrar Participantes de Evento");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int obtenerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static String obtenerTexto(String mensaje) throws DatosInvalidosException {
        System.out.print(mensaje);
        String texto = scanner.nextLine().trim();
        if (texto.isEmpty()) {
            throw new DatosInvalidosException("El texto no puede estar vacio");
        }
        return texto;
    }

    private static int obtenerNumeroPositivo(String mensaje) throws DatosInvalidosException {
        System.out.print(mensaje);
        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            if (numero <= 0) {
                throw new DatosInvalidosException("El numero debe ser positivo");
            }
            return numero;
        } catch (Exception e) {
            scanner.nextLine();
            throw new DatosInvalidosException("Entrada invalida. Se esperaba un numero");
        }
    }

    private static double obtenerNumeroDecimal(String mensaje) throws DatosInvalidosException {
        System.out.print(mensaje);
        try {
            double numero = scanner.nextDouble();
            scanner.nextLine();
            return numero;
        } catch (Exception e) {
            scanner.nextLine();
            throw new DatosInvalidosException("Entrada invalida. Se esperaba un numero decimal");
        }
    }

    private static void crearOlimpiada() {
        System.out.println("\n===== CREAR OLIMPIADA =====");
        try {
            String nombre = obtenerTexto("Ingrese el nombre de la olimpiada: ");
            String pais = obtenerTexto("Ingrese el pais: ");
            int ano = obtenerNumeroPositivo("Ingrese el ano: ");

            Olimpiada olimpiada = new Olimpiada(nombre, pais, ano);
            olimpiadas.add(olimpiada);
            System.out.println("\nOlimpiada creada exitosamente.");
        } catch (DatosInvalidosException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void crearEvento() {
        System.out.println("\n===== CREAR EVENTO =====");

        if (olimpiadas.isEmpty()) {
            System.out.println("No hay olimpiadas registradas.");
            return;
        }

        mostrarListaOlimpiadas();
        int indice = seleccionarOlimpiada();
        if (indice < 0 || indice >= olimpiadas.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        try {
            String nombre = obtenerTexto("Ingrese el nombre del evento: ");
            String disciplina = obtenerTexto("Ingrese la disciplina: ");
            String fecha = obtenerTexto("Ingrese la fecha (dd/mm/yyyy): ");

            Evento evento = new Evento(nombre, disciplina, fecha);
            olimpiadas.get(indice).agregarEvento(evento);
            System.out.println("\nEvento creado exitosamente.");
        } catch (DatosInvalidosException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void registrarAtleta() {
        System.out.println("\n===== REGISTRAR ATLETA =====");

        if (olimpiadas.isEmpty()) {
            System.out.println("No hay olimpiadas registradas.");
            return;
        }

        mostrarListaOlimpiadas();
        int indiceOlimpiada = seleccionarOlimpiada();
        if (indiceOlimpiada < 0 || indiceOlimpiada >= olimpiadas.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        ArrayList<Evento> eventos = olimpiadas.get(indiceOlimpiada).getEventos();
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados en esta olimpiada.");
            return;
        }

        mostrarListaEventos(eventos);
        int indiceEvento = seleccionarEvento(eventos);
        if (indiceEvento < 0 || indiceEvento >= eventos.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        try {
            String nombre = obtenerTexto("Ingrese el nombre del atleta: ");
            String pais = obtenerTexto("Ingrese el pais: ");
            int anoRegistro = obtenerNumeroPositivo("Ingrese el ano de registro: ");
            String deporte = obtenerTexto("Ingrese el deporte: ");
            int edad = obtenerNumeroPositivo("Ingrese la edad: ");
            double altura = obtenerNumeroDecimal("Ingrese la altura (en metros): ");

            Atleta atleta = new Atleta(nombre, pais, anoRegistro, deporte, edad, altura);
            eventos.get(indiceEvento).agregarParticipante(atleta);
            System.out.println("\nAtleta registrado exitosamente.");
        } catch (DatosInvalidosException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void registrarEquipo() {
        System.out.println("\n===== REGISTRAR EQUIPO =====");

        if (olimpiadas.isEmpty()) {
            System.out.println("No hay olimpiadas registradas.");
            return;
        }

        mostrarListaOlimpiadas();
        int indiceOlimpiada = seleccionarOlimpiada();
        if (indiceOlimpiada < 0 || indiceOlimpiada >= olimpiadas.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        ArrayList<Evento> eventos = olimpiadas.get(indiceOlimpiada).getEventos();
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados en esta olimpiada.");
            return;
        }

        mostrarListaEventos(eventos);
        int indiceEvento = seleccionarEvento(eventos);
        if (indiceEvento < 0 || indiceEvento >= eventos.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        try {
            String nombre = obtenerTexto("Ingrese el nombre pais del equipo: ");
            String pais = obtenerTexto("Ingrese el pais: ");
            int anoRegistro = obtenerNumeroPositivo("Ingrese el ano de registro: ");
            String nombreEquipo = obtenerTexto("Ingrese el nombre del equipo: ");
            int cantidadMiembros = obtenerNumeroPositivo("Ingrese la cantidad de miembros: ");
            String deporte = obtenerTexto("Ingrese el deporte: ");

            Equipo equipo = new Equipo(nombre, pais, anoRegistro, nombreEquipo, cantidadMiembros, deporte);
            eventos.get(indiceEvento).agregarParticipante(equipo);
            System.out.println("\nEquipo registrado exitosamente.");
        } catch (DatosInvalidosException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    private static void mostrarOlimpiadas() {
        System.out.println("\n===== OLIMPIADAS REGISTRADAS =====");

        if (olimpiadas.isEmpty()) {
            System.out.println("No hay olimpiadas registradas.");
            return;
        }

        for (int i = 0; i < olimpiadas.size(); i++) {
            System.out.println("\n[Olimpiada " + (i + 1) + "]");
            System.out.println(olimpiadas.get(i).obtenerDetalles());
        }
    }

    private static void mostrarEventosOlimpiada() {
        System.out.println("\n===== EVENTOS DE OLIMPIADA =====");

        if (olimpiadas.isEmpty()) {
            System.out.println("No hay olimpiadas registradas.");
            return;
        }

        mostrarListaOlimpiadas();
        int indice = seleccionarOlimpiada();
        if (indice < 0 || indice >= olimpiadas.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        olimpiadas.get(indice).mostrarEventos();
    }

    private static void mostrarParticipantesEvento() {
        System.out.println("\n===== PARTICIPANTES DE EVENTO =====");

        if (olimpiadas.isEmpty()) {
            System.out.println("No hay olimpiadas registradas.");
            return;
        }

        mostrarListaOlimpiadas();
        int indiceOlimpiada = seleccionarOlimpiada();
        if (indiceOlimpiada < 0 || indiceOlimpiada >= olimpiadas.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        ArrayList<Evento> eventos = olimpiadas.get(indiceOlimpiada).getEventos();
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados en esta olimpiada.");
            return;
        }

        mostrarListaEventos(eventos);
        int indiceEvento = seleccionarEvento(eventos);
        if (indiceEvento < 0 || indiceEvento >= eventos.size()) {
            System.out.println("Indice invalido.");
            return;
        }

        eventos.get(indiceEvento).mostrarParticipantes();
    }

    private static void mostrarListaOlimpiadas() {
        for (int i = 0; i < olimpiadas.size(); i++) {
            System.out.println((i + 1) + ". " + olimpiadas.get(i).getNombre() + " - " +
                             olimpiadas.get(i).getAno());
        }
    }

    private static int seleccionarOlimpiada() {
        System.out.print("\nSeleccione el numero de la olimpiada: ");
        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            return numero - 1;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void mostrarListaEventos(ArrayList<Evento> eventos) {
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i).getNombre() + " - " +
                             eventos.get(i).getDisciplina());
        }
    }

    private static int seleccionarEvento(ArrayList<Evento> eventos) {
        System.out.print("\nSeleccione el numero del evento: ");
        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            return numero - 1;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}

