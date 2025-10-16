package Tarea4;

public class Persona {
    private String nombre;
    private int edad;
    private String profesion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

            if (nombre.equals("")) {
                System.out.println("El campo nombre esta vacío");
            }else {
                System.out.println("El nombre es: "+ this.nombre);
            }


    }

    public int getEdad() {

        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;

            if (edad <= 0 || edad > 100) {
                System.out.println("No se permite numeros negativos ni 0");
            }else{
                System.out.println("La edad es: "+this.edad);
            }
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}


