import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        String input = scanner.nextLine();
        // ...existing code...
        input = input.trim().replace(',', '.');
        try {
            double precio = Double.parseDouble(input);
            if (precio < 0) throw new NumberFormatException();
            double iva = precio * 0.15;
            double total = precio + iva;
            System.out.printf("Precio sin IVA: %.2f%n", precio);
            System.out.printf("IVA (15%%): %.2f%n", iva);
            System.out.printf("Precio con IVA: %.2f%n", total);
        } catch (NumberFormatException e) {
            System.out.println("Error: valor incorrecto. Ingrese un número válido.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
        // ...existing code...
    }
}

