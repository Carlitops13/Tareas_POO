
package Candidatas_Reina_de_Quito;

import java.util.*;

public class Gestion_Votacion {

    private final Gestion_Candidatas gestion;
    private final Map<Integer, Integer> votos = new HashMap<>();

    public Gestion_Votacion(Gestion_Candidatas gestion) {
        this.gestion = gestion;
    }

    public void votar(int id) throws DatoInvalidoException {
        Candidata c = gestion.buscarporId(id);
        if (c == null) throw new DatoInvalidoException("Candidata no encontrada para votar (ID: " + id + ")");
        votos.put(id, votos.getOrDefault(id, 0) + 1);
    }

    public Map<Integer, Integer> getConteoVotos() {
        return new HashMap<>(votos);
    }

    public List<Candidata> obtenerGanadoras() {
        List<Candidata> lista = gestion.listar();
        if (lista.isEmpty() || votos.isEmpty()) return Collections.emptyList();

        int maxVotos = votos.values().stream().max(Integer::compareTo).orElse(0);
        List<Integer> idsMax = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : votos.entrySet()) {
            if (e.getValue() == maxVotos) idsMax.add(e.getKey());
        }

        List<Candidata> candidatosEmpatados = new ArrayList<>();
        for (Integer id : idsMax) {
            Candidata c = gestion.buscarporId(id);
            if (c != null) candidatosEmpatados.add(c);
        }

        if (candidatosEmpatados.size() <= 1) return candidatosEmpatados;

        candidatosEmpatados.sort((a, b) -> Double.compare(b.getPuntajeJurado(), a.getPuntajeJurado()));
        double mejorPuntaje = candidatosEmpatados.get(0).getPuntajeJurado();
        List<Candidata> ganadoras = new ArrayList<>();
        for (Candidata c : candidatosEmpatados) {
            if (Double.compare(c.getPuntajeJurado(), mejorPuntaje) == 0) ganadoras.add(c);
            else break;
        }
        return ganadoras;
    }

    public void mostrarResultados() {
        System.out.println("Resultados de votación:");
        List<Candidata> lista = gestion.listar();
        if (votos.isEmpty()) {
            System.out.println("No hay votos registrados.");
        } else {
            for (Candidata c : lista) {
                int count = votos.getOrDefault(c.getId(), 0);
                System.out.println("ID " + c.getId() + " - " + c.getNombre() + " : " + count + " votos");
            }
        }

        List<Candidata> ganadoras = obtenerGanadoras();
        if (ganadoras.isEmpty()) {
            System.out.println("No hay ganadoras (falta votos o candidatas).");
        } else if (ganadoras.size() == 1) {
            Candidata g = ganadoras.get(0);
            System.out.println("Ganadora: ID " + g.getId() + " - " + g.getNombre() + " (puntaje jurado: " + g.getPuntajeJurado() + ")");
        } else {
            System.out.println("Empate final entre:");
            for (Candidata g : ganadoras) {
                System.out.println("ID " + g.getId() + " - " + g.getNombre() + " (puntaje jurado: " + g.getPuntajeJurado() + ")");
            }
        }
    }

    public void menuVotacion() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú de Votación ---");
            System.out.println("1. Votar por ID");
            System.out.println("2. Simular votos aleatorios (no usa método de importación)");
            System.out.println("3. Mostrar resultados");
            System.out.println("4. Listar candidatas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            String linea = sc.nextLine();
            int opt;
            try {
                opt = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número.");
                continue;
            }

            try {
                switch (opt) {
                    case 1 -> {
                        System.out.print("Ingrese ID de la candidata: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        votar(id);
                        System.out.println("Voto registrado para ID " + id);
                    }
                    case 2 -> {
                        List<Candidata> lista = gestion.listar();
                        if (lista.isEmpty()) {
                            System.out.println("No hay candidatas registradas para simular votos.");
                            break;
                        }
                        System.out.print("¿Cuántos votos simular? ");
                        int n;
                        try {
                            n = Integer.parseInt(sc.nextLine().trim());
                        } catch (NumberFormatException ex) {
                            System.out.println("Número inválido, se canceló la simulación.");
                            break;
                        }
                        Random r = new Random();
                        List<Integer> ids = new ArrayList<>();
                        for (Candidata c : lista) ids.add(c.getId());
                        for (int i = 0; i < n; i++) {
                            int elegido = ids.get(r.nextInt(ids.size()));
                            try {
                                votar(elegido);
                            } catch (DatoInvalidoException ex) {
                                // no debería ocurrir ya que elegimos de la lista válida
                            }
                        }
                        System.out.println("Simulación completada: " + n + " votos añadidos.");
                    }
                    case 3 -> mostrarResultados();
                    case 4 -> {
                        System.out.println("Candidatas registradas:");
                        for (Candidata c : gestion.listar()) System.out.println(c);
                    }
                    case 0 -> {
                        System.out.println("Saliendo del menú de votación.");
                        return;
                    }
                    default -> System.out.println("Opción no reconocida.");
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
}