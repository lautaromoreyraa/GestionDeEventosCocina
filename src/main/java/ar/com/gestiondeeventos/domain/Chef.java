package ar.com.gestiondeeventos.domain;

import java.util.List;
import java.util.UUID;

public class Chef {
    private UUID id;
    private String nombreYApellido;
    private String especialidad;
    private List<Evento> eventosAsistidos;

    public Chef(UUID id, String nombre, List<String> especialidades, List<Evento> eventosAsistidos) {
        this.id = id;
        this.nombreYApellido = nombreYApellido;
        this.especialidad = especialidad;
        this.eventosAsistidos = eventosAsistidos;
    }

    public Chef(){
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

    public void setNombreYApellido(String nombre) {
        this.nombreYApellido = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Evento> getEventosAsistidos() {
        return eventosAsistidos;
    }

    public void setEventosAsistidos(List<Evento> eventosAsistidos) {
        this.eventosAsistidos = eventosAsistidos;
    }
}
