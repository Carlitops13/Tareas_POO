package RegistroJuegos;

public class CarreraVehiculos extends Juego {
    private String tipoVehiculo; // Atributo específico (ej. "Kart", "Moto", "F1")

    public CarreraVehiculos(String nombre, double precio, int anioLanzamiento, String tipoVehiculo) {
        super(nombre, precio, anioLanzamiento);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("--- Juego de Carreras ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Año: " + anioLanzamiento);
        System.out.println("Vehículo: " + tipoVehiculo);
        System.out.println("-------------------------");
    }
}
