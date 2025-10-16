package Tarea4.ejercicio2;

public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        System.out.println("---Producto 1--- ");
        producto.setNombre("mantequilla");
        producto.setPrecio(11.5);
        System.out.println("---Producto 2--- ");
        producto2.setNombre("harina");
        producto2.setPrecio(12.5);
        System.out.println("---Producto 3---(datos erróneos) ");
        producto3.setNombre("");
        producto3.setPrecio(-12.5);
        producto.mostrar();
        producto2.mostrar();
        producto3.mostrar();
    }
}
