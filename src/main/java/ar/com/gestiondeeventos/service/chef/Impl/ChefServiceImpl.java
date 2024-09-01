package ar.com.gestiondeeventos.service.chef.Impl;

import ar.com.gestiondeeventos.domain.Chef;
import ar.com.gestiondeeventos.service.chef.ChefService;

import java.util.*;

public class ChefServiceImpl implements ChefService {
    private static List<Chef> todosLosChef = new ArrayList<>();

    @Override
    public void registrarChef() {
        Chef nuevoChef = new Chef();
        Scanner sc = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        nuevoChef.setId(id);

        System.out.println("Ingrese el nombre y apellido del Chef: ");
        String nombreChef = sc.nextLine();
        nuevoChef.setNombreYApellido(nombreChef);

        System.out.println("Ingrese la especialidad del chef: ");
        String especialidad = sc.nextLine();
        nuevoChef.setEspecialidad(especialidad);

        nuevoChef.setEventosAsistidos(new ArrayList<>());

        todosLosChef.add(nuevoChef);

        System.out.println("El Chef se encuentra registrado bajo el id: " + nuevoChef.getId() +"\n");
    }


    @Override
    public List<String> listarChefs() {
        List<String> listaDetalles = new ArrayList<>();

        if (todosLosChef.isEmpty()) {
            System.out.println("No hay Chefs registrados.");
        } else {
            System.out.println("----Lista de Chefs----");
            for (Chef chef : todosLosChef) {
                StringBuilder detalles = new StringBuilder();
                detalles.append("ID: ").append(chef.getId()).append("\n");
                detalles.append("Nombre y Apellido: ").append(chef.getNombreYApellido()).append("\n");
                detalles.append("Especialidad del chef: ").append(chef.getEspecialidad()).append("\n");
                detalles.append("--------------------------------------");
                listaDetalles.add(detalles.toString());
                System.out.println(detalles);
            }
        }
        return listaDetalles;
    }

    @Override
    public List<Chef> getTodosLosChef() {
        return this.todosLosChef;
    }

    @Override
    public Chef buscarChefPorId(UUID id) {
        for (Chef c : getTodosLosChef()) {
            if (c.getId().equals(id)) {
                return c;
            }else System.out.println("Chef no coincide con ID: " + c.getId());
        }
        return null;
    }
}



