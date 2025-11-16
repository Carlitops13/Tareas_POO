package try_catch_deber.Ejercicio5;

public class ProductoNacional extends Producto {

    private static final double IVA = 0.12; // 12% IVA para productos nacionales

    public ProductoNacional(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }


    @Override
    public double calcularPrecioFinal() {
        return precioBase * (1 + IVA);
    }

    public String toString() {
        return String.format("Nacional: Código: %s, Nombre: %s, Precio Base: %.2f (IVA 12%%) - Precio Final: %.2f",
                codigo, nombre, precioBase, calcularPrecioFinal());

    }
}
