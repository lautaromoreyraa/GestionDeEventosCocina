package ar.com.gestiondeeventos.domain;

import ar.com.gestiondeeventos.enumeration.NivelDificultad;

import java.util.List;

public class ClasesCocina extends Evento {
    private Enum <NivelDificultad> nivelDificultad;
    private String duracion;
    private String tematica;
    private List materialesNecesarios;

    public Enum<NivelDificultad> getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(Enum<NivelDificultad> nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public List getMaterialesNecesarios() {
        return materialesNecesarios;
    }

    public void setMaterialesNecesarios(List materialesNecesarios) {
        this.materialesNecesarios = materialesNecesarios;
    }
}
