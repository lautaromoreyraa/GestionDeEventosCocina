package ar.com.gestiondeeventos.domain;

import java.util.UUID;

public class Resena {
    private UUID id;
    private Evento Evento;
    private Participante participante;
    private Double calificacion;
    private String comentario;

    public Resena(UUID id, Evento evento, Participante participante, Double calificacion, String comentario) {
        this.id = id;
        this.Evento = evento;
        this.participante = participante;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return Evento;
    }

    public void setEvento(Evento idEvento) {
        this.Evento = Evento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
