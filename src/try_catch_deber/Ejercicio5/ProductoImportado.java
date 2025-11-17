package try_catch_deber.Ejercicio5;

public class ProductoImportado extends Producto{
private static final double IMPUESTO_IMPORTACION= 0.05;
    public ProductoImportado(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * (1 + IMPUESTO_IMPORTACION);
    }
    public String toString() {
        return String.format("Importado: Código: %s, Nombre: %s, Precio Base: %.2f (Impuesto de importación 5%%) - Precio Final: %.2f",
                codigo, nombre, precioBase, calcularPrecioFinal());
    }
}
