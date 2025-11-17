package try_catch_deber.Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
  public static void validarPago(double monto) throws PagoInvalidoException {
      if (monto < 0) {
          throw new PagoInvalidoException("Error: El pago no puede ser negativo.");
      }
      if (monto == 0) {
          throw new PagoInvalidoException("Error: El pago no puede ser igual a cero.");
      }
      if (monto > 5000) {
          throw new PagoInvalidoException("Error: El pago no puede ser mayor a $5000.");
      }
  }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el monto del pago: ");
            double monto = Double.parseDouble(scanner.nextLine());
            validarPago(monto);
            System.out.println("Pago válido de: " + monto);
        } catch (PagoInvalidoException e) {
            System.out.println((e.getMessage()));
        } catch (NumberFormatException e) {
            System.out.println("Error, entrada inválida");

        }finally {
            scanner.close();
        }
    }
}
