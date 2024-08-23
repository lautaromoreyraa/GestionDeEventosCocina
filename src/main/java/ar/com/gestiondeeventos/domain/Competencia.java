package ar.com.gestiondeeventos.domain;

import ar.com.gestiondeeventos.enumeration.NivelParticipantes;

import java.util.List;

public class Competencia extends EventoGastronomico {
    private String premios;
    private int numeroJueces;
    private List criteriosEvaluacion;
    private int tiempoLimite;
    private Enum<NivelParticipantes> nivelParticipantes;

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public int getNumeroJueces() {
        return numeroJueces;
    }

    public void setNumeroJueces(int numeroJueces) {
        this.numeroJueces = numeroJueces;
    }

    public List getCriteriosEvaluacion() {
        return criteriosEvaluacion;
    }

    public void setCriteriosEvaluacion(List criteriosEvaluacion) {
        this.criteriosEvaluacion = criteriosEvaluacion;
    }

    public int getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(int tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public Enum<NivelParticipantes> getNivelParticipantes() {
        return nivelParticipantes;
    }

    public void setNivelParticipantes(Enum<NivelParticipantes> nivelParticipantes) {
        this.nivelParticipantes = nivelParticipantes;
    }
}
