package ar.com.gestiondeeventos.service.Evento;
import ar.com.gestiondeeventos.domain.Evento;

import java.time.LocalDate;
import java.util.List;

public interface EventoService {
    void crearEvento(Evento evento);
    void editarEvento(Evento evento);
    void eliminarEvento(Evento evento);
    List<Evento> listarEventosDisponibles(LocalDate fecha);
    boolean esEventoCompleto(Evento evento);
    List<Evento> exportarEventosCompletos(LocalDate fecha);
}
