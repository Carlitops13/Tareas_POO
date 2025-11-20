package Dispositivos;

public class Laptop extends Dispositivo {
    private int memoriaRam;

    public Laptop(String marca, String modelo, double precio, int memoriaRam) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.memoriaRam = memoriaRam;
    }
    // TODO Auto-generated constructor stub

    public void mostrarInfo() {
        System.out.println("Laptop: " + getMarca() + " " + getModelo() +
                "| RAM: " + memoriaRam + "GB" +
                "| Precio: " + getPrecio());
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

}
