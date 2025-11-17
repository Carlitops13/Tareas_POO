package RegistroJuegos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Juego> juegos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        boolean salir = false;

        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║    BIENVENIDO AL SISTEMA DE REGISTRO DE JUEGOS    ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        while (!salir) {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    registrarMarioBros();
                    break;
                case 2:
                    registrarCarreraVehiculos();
                    break;
                case 3:
                    mostrarTodosJuegos();
                    break;
                case 4:
                    buscarJuegoPorNombre();
                    break;
                case 5:
                    filtrarPorTipo();
                    break;
                case 6:
                    eliminarJuego();
                    break;
                case 7:
                    mostrarEstadisticas();
                    break;
                case 8:
                    salir = true;
                    System.out.println("\n¡Gracias por usar el sistema! ¡Hasta luego!");
                    break;
                default:
                    System.out.println(" Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║                   MENÚ PRINCIPAL                   ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Registrar Juego Mario Bros                      ║");
        System.out.println("║ 2. Registrar Juego Carrera de Vehículos            ║");
        System.out.println("║ 3. Mostrar todos los juegos registrados            ║");
        System.out.println("║ 4. Buscar juego por nombre                         ║");
        System.out.println("║ 5. Filtrar juegos por tipo                         ║");
        System.out.println("║ 6. Eliminar juego                                  ║");
        System.out.println("║ 7. Mostrar estadísticas                            ║");
        System.out.println("║ 8. Salir                                           ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
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

    private static int obtenerNumeroPositivo(String mensaje) throws DatosInvalidosException {
        System.out.print(mensaje);
        try {
            int numero = scanner.nextInt();
            scanner.nextLine();
            if (numero <= 0) {
                throw new DatosInvalidosException("El número debe ser positivo");
            }
            return numero;
        } catch (Exception e) {
            scanner.nextLine();
            throw new DatosInvalidosException("Entrada inválida. Se esperaba un número");
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
            throw new DatosInvalidosException("Entrada inválida. Se esperaba un número decimal");
        }
    }

    private static String obtenerTexto(String mensaje) throws DatosInvalidosException {
        System.out.print(mensaje);
        String texto = scanner.nextLine().trim();
        if (texto.isEmpty()) {
            throw new DatosInvalidosException("El texto no puede estar vacío");
        }
        return texto;
    }

    private static boolean obtenerBooleano(String mensaje) {
        System.out.print(mensaje + " (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

    private static void registrarMarioBros() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║      REGISTRO DE NUEVO JUEGO MARIO BROS           ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        try {
            String nombre = obtenerTexto("Ingrese el nombre del juego: ");
            String desarrollador = obtenerTexto("Ingrese el nombre del desarrollador: ");
            int anio = obtenerNumeroPositivo("Ingrese el año de lanzamiento: ");
            double calificacion = obtenerNumeroDecimal("Ingrese la calificación (0.0 - 10.0): ");
            int numeroMundos = obtenerNumeroPositivo("Ingrese el número de mundos: ");
            boolean multiplayer = obtenerBooleano("¿Tiene modo multiplayer?");
            String plataforma = obtenerTexto("Ingrese la plataforma (ej: Nintendo Switch, NES, SNES): ");

            MarioBros juego = new MarioBros(nombre, desarrollador, anio, calificacion,
                                            numeroMundos, multiplayer, plataforma);
            juegos.add(juego);

            System.out.println("\n✅ ¡Juego registrado exitosamente!");
            System.out.println(juego.obtenerDetalles());
        } catch (DatosInvalidosException e) {
            System.out.println("\n❌ Error en los datos ingresados: " + e.getMessage());
        }
    }

    private static void registrarCarreraVehiculos() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║  REGISTRO DE NUEVO JUEGO CARRERA DE VEHÍCULOS     ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        try {
            String nombre = obtenerTexto("Ingrese el nombre del juego: ");
            String desarrollador = obtenerTexto("Ingrese el nombre del desarrollador: ");
            int anio = obtenerNumeroPositivo("Ingrese el año de lanzamiento: ");
            double calificacion = obtenerNumeroDecimal("Ingrese la calificación (0.0 - 10.0): ");
            int numeroCircuitos = obtenerNumeroPositivo("Ingrese el número de circuitos: ");
            String tipoVehiculos = obtenerTexto("Ingrese el tipo de vehículos (ej: Autos, Motos, Camiones): ");
            boolean iaAdaptable = obtenerBooleano("¿Tiene IA adaptable?");
            int maxJugadores = obtenerNumeroPositivo("Ingrese el máximo de jugadores: ");

            CarreraVehiculos juego = new CarreraVehiculos(nombre, desarrollador, anio, calificacion,
                                                          numeroCircuitos, tipoVehiculos, iaAdaptable, maxJugadores);
            juegos.add(juego);

            System.out.println("\n ¡Juego registrado exitosamente!");
            System.out.println(juego.obtenerDetalles());
        } catch (DatosInvalidosException e) {
            System.out.println("\nError en los datos ingresados: " + e.getMessage());
        }
    }

    private static void mostrarTodosJuegos() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║            TODOS LOS JUEGOS REGISTRADOS           ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        if (juegos.isEmpty()) {
            System.out.println("\n No hay juegos registrados aún.");
            return;
        }

        for (int i = 0; i < juegos.size(); i++) {
            System.out.println("\n[Juego " + (i + 1) + "]");
            System.out.println(juegos.get(i).obtenerDetalles());
        }

        System.out.println("Total de juegos registrados: " + juegos.size());
    }

    private static void buscarJuegoPorNombre() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║            BUSCAR JUEGO POR NOMBRE                ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        if (juegos.isEmpty()) {
            System.out.println("\n No hay juegos registrados aún.");
            return;
        }

        try {
            String nombre = obtenerTexto("Ingrese el nombre del juego a buscar: ");
            boolean encontrado = false;

            for (Juego juego : juegos) {
                if (juego.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("\n✅ ¡Juego encontrado!");
                    System.out.println(juego.obtenerDetalles());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\n No se encontró ningún juego con ese nombre.");
            }
        } catch (DatosInvalidosException e) {
            System.out.println("\n Error: " + e.getMessage());
        }
    }

    private static void filtrarPorTipo() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║            FILTRAR JUEGOS POR TIPO                ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        if (juegos.isEmpty()) {
            System.out.println("\n No hay juegos registrados aún.");
            return;
        }

        System.out.println("1. Mario Bros");
        System.out.println("2. Carrera de Vehículos");
        System.out.print("Seleccione el tipo de juego: ");

        int tipo = obtenerOpcion();

        ArrayList<Juego> filtrados = new ArrayList<>();

        if (tipo == 1) {
            for (Juego juego : juegos) {
                if (juego instanceof MarioBros) {
                    filtrados.add(juego);
                }
            }
            System.out.println("\n=== JUEGOS MARIO BROS ===\n");
        } else if (tipo == 2) {
            for (Juego juego : juegos) {
                if (juego instanceof CarreraVehiculos) {
                    filtrados.add(juego);
                }
            }
            System.out.println("\n=== JUEGOS CARRERA DE VEHÍCULOS ===\n");
        } else {
            System.out.println("\n Opción inválida.");
            return;
        }

        if (filtrados.isEmpty()) {
            System.out.println(" No hay juegos de este tipo registrados.");
        } else {
            for (int i = 0; i < filtrados.size(); i++) {
                System.out.println("[Juego " + (i + 1) + "]");
                System.out.println(filtrados.get(i).obtenerDetalles());
            }
            System.out.println("Total: " + filtrados.size() + " juego(s) encontrado(s)");
        }
    }

    private static void eliminarJuego() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║              ELIMINAR JUEGO                       ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        if (juegos.isEmpty()) {
            System.out.println("\n No hay juegos registrados aún.");
            return;
        }

        mostrarTodosJuegos();

        try {
            int indice = obtenerNumeroPositivo("\nIngrese el número del juego a eliminar: ");

            if (indice < 1 || indice > juegos.size()) {
                System.out.println("\n❌ Índice inválido.");
                return;
            }

            Juego eliminado = juegos.remove(indice - 1);
            System.out.println("\n Juego eliminado: " + eliminado.getNombre());
        } catch (DatosInvalidosException e) {
            System.out.println("\n Error: " + e.getMessage());
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n╔═══════════════════════════════════════════════════╗");
        System.out.println("║            ESTADÍSTICAS DEL SISTEMA               ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        if (juegos.isEmpty()) {
            System.out.println("\n No hay juegos registrados aún.");
            return;
        }

        int totalJuegos = juegos.size();
        int marioBros = 0;
        int carreraVehiculos = 0;
        double calificacionPromedio = 0;
        int anioMasAntiguo = Integer.MAX_VALUE;
        int anioMasReciente = Integer.MIN_VALUE;

        for (Juego juego : juegos) {
            if (juego instanceof MarioBros) {
                marioBros++;
            } else if (juego instanceof CarreraVehiculos) {
                carreraVehiculos++;
            }

            calificacionPromedio += juego.getCalificacion();
            anioMasAntiguo = Math.min(anioMasAntiguo, juego.getAnioLanzamiento());
            anioMasReciente = Math.max(anioMasReciente, juego.getAnioLanzamiento());
        }

        calificacionPromedio /= totalJuegos;

        System.out.println("\n✓ Total de juegos registrados: " + totalJuegos);
        System.out.println("✓ Juegos Mario Bros: " + marioBros);
        System.out.println("✓ Juegos Carrera de Vehículos: " + carreraVehiculos);
        System.out.println("✓ Calificación promedio: " + String.format("%.2f", calificacionPromedio) + "/10");
        System.out.println("✓ Año más antiguo: " + anioMasAntiguo);
        System.out.println("✓ Año más reciente: " + anioMasReciente);
    }
}

