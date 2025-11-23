// java
package Candidatas_Reina_de_Quito;

import try_catch_deber.Ejercicio5.DatosInvalidosException;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private final Gestion_Candidatas gestion = new Gestion_Candidatas();
    private final Gestion_Votacion votacion = new Gestion_Votacion(gestion);
    private final Scanner sc = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar candidata");
            System.out.println("2. Listar todas");
            System.out.println("3. Buscar por nombre / id");
            System.out.println("4. Filtrar por tipo / distrito");
            System.out.println("5. Votar (manual) / Simular votos");
            System.out.println("6. Mostrar resultados y ganador");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            String linea = sc.nextLine().trim();
            int opt;
            try { opt = Integer.parseInt(linea); } catch (NumberFormatException e) { System.out.println("Opción inválida."); continue; }

            try {
                switch (opt) {
                    case 1 -> registrarCandidata();
                    case 2 -> listarTodas();
                    case 3 -> buscarPorNombreOid();
                    case 4 -> filtrar();
                    case 5 -> menuVotos();
                    case 6 -> votacion.mostrarResultados();
                    case 0 -> { System.out.println("Saliendo..."); return; }
                    default -> System.out.println("Opción no reconocida.");
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private void registrarCandidata() throws DatoInvalidoException {
        try {
            System.out.print("ID (entero): ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) { System.out.println("Nombre obligatorio."); return; }

            System.out.print("Edad (>=16): ");
            int edad = Integer.parseInt(sc.nextLine().trim());
            if (edad < 16) { System.out.println("Edad debe ser >= 16."); return; }

            System.out.print("Tipo (ej. Profesional / Estudiante): ");
            String tipo = sc.nextLine().trim();
            if (tipo.isEmpty()) { System.out.println("Tipo obligatorio."); return; }

            System.out.print("Puntaje jurado (0-100): ");
            double puntaje = Double.parseDouble(sc.nextLine().trim());
            if (puntaje < 0 || puntaje > 100) { System.out.println("Puntaje fuera de rango."); return; }

            System.out.print("Distrito: ");
            String distrito = sc.nextLine().trim();
            if (distrito.isEmpty()) { System.out.println("Distrito obligatorio."); return; }

            Candidata nueva;
            if (tipo.equalsIgnoreCase("profesional")) {
                System.out.print("Profesión: ");
                String profesion = sc.nextLine().trim();
                if (profesion.isEmpty()) { System.out.println("Profesión obligatoria para profesional."); return; }
                System.out.print("Años de experiencia (entero): ");
                int anos = Integer.parseInt(sc.nextLine().trim());
                nueva = new CandidataProfesional(id, nombre, edad, tipo, puntaje, distrito, profesion, anos);
                        } else {
                System.out.print("Universidad: ");
                String universidad = sc.nextLine().trim();
                if (universidad.isEmpty()) { System.out.println("Universidad obligatoria para estudiante."); return; }
                System.out.print("Carrera: ");
                String carrera = sc.nextLine().trim();
                if (carrera.isEmpty()) { System.out.println("Carrera obligatoria para estudiante."); return; }
                nueva = new CandidataEstudiante(id, nombre, edad, tipo, puntaje, universidad, carrera, distrito);
            }

            gestion.registrar(nueva);
            System.out.println("Candidata registrada correctamente.");
        } catch (NumberFormatException ex) {
            System.out.println("Entrada numérica inválida. Operación cancelada.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (DatosInvalidosException e) {
            throw new RuntimeException(e);
        }
    }

    // resto de métodos (listarTodas, buscarPorNombreOid, filtrar, menuVotos) se mantienen igual que antes
    private void listarTodas() {
        List<Candidata> lista = gestion.listar();
        if (lista.isEmpty()) { System.out.println("No hay candidatas registradas."); return; }
        for (Candidata c : lista) System.out.println(c);
    }

    private void buscarPorNombreOid() {
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        if ("1".equals(op)) {
            try {
                System.out.print("Ingrese ID: ");
                int id = Integer.parseInt(sc.nextLine().trim());
                Candidata c = gestion.buscarporId(id);
                if (c == null) System.out.println("No se encontró candidata con ID " + id);
                else System.out.println(c);
            } catch (NumberFormatException e) { System.out.println("ID inválido."); }
        } else {
            System.out.print("Ingrese nombre o parte del nombre: ");
            String nombre = sc.nextLine().trim();
            List<Candidata> res = gestion.buscarPorNombre(nombre);
            if (res.isEmpty()) System.out.println("No se encontraron coincidencias.");
            else for (Candidata c : res) System.out.println(c);
        }
    }

    private void filtrar() {
        System.out.println("1. Filtrar por tipo");
        System.out.println("2. Filtrar por distrito");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        if ("1".equals(op)) {
            System.out.print("Tipo: ");
            String tipo = sc.nextLine().trim();
            List<Candidata> res = gestion.filtrarPorTipo(tipo);
            if (res.isEmpty()) System.out.println("No hay candidatas de tipo: " + tipo);
            else for (Candidata c : res) System.out.println(c);
        } else {
            System.out.print("Distrito: ");
            String distrito = sc.nextLine().trim();
            List<Candidata> encontrados = new ArrayList<>();
            for (Candidata c : gestion.listar()) {
                if (c.getDistrito() != null && c.getDistrito().equalsIgnoreCase(distrito)) encontrados.add(c);
            }
            if (encontrados.isEmpty()) System.out.println("No hay candidatas en el distrito: " + distrito);
            else for (Candidata c : encontrados) System.out.println(c);
        }
    }

    private void menuVotos() {
        System.out.println("1. Votar manual");
        System.out.println("2. Simular votos aleatorios");
        System.out.print("Opción: ");
        String op = sc.nextLine().trim();
        if ("1".equals(op)) {
            try {
                System.out.print("Ingrese ID de la candidata: ");
                int id = Integer.parseInt(sc.nextLine().trim());
                votacion.votar(id);
                System.out.println("Voto registrado para ID " + id);
            } catch (NumberFormatException e) { System.out.println("ID inválido."); }
            catch (DatoInvalidoException e) { System.out.println("Error: " + e.getMessage()); }
        } else if ("2".equals(op)) {
            try {
                System.out.print("¿Cuántos votos simular? ");
                int n = Integer.parseInt(sc.nextLine().trim());
                List<Candidata> lista = gestion.listar();
                if (lista.isEmpty()) { System.out.println("No hay candidatas registradas."); return; }
                Random r = new Random();
                List<Integer> ids = new ArrayList<>();
                for (Candidata c : lista) ids.add(c.getId());
                for (int i = 0; i < n; i++) {
                    int elegido = ids.get(r.nextInt(ids.size()));
                    try { votacion.votar(elegido); } catch (DatoInvalidoException ignored) {}
                }
                System.out.println("Simulación completada: " + n + " votos añadidos.");
            } catch (NumberFormatException e) { System.out.println("Número inválido. Simulación cancelada."); }
        } else {
            System.out.println("Opción no reconocida.");
        }
    }

    public static void main(String[] args) {
        new Main().iniciar();
    }
}