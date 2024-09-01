package ar.com.gestiondeeventos.service.Participante;

import ar.com.gestiondeeventos.domain.Evento;
import ar.com.gestiondeeventos.domain.Participante;
import java.util.List;
import java.util.UUID;

public interface ParticipanteService {
    void registrarParticipante();
    List<Evento> obtenerHistorialEventos(Participante participante);
    List<Participante> getTodosLosParticipantes();
    List <String> listarParticipantes();
    Participante buscarParticipantePorId(UUID id);
    String getNombreParticipantePorId(UUID idParticipante);
}
