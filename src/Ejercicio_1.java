import java.util.Scanner;
 class productoPlastico{
    String nombre;
    double precio;
    int stock;
    productoPlastico(String nombre, double precio, int stock){
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
    }
     public double precioStock() {

        return this.precio * this.stock;
     }

}
public class Ejercicio_1{
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        productoPlastico[] almacen = new productoPlastico[4];
        System.out.println("Registro de Productos de plástico");

         for  (int i = 0; i < almacen.length; i++) {
             System.out.println("\n---Registrando productos N°:  "+ (i+1)+ "---");
             System.out.println("Ingrese el nombre del  producto ");
             String nombre = lector.nextLine();
             System.out.println("Ingrese el precio del producto ");
             double precio = lector.nextDouble();
             System.out.println("Ingrese stock del producto ");
             int stock = lector.nextInt();
             lector.nextLine();
             almacen[i] = new productoPlastico(nombre, precio, stock);

         }

         double valorTotal=0.0;
         for (productoPlastico producto: almacen){
             valorTotal+= producto.precioStock();
         }
         System.out.println("\n--- El valor total de stock de  los productos es: "+ valorTotal);
         System.out.println("Inventario");

    }
}