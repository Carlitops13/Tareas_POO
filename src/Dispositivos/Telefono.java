package Dispositivos;

public class Telefono extends Dispositivo {

    private String sistemaOperativo;

    public Telefono(String marca, String modelo, double precio, String sistemaOperativo) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.sistemaOperativo = sistemaOperativo;
        // TODO Auto-generated constructor stub
    }

    public void mostrarInfo() {
        System.out.println("Teléfono: " + getMarca() + " " + getMarca() +
                "| OS " + sistemaOperativo +
                "| Precio: " + getPrecio());
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

}
