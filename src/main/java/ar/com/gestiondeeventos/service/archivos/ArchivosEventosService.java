package ar.com.gestiondeeventos.service.archivos;

import ar.com.gestiondeeventos.domain.Evento;

import java.time.LocalDate;
import java.util.List;

public interface ArchivosEventosService {
    void exportarEventosCsv(List<Evento> eventos);
    void cerrarWriter();
}
