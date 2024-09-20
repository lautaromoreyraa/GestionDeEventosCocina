package ar.com.gestiondeeventos.service.Participante.Impl;

import ar.com.gestiondeeventos.domain.Evento;
import ar.com.gestiondeeventos.domain.Participante;
import ar.com.gestiondeeventos.service.Participante.ParticipanteService;
import java.util.*;

public class ParticipanteServiceImpl implements ParticipanteService {
    private static List<Participante> todosLosParticipantes = new ArrayList<>();


    public ParticipanteServiceImpl() {
    }

    @Override
    public void registrarParticipante() {
        Participante nuevoParticipante = new Participante();
        Scanner sc = new Scanner(System.in);
        UUID id = UUID.randomUUID();
        nuevoParticipante.setId(id);

        System.out.println("Ingrese el nombre y apellido del participante: ");
        String nombreParticipante = sc.nextLine();
        nuevoParticipante.setNombreYApellido(nombreParticipante);

        System.out.println("Ingrese los intereses culinarios del participante: ");
        String interesesDelParticipante = (sc.nextLine());
        nuevoParticipante.setInteresesCulinarios(interesesDelParticipante);

        todosLosParticipantes.add(nuevoParticipante);
        System.out.println("El participante se encuentra registrado bajo el id: " + nuevoParticipante.getId() +"\n");
    }

    @Override
    public List<Evento> obtenerHistorialEventos(Participante participante) {
        return participante.getHistorialEventos();
    }

    @Override
    public List<Participante> getTodosLosParticipantes() {
        System.out.println("Lista de participantes: " + todosLosParticipantes);
        return todosLosParticipantes;
    }

    @Override
    public List<String> listarParticipantes() {
        List<String> listaDetalles = new ArrayList<>();

        if (todosLosParticipantes.isEmpty()) {
            System.out.println("No hay participantes registrados.");
        } else {
            System.out.println("----Lista de Participantes----");
            for (Participante participante : todosLosParticipantes) {
                StringBuilder detalles = new StringBuilder();
                detalles.append("ID: ").append(participante.getId()).append("\n");
                detalles.append("Nombre y Apellido: ").append(participante.getNombreYApellido()).append("\n");
                detalles.append("Interés Culinario: ").append(participante.getInteresesCulinarios()).append("\n");
                detalles.append("--------------------------------------");
                listaDetalles.add(detalles.toString());
                System.out.println(detalles);
            }
        }
        return listaDetalles;
    }

    @Override
    public Participante buscarParticipantePorId(UUID id) {
        for (Participante p : todosLosParticipantes) {
            if (p.getId().equals(id)) {
                System.out.println("Participante encontrado con ID: " + p.getId());
                return p;
            }else System.out.println("Participante no coincide con ID: " + p.getId());
        }
        return null;
    }

    @Override
    public String getNombreParticipantePorId(UUID idParticipante) {
        Participante participante = buscarParticipantePorId(idParticipante);
        if (participante != null) {
            return participante.getNombreYApellido();
        }
        return "Participante no encontrado";
    }

}
