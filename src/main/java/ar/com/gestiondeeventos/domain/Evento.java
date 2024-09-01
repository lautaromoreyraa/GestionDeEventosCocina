package ar.com.gestiondeeventos.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private int capacidadMaxima;
    private int capacidadActual;
    private Chef chefACargo;
    private List<Participante> participantes = new ArrayList<>();

    public Evento(UUID id, String nombre, String descripcion, LocalDateTime fechaHora, String ubicacion, int capacidadMaxima, int capacidadActual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Chef getChefACargo() {
        return chefACargo;
    }

    public void setChefACargo(Chef chefACargo) {
        this.chefACargo = chefACargo;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
