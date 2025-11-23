package Candidatas_Reina_de_Quito;

import try_catch_deber.Ejercicio5.DatosInvalidosException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Gestion_Candidatas {
    private final List<Candidata> lista = new ArrayList<>();

    public void registrar(Candidata c) throws DatosInvalidosException {
        if (c == null) throw new DatosInvalidosException("Candidata nula");
        if (buscarporId(c.getId()) != null) {
            throw new IllegalArgumentException("Ya existe una candidata con el mismo ID");
        }
        lista.add(c);

    }
    public boolean eliminarPorId(int id){
      for (int i = 0; i < lista.size(); i++) {
          if (lista.get(i).getId() == id) {
              lista.remove(i);
              return true;
          }
      }
      return false;
    }

    public Candidata buscarporId(int id){
        for (Candidata c : lista) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    public List<Candidata> listar (){
        return new ArrayList<>(lista);
    }

    public List<Candidata> buscarPorNombre(String nombre) {
        List<Candidata> resultado = new ArrayList<>();
        if (nombre == null || nombre.trim().isEmpty()) return resultado;
        String clave = nombre.trim().toLowerCase();
        for (Candidata c : lista) {
            if (c.getNombre() != null && c.getNombre().toLowerCase().contains(clave)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public List<Candidata> filtrarPorTipo(String tipo) {
        List<Candidata> resultado = new ArrayList<>();
        if (tipo == null || tipo.trim().isEmpty()) return resultado;
        String clave = tipo.trim().toLowerCase();
        for (Candidata c : lista) {
            if (c.getTipo() != null && c.getTipo().toLowerCase().equals(clave)) {
                resultado.add(c);
            }
        }
        return resultado;
    }




}
