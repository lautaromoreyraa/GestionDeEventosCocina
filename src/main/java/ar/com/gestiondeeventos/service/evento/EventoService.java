package ar.com.gestiondeeventos.service.evento;

import ar.com.gestiondeeventos.domain.Evento;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public interface EventoService {
    void crearEvento();
    boolean verificarCapacidad(UUID idEvento);
    void gestionarRegistroEInscripcionGeneral(String tipoUsuario);
    void registrarUsuarios(String tipoUsuario);
    void inscribirParticipanteEnEvento(String tipoUsuario, Scanner sc);
    Evento seleccionarEvento(Scanner sc, List<Evento> eventosDisponibles);
    UUID obtenerIdParticipante(Scanner sc, String tipoUsuario);
    void anotarParticipante(Evento evento, UUID idUsuario);
    void asignarChefEvento(Evento evento, UUID idUsuario);
    void eliminarEvento(UUID idEvento);
    List<Evento> listarEventosDisponibles(LocalDateTime fecha);
    List<Evento> listarEventosPasados(LocalDateTime fecha);
    String getNombreEventoPorId(UUID idEvento);
    List<Evento> getTodosLosEventos();
    List<Evento> getEventosPasados();
}
