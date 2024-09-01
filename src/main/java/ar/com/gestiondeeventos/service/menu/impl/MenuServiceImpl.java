package ar.com.gestiondeeventos.service.menu.impl;

import ar.com.gestiondeeventos.domain.Evento;
import ar.com.gestiondeeventos.service.Participante.ParticipanteService;
import ar.com.gestiondeeventos.service.Resena.Impl.ResenaServiceImpl;
import ar.com.gestiondeeventos.service.Resena.ResenaService;
import ar.com.gestiondeeventos.service.evento.EventoService;
import ar.com.gestiondeeventos.service.menu.MenuService;
import ar.com.gestiondeeventos.service.chef.ChefService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuServiceImpl implements MenuService {
    private EventoService eventoService;
    private ParticipanteService participanteService;
    private ChefService chefService;
    private ResenaService resenaService;

    public MenuServiceImpl(EventoService eventoService, ParticipanteService participanteService, ChefService chefService, ResenaService resenaService) {
        this.eventoService = eventoService;
        this.participanteService = participanteService;
        this.chefService = chefService;
        this.resenaService = resenaService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Bienvenido al Sistema de Gestión de Eventos de Cocina y Gastronomía");
            System.out.println("Ingrese una opcion: \n");
            System.out.println("1. Crear evento");
            System.out.println("2. Eliminar evento");
            System.out.println("3. Listar eventos disponibles a partir de hoy");
            System.out.println("4. Registrar participante");
            System.out.println("5. Inscribir participante a un evento");
            System.out.println("6. Listar todos los participantes");
            System.out.println("7. Registrar chef");
            System.out.println("8. Asignar Chef a un evento");
            System.out.println("9. Listar todos los chefs");
            System.out.println("10. Dejar una reseña sobre un evento");
            System.out.println("11. Listar reseñas");
            System.out.println("12. Exportar archivo csv de eventos con capacidad máxima");
            System.out.println("13. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    eventoService.crearEvento();
                    break;
                case 2:
                    System.out.println("Ingrese el ID del evento que desea eliminar: ");
                    String id = scanner.nextLine();
                    eventoService.eliminarEvento(UUID.fromString(id));
                    break;
                case 3:
                    LocalDateTime fechaHoy = LocalDateTime.now();
                    List<Evento> eventosDisponibles = eventoService.listarEventosDisponibles(fechaHoy);
                    break;
                case 4:
                    participanteService.registrarParticipante();
                    break;
                case 5:
                    eventoService.gestionarRegistroEInscripcionGeneral("participante");
                    break;
                case 6:
                    participanteService.listarParticipantes();
                    break;
                case 7:
                    chefService.registrarChef();
                    break;
                case 8:
                    eventoService.gestionarRegistroEInscripcionGeneral("chef");
                    break;
                case 9:
                    chefService.listarChefs();
                    break;
                case 10:
                    resenaService.crearResena();
                    break;
                case 11:
                    resenaService.listarResenas();
                    break;
                case 12:
                    break;
                case 13:
                    break;
            }
        } while (opcion != 13);
    }
}

