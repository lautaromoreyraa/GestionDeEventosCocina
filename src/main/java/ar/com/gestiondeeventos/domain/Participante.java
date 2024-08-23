package ar.com.gestiondeeventos.domain;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id;
    private String nombre;
    private List<String> interesesCulinarios;
    private List<Evento> historialEventos;

    public Participante(UUID id, String nombre, List<String> interesesCulinarios, List<Evento> historialEventos) {
        this.id = id;
        this.nombre = nombre;
        this.interesesCulinarios = interesesCulinarios;
        this.historialEventos = historialEventos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getInteresesCulinarios() {
        return interesesCulinarios;
    }

    public void setInteresesCulinarios(List<String> interesesCulinarios) {
        this.interesesCulinarios = interesesCulinarios;
    }

    public List<Evento> getHistorialEventos() {
        return historialEventos;
    }

    public void setHistorialEventos(List<Evento> historialEventos) {
        this.historialEventos = historialEventos;
    }
}
