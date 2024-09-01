package ar.com.gestiondeeventos.service.evento.Impl;

import ar.com.gestiondeeventos.domain.Chef;
import ar.com.gestiondeeventos.domain.Evento;
import ar.com.gestiondeeventos.domain.Participante;
import ar.com.gestiondeeventos.service.Participante.ParticipanteService;
import ar.com.gestiondeeventos.service.chef.ChefService;
import ar.com.gestiondeeventos.service.evento.EventoService;
import ar.com.gestiondeeventos.db.DbEvento;

import java.time.LocalDateTime;
import java.util.*;

public class EventoServiceImpl implements EventoService {
    private final ParticipanteService participanteService;
    private final ChefService chefService;
    private DbEvento dbEvento;
    public List<Evento> todosLosEventos= new ArrayList<>();
    public static List<Evento> eventosPasados = new ArrayList<>();

    public EventoServiceImpl(ParticipanteService participanteService, ChefService chefService) {
        this.participanteService = participanteService;
        this.chefService = chefService;
    }


    @Override
    public void crearEvento() {
        Evento nuevoEvento;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del evento: ");
        String nombreEvento = sc.nextLine();

        System.out.println("Ingrese la descripción del evento: ");
        String descripcionEvento = sc.nextLine();

        LocalDateTime fechaYHoraEvento = null;
        while (fechaYHoraEvento == null) {
            System.out.println("Ingrese la fecha y hora del evento (formato: yyyy-MM-ddTHH:mm): ");
            String fechaYHoraInput = sc.nextLine();
            try {
                fechaYHoraEvento = LocalDateTime.parse(fechaYHoraInput);
            } catch (Exception e) {
                System.out.println("Formato incorrecto. Por favor, ingrese la fecha y hora en el formato correcto.");
            }
        }

        System.out.println("Ingrese la dirección del evento: ");
        String direccionEvento = sc.nextLine();


        System.out.println("Ingrese la capacidad máxima del evento: ");
        int capacidadMaximaEvento = sc.nextInt();
        int capacidadActual = 0;


        // verificacion simplificada
        nuevoEvento = new Evento(UUID.randomUUID(), nombreEvento, descripcionEvento, fechaYHoraEvento, direccionEvento, capacidadMaximaEvento, capacidadActual);
        if (nuevoEvento.getNombre() == null || nuevoEvento.getFechaHora() == null) {
            throw new IllegalArgumentException("El nombre del evento y la fecha y hora son obligatorios.");
        }

        todosLosEventos.add(nuevoEvento);
        System.out.println("----------Evento creado con éxito----------");
    }

    @Override
    public boolean verificarCapacidad(UUID idEvento) {
        for (Evento evento : todosLosEventos) {
            if (evento.getId().equals(idEvento)) {
                return evento.getCapacidadActual() < evento.getCapacidadMaxima();
            }
        }
        // si el evento no se encuentra, lanza una excepción
        throw new NoSuchElementException("Evento no encontrado con el ID proporcionado: " + idEvento);
    }

    @Override
    public void gestionarRegistroEInscripcionGeneral(String tipoUsuario) {
        Scanner sc = new Scanner(System.in);
        String respuesta;

        do {
            System.out.println("¿El " + tipoUsuario + " ya está registrado? (si/no)");
            respuesta = sc.nextLine().trim().toLowerCase();

            if ("no".equals(respuesta)) {
                if ("participante".equalsIgnoreCase(tipoUsuario)) {
                    participanteService.registrarParticipante();
                } else if ("chef".equalsIgnoreCase(tipoUsuario)) {
                    chefService.registrarChef();
                }
            } else if ("si".equals(respuesta)) {
                List<Evento> eventosDisponibles = listarEventosDisponibles(LocalDateTime.now());

                if (!eventosDisponibles.isEmpty()) {
                    System.out.println("Ingrese el ID del evento al que desea asignarse:");
                    String idEventoStr = sc.nextLine();
                    UUID idEvento = UUID.fromString(idEventoStr);
                    Evento eventoSeleccionado = null;

                    for (Evento evento : todosLosEventos) {
                        if (evento.getId().equals(idEvento)) {
                            eventoSeleccionado = evento;
                            break;
                        }
                    }

                    if (eventoSeleccionado != null) {
                        System.out.println("Ingrese el ID del " + tipoUsuario + ":");
                        String idUsuarioStr = sc.nextLine();
                        UUID idUsuario = UUID.fromString(idUsuarioStr);

                        if ("participante".equalsIgnoreCase(tipoUsuario)) {
                            Participante participante = participanteService.buscarParticipantePorId(idUsuario);

                            if (participante != null) {
                                participante.getHistorialEventos().add(eventoSeleccionado);
                                eventoSeleccionado.setCapacidadActual(eventoSeleccionado.getCapacidadActual() + 1);
                                System.out.println("Participante inscrito correctamente en el evento: " + eventoSeleccionado.getNombre());
                            } else {
                                System.out.println("Participante no encontrado.");
                            }
                        } else if ("chef".equalsIgnoreCase(tipoUsuario)) {
                            Chef chef = chefService.buscarChefPorId(idUsuario);

                            if (chef != null) {
                                eventoSeleccionado.setChefACargo(chef);
                                chef.getEventosAsistidos().add(eventoSeleccionado);
                                System.out.println("Chef asignado correctamente al evento: " + eventoSeleccionado.getNombre());
                            } else {
                                System.out.println("Chef no encontrado.");
                            }
                        }
                    } else {
                        System.out.println("Evento no encontrado.");
                    }
                }
            } else {
                System.out.println("Respuesta no válida. Por favor, responda con 'si' o 'no'.");
            }
        } while (!"si".equals(respuesta));
    }



