package Tarea4.ejercicio1;

public class Main {
   public static void main(String[] args) {
       System.out.println("-----Primer objeto-----");
        Persona persona = new Persona();
        persona.setNombre("Lubswer");
        persona.setEdad(9);
       System.out.println("-----Segundo Objeto-----");
        Persona persona2 = new Persona();
        persona2.setNombre("Jaime");
        persona2.setEdad(20);
       System.out.println("----Tercer objeto (datos erróneos)----");
       Persona persona3 = new Persona();
       persona3.setNombre("");
       persona3.setEdad(-10);
       System.out.println("-----Datos finales-----");
       System.out.println(persona.getNombre());
       System.out.println(persona.getEdad());
       System.out.println(persona2.getNombre());
       System.out.println(persona2.getEdad());
       System.out.println(persona3.getNombre());
       System.out.println(persona3.getEdad());




    }
}
