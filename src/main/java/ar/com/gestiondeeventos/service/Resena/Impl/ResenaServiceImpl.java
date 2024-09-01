package ar.com.gestiondeeventos.service.Resena.Impl;

import ar.com.gestiondeeventos.domain.Evento;
import ar.com.gestiondeeventos.domain.Participante;
import ar.com.gestiondeeventos.domain.Resena;
import ar.com.gestiondeeventos.service.Participante.ParticipanteService;
import ar.com.gestiondeeventos.service.Resena.ResenaService;
import ar.com.gestiondeeventos.service.evento.EventoService;

import java.time.LocalDateTime;
import java.util.*;

public class ResenaServiceImpl implements ResenaService {
    private static List<Resena> resenas = new ArrayList<Resena>();
    private EventoService eventoService;
    private ParticipanteService participanteService;

    public ResenaServiceImpl(EventoService eventoService, ParticipanteService participanteService) {
        this.eventoService = eventoService;
        this.participanteService = participanteService;
    }


    public void crearResena() {
        Scanner sc = new Scanner(System.in);

        // mostrar los eventos disponibles y pedir al usuario que seleccione uno
        System.out.println("Eventos transcurridos donde puede dejar una reseña:");
        List<Evento> eventosPasados = eventoService.listarEventosPasados(LocalDateTime.now());

        if (!eventosPasados.isEmpty()) {
            System.out.println("Ingrese el ID del evento al que desea dejar una reseña:");
            String idEventoStr = sc.nextLine();
            UUID idEvento = UUID.fromString(idEventoStr);
            Evento eventoSeleccionado = null;

            for (Evento evento : eventoService.getEventosPasados()) {
                if (evento.getId().equals(idEvento)) {
                    eventoSeleccionado = evento;
                    break;
                }
            }
            if (eventoSeleccionado != null) {
                System.out.println("Ingrese su ID de participante: ");
                String idUsuarioStr = sc.nextLine();
                UUID idUsuario = UUID.fromString(idUsuarioStr);
                Participante participanteSeleccionado = participanteService.buscarParticipantePorId(idUsuario);

                if (participanteSeleccionado != null) {
                    System.out.print("Ingrese su nombre: ");
                    String nombreParticipante = sc.nextLine();

                    double calificacion = 0;
                    boolean calificacionValida = false;
                    while (!calificacionValida) {
                        try {
                            System.out.print("Ingrese su calificación (1-5): ");
                            calificacion = sc.nextDouble();
                            sc.nextLine();
                            if (calificacion >= 1 && calificacion <= 5) {
                                calificacionValida = true;
                            } else {
                                System.out.println("Calificación inválida. Ingrese un valor entre 1 y 5.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Dato incorrecto. Ingrese un número entero entre 1 y 5.");
                            sc.nextLine();
                        }
                    }

                    System.out.print("Ingrese su comentario: ");
                    String comentario = sc.nextLine();

                    Resena nuevaResena = new Resena(UUID.randomUUID(), eventoSeleccionado, participanteSeleccionado, calificacion, comentario);
                    resenas.add(nuevaResena);

                    System.out.println("¡Reseña creada exitosamente!");
                } else {
                    System.out.println("Participante no encontrado. Por favor, ingrese un ID de participante válido.");
                }
            } else {
                System.out.println("Evento no encontrado. Por favor, ingrese un ID de evento válido.");
            }
        } else {
            System.out.println("No hay eventos pasados disponibles para dejar reseñas.");
        }
    }


    @Override
    public void listarResenas() {
        System.out.println("Lista de reseñas:");
        for (Resena resena : resenas) {
            String nombreParticipante = participanteService.getNombreParticipantePorId(resena.getParticipante().getId());
            String nombreEvento = eventoService.getNombreEventoPorId(resena.getEvento().getId());

            System.out.println("Reseña de: " + nombreParticipante);
            System.out.println("Evento: " + nombreEvento);
            System.out.println("Calificación: " + resena.getCalificacion());
            System.out.println("Comentario: " + resena.getComentario());
            System.out.println();
        }
    }

}

