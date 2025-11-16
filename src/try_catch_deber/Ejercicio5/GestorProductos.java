package try_catch_deber.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    public List<Producto> productos;

    public GestorProductos(){
        this.productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println("Producto agregado exitosamente: " );

    }
    public void mostrarProductos() throws DatosInvalidosException{
        if (productos.isEmpty()){
            throw new DatosInvalidosException("No hay productos registrados.");

        }
        System.out.println("\nLista de Productos:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).toString() + " - Precio Final: " + productos.get(i));

        }
    }

    public double calcularPromedioPrecios() throws DatosInvalidosException{
        if (productos.isEmpty()) {
            throw new DatosInvalidosException("No se pueden calcular promedios sin productos.");

        }
        double suma = 0;
        for (Producto producto : productos) {
            suma += producto.calcularPrecioFinal();
        }
        return suma/ productos.size();
    }
    public int getTotalProductos(){
        return productos.size();
    }

}
