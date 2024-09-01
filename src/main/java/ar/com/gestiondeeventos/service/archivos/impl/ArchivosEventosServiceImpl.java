package ar.com.gestiondeeventos.service.archivos.impl;

import ar.com.gestiondeeventos.domain.Evento;
import ar.com.gestiondeeventos.service.archivos.ArchivosEventosService;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ArchivosEventosServiceImpl implements ArchivosEventosService {

    CSVWriter csvWriter;

    @Override
    public void exportarEventosCsv(List<Evento> eventos) {

        String UBICACION_ARCHIVO = "gestiondeeventos-project\\src\\main\\java\\ar\\com\\gestiondeeventos\\recursos\\";
        String ruta = System.getProperty("user.dir") + File.separator + UBICACION_ARCHIVO + "NombreDelArchivo.csv";

        try {
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            // crear encabezado
            String[] encabezado = {"ID", "NOMBRE", "DESCRIPCION", "FECHA" , "CAPACIDAD MÁXIMA", "PARTICIPANTES INSCRITOS"};
            this.csvWriter.writeNext(encabezado);
            LocalDateTime fecha = LocalDate.now().atStartOfDay();

            for (Evento evento : eventos) {
                if (evento.getFechaHora().isBefore(fecha) && evento.getCapacidadMaxima() == evento.getCapacidadActual()) {
                    String[] datos = {
                            evento.getId().toString(),
                            evento.getNombre(),
                            evento.getDescripcion(),
                            evento.getFechaHora().toString(),
                            String.valueOf(evento.getCapacidadMaxima()),
                            String.valueOf(evento.getCapacidadActual())
                    };
                    this.csvWriter.writeNext(datos);
                }
            }
            System.out.println("Exportando csv del archivo en "+ ruta);
            System.out.println("Exportación exitosa");

        } catch (IOException e) {
            System.out.println("Algo salió mal. Motivo: " + e.getMessage().concat(" Ubicación del archivo: " + ruta));
        }
    }

    @Override
    public void cerrarWriter() {
        if (this.csvWriter != null) {
            try {
                this.csvWriter.close();
            } catch (IOException e) {
                System.out.println("Algo salió mal. Motivo: " + e.getMessage());
            }
        }
    }
}
