package ar.com.gestiondeeventos;


import ar.com.gestiondeeventos.service.Participante.ParticipanteService;
import ar.com.gestiondeeventos.service.Participante.Impl.ParticipanteServiceImpl;
import ar.com.gestiondeeventos.service.Resena.Impl.ResenaServiceImpl;
import ar.com.gestiondeeventos.service.Resena.ResenaService;
import ar.com.gestiondeeventos.service.archivos.impl.ArchivosEventosServiceImpl;
import ar.com.gestiondeeventos.service.archivos.ArchivosEventosService;
import ar.com.gestiondeeventos.service.evento.EventoService;
import ar.com.gestiondeeventos.service.evento.Impl.EventoServiceImpl;
import ar.com.gestiondeeventos.service.menu.MenuService;
import ar.com.gestiondeeventos.service.menu.impl.MenuServiceImpl;
import ar.com.gestiondeeventos.service.chef.ChefService;
import ar.com.gestiondeeventos.service.chef.Impl.ChefServiceImpl;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ParticipanteService participanteService = new ParticipanteServiceImpl();
        ChefService chefService = new ChefServiceImpl();
        EventoService eventoService = new EventoServiceImpl(participanteService, chefService);
        ResenaService resenaService = new ResenaServiceImpl(eventoService, participanteService);
        ArchivosEventosService archivosEventosService = new ArchivosEventosServiceImpl();

        MenuService menuService = new MenuServiceImpl(eventoService, participanteService, chefService, resenaService, archivosEventosService);

        Scanner scanner = new Scanner(System.in);
        menuService.mostrarMenu(scanner);
        scanner.close();
        archivosEventosService.cerrarWriter();
    }
}

