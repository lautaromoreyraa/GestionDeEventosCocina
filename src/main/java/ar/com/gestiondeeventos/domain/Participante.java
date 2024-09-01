package ar.com.gestiondeeventos.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id;
    private String nombreYApellido;
    private String interesesCulinarios;
    private List<Evento> historialEventos;

    public Participante() {
        this.historialEventos = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getInteresesCulinarios() {
        return interesesCulinarios;
    }

    public void setInteresesCulinarios(String interesesCulinarios) {
        this.interesesCulinarios = interesesCulinarios;
    }

    public List<Evento> getHistorialEventos() {
        return historialEventos;
    }

    public void setHistorialEventos(List<Evento> historialEventos) {
        this.historialEventos = historialEventos;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre y Apellido: " + nombreYApellido + ", Interés Culinario: " + interesesCulinarios;
    }
}

