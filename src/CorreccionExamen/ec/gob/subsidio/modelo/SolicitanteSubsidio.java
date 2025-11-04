package CorreccionExamen.ec.gob.subsidio.modelo;

public class SolicitanteSubsidio {


    private String nombreCompleto;
    private String cedula;
    private double ingresosMensuales;
    private int cantidadVehiculos;
    private boolean viveEnEcuador;


    public SolicitanteSubsidio(String nombreCompleto, String cedula, double ingresosMensuales, int cantidadVehiculos, boolean viveEnEcuador) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        // Usamos los setters para aplicar validaciones desde la creación
        this.setIngresosMensuales(ingresosMensuales);
        this.setCantidadVehiculos(cantidadVehiculos);
        this.viveEnEcuador = viveEnEcuador;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getIngresosMensuales() {
        return ingresosMensuales;
    }


    public void setIngresosMensuales(double ingresosMensuales) {
        if (ingresosMensuales >= 470.0) {
            this.ingresosMensuales = ingresosMensuales;
        } else {

            this.ingresosMensuales = 470.0;
            System.out.println("Error: El ingreso mínimo es $470. Se ha asignado el valor mínimo.");
        }
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }


    public void setCantidadVehiculos(int cantidadVehiculos) {
        if (cantidadVehiculos >= 0) {
            this.cantidadVehiculos = cantidadVehiculos;
        } else {
            this.cantidadVehiculos = 0;
            System.out.println("Error: La cantidad de vehículos no puede ser negativa. Se ha asignado 0.");
        }
    }

    public boolean isViveEnEcuador() {
        return viveEnEcuador;
    }

    public void setViveEnEcuador(boolean viveEnEcuador) {
        this.viveEnEcuador = viveEnEcuador;
    }




    public static void mostrarReglasSubsidio() {
        System.out.println("Reglas para obtener el subsidio");
        System.out.println("1. Tener ingresos mensuales menores o iguales a $1,200.");
        System.out.println("2. No poseer más de un vehiculo registrado.");
        System.out.println("3. Tener residencia en Ecuador.");
    }


    public boolean subsidioAprobado() {
        boolean cumpleIngresos = this.ingresosMensuales <= 1200.0;
        boolean cumpleVehiculos = this.cantidadVehiculos <= 1;
        boolean cumpleResidencia = this.viveEnEcuador;

        return cumpleIngresos && cumpleVehiculos && cumpleResidencia;
    }



    public void generarResultado() {
        System.out.println("===== Resultado de la evaluación =====");
        if (subsidioAprobado()) {
            System.out.println("Subsidio aprobado: Cumple con todos los requisitos establecidos por el Gobierno del Ecuador.");
        } else {
            System.out.println("Subsidio rechazado: No cumple con uno o más requisitos.");

            if (this.ingresosMensuales > 1200.0) {
                System.out.println("- Motivo: Ingresos superan los $1,200.");
            }
            if (this.cantidadVehiculos > 1) {
                System.out.println("- Motivo: Posee más de un vehículo.");
            }
            if (!this.viveEnEcuador) {
                System.out.println("- Motivo: No reside en Ecuador.");
            }
        }
    }


    public double calcularConsumoMensual() {
        double kmBase = 400.0;
        double rendimiento = 40.0;
        return kmBase / rendimiento;
    }


    public double calcularConsumoMensual(double kmExtra) {
        double kmBase = 400.0;
        double rendimiento = 40.0;
        return (kmBase + kmExtra) / rendimiento;
    }


    @Override
    public String toString() {
        return "===== Datos del solicitante =====\n" +
        "Nombre: " + nombreCompleto + "\n" +
        "Cédula: " + cedula + "\n" +
        "Ingresos mensuales: $" + ingresosMensuales + "\n" +
        "Cantidad de vehículos: " + cantidadVehiculos + "\n" +
        "Vive en Ecuador: " + viveEnEcuador;
    }
}