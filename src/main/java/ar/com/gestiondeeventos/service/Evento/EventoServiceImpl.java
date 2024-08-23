package ar.com.gestiondeeventos.service.Evento;

import ar.com.gestiondeeventos.domain.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoServiceImpl implements EventoService{
    private List<Evento> eventos = new ArrayList<Evento>();

    @Override
    public void crearEvento(Evento evento) {
    if (evento == null || evento.getNombre() == null || evento.getFechaHora() == null) {
        throw new IllegalArgumentException("El evento o los datos son nulos");
        }
        eventos.add(evento);
    }

    @Override
    public void editarEvento(Evento evento) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getId().equals(evento.getId())) {
                eventos.set(i, evento);
                break;
            }
        }
    }

    @Override
    public void eliminarEvento(Evento evento) {
        Evento eventoAEliminar = null;
        for (Evento e : eventos){
            if (e.getId().equals(evento.getId())) {
                eventoAEliminar = e;
                break;
            }
        }
        if (eventoAEliminar != null) {
            eventos.remove(eventoAEliminar);
        }
    }

    @Override
    public List<Evento> listarEventosDisponibles(LocalDate fecha) {
        List<Evento> eventosDisponibles = new ArrayList<>();
        for (Evento evento : eventos){
            if (evento.getFechaHora().isAfter(fecha.atStartOfDay()) && !esEventoCompleto(evento)){
                eventosDisponibles.add(evento);
            }
        }
        return eventosDisponibles;
    }

    @Override
    public boolean esEventoCompleto(Evento evento) {
        return evento.getCapacidad() == 0;
    }

    @Override
    public List<Evento> exportarEventosCompletos(LocalDate fecha) {
        List <Evento> eventosCompletos = new ArrayList<>();
        for (Evento evento : eventos){
            if (evento.getFechaHora().isAfter(fecha.atStartOfDay()) && !esEventoCompleto(evento)){
                eventosCompletos.add(evento);
            }
        }
        return eventosCompletos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

}
