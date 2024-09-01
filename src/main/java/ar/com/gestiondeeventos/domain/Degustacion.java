package ar.com.gestiondeeventos.domain;


import java.util.List;

public class Degustacion extends Evento {
    private List tipoCocina;
    private int numeroPlatos;
    private List bebidasAcompanamiento;
    private Chef chefInvitado;

    public List getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(List tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public int getNumeroPlatos() {
        return numeroPlatos;
    }

    public void setNumeroPlatos(int numeroPlatos) {
        this.numeroPlatos = numeroPlatos;
    }

    public List getBebidasAcompanamiento() {
        return bebidasAcompanamiento;
    }

    public void setBebidasAcompanamiento(List bebidasAcompanamiento) {
        this.bebidasAcompanamiento = bebidasAcompanamiento;
    }

    public Chef getChefInvitado() {
        return chefInvitado;
    }

    public void setChefInvitado(Chef chefInvitado) {
        this.chefInvitado = chefInvitado;
    }
}