    @Override
    public void eliminarEvento(UUID idEvento) {
        Scanner sc = new Scanner(System.in);
        try {
            Evento eventoAEliminar = null;
            for (Evento e : todosLosEventos) {
                if (e.getId().equals(idEvento)) {
                    eventoAEliminar = e;
                    break;
                }
            }

            if (eventoAEliminar != null) {
                System.out.println("¿Está seguro que desea eliminar el evento? si/no " + eventoAEliminar.getNombre());
                String respuesta = sc.nextLine().trim().toLowerCase();

                if ("si".equals(respuesta)) {
                    todosLosEventos.remove(eventoAEliminar);
                    System.out.println("Evento eliminado con el ID: " + idEvento);
                } else {
                    System.out.println("Eliminación cancelada.");
                }
            } else {
                System.out.println("Evento no encontrado con el ID: " + idEvento +"\n");
            }
        } finally {
            sc.close();
        }
    }



    @Override
    public List<Evento> listarEventosDisponibles(LocalDateTime fecha) {
        List<Evento> eventosConCapacidad = new ArrayList<>();

        for (Evento evento : todosLosEventos) {
            try {
                // verifica si el evento tiene capacidad y si la fecha del evento es igual o posterior a la fecha actual
                if (verificarCapacidad(evento.getId()) && !evento.getFechaHora().isBefore(fecha)) {
                    eventosConCapacidad.add(evento);
                }
            } catch (NoSuchElementException e) {
                // manejo de la excepción en caso de que un evento no se encuentre
                System.err.println("Error: " + e.getMessage());
            }
        }

        // mostrar los eventos disponibles
        if (eventosConCapacidad.isEmpty()) {
            System.out.println("No hay eventos disponibles con capacidad a partir de la fecha de hoy.");
        } else {
            for (Evento evento : eventosConCapacidad) {
                System.out.println("----Eventos disponibles a partir de la fecha de hoy----");
                System.out.println("ID: " + evento.getId());
                System.out.println("Nombre: " + evento.getNombre());
                System.out.println("Descripción: " + evento.getDescripcion());
                System.out.println("Fecha y Hora: " + evento.getFechaHora());
                System.out.println("Ubicación: " + evento.getUbicacion());
                System.out.println("Participantes inscriptos al evento: " + evento.getCapacidadActual() +" de "+ evento.getCapacidadMaxima());

                // verificacion para evitar el NullPointerException
                if (evento.getChefACargo() != null) {
                    System.out.println("Chef a Cargo: " + evento.getChefACargo().getNombreYApellido());
                } else {
                    System.out.println("Chef a Cargo: No asignado");
                }

                System.out.println("--------------------------------------");
            }
        }
        return eventosConCapacidad;
    }

    @Override
    public List<Evento> listarEventosPasados(LocalDateTime fecha) {
        // limpia la lista antes de agregar los eventos filtrados
        eventosPasados.clear();

        for (Evento evento : todosLosEventos) {
            try {
                // verifica si la fecha del evento es anterior a la fecha actual
                if (evento.getFechaHora().isBefore(fecha)) {
                    eventosPasados.add(evento);
                }
            } catch (NoSuchElementException e) {
                // manejo de la excepción en caso de que un evento no se encuentre
                System.err.println("Error: " + e.getMessage());
            }
        }

        // mostrar los eventos pasados con el formato solicitado
        if (eventosPasados.isEmpty()) {
            System.out.println("No hay eventos pasados antes de la fecha de hoy.");
        } else {
            for (Evento evento : eventosPasados) {
                System.out.println("----Eventos pasados antes de la fecha de hoy----");
                System.out.println("ID: " + evento.getId());
                System.out.println("Nombre: " + evento.getNombre());
                System.out.println("Descripción: " + evento.getDescripcion());
                System.out.println("Fecha y Hora: " + evento.getFechaHora());
                System.out.println("Ubicación: " + evento.getUbicacion());
                System.out.println("Participantes inscriptos al evento: " + evento.getCapacidadActual());

                // verificacion para evitar el NullPointerException
                if (evento.getChefACargo() != null) {
                    System.out.println("Chef a Cargo: " + evento.getChefACargo().getNombreYApellido());
                } else {
                    System.out.println("Chef a Cargo: No asignado");
                }

                System.out.println("--------------------------------------");
            }
        }
        return eventosPasados;
    }


    @Override
    public String getNombreEventoPorId(UUID idEvento) {
        for (Evento evento : getTodosLosEventos()) {
            if (evento.getId().equals(idEvento)) {
                return evento.getNombre();
            }
        }
        return "Evento no encontrado";
    }


    @Override
    public List<Evento> getTodosLosEventos() {
        return todosLosEventos;
    }

    @Override
    public List<Evento> getEventosPasados() {
        return eventosPasados;
    }

}
