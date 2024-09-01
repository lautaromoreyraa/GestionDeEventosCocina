package ar.com.gestiondeeventos.db;

import ar.com.gestiondeeventos.domain.Evento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DbEvento {

    private static List<Evento> eventoList;

    private static List<Evento> todosLosEventosDB() {
        List<Evento> eventos = new ArrayList<Evento>();
        eventoList.add(new Evento(UUID.randomUUID(), "Locro del 25", "Gran locro 25 de Mayo", LocalDateTime.of(2024,05,25,12,30), "El domo", 75));
        eventoList.add(new Evento(UUID.randomUUID(), "Clase de Cocina", "Clase de cocina gratuita", LocalDateTime.of(2024,06,17,12,30), "Plaza 25 de Mayo", 20));
        eventoList.add(new Evento(UUID.randomUUID(),"Competencia de Cocina", "Competencia de participantes amateurs", LocalDateTime.of(2024,12,15,17,00), "Av. Sarmiento 1100", 10));
        eventoList.add(new Evento(UUID.randomUUID(), "Degustación de platos regionales", "Degustación", LocalDateTime.of(2024,07,10,18,00), "Av Las Heras 175", 35));


        return eventoList;
    }




}
