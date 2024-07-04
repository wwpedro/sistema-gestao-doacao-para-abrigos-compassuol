package model;

import java.util.Map;

public class Pedido {
    private CentroDistribuicao centroDistribuicao;
    private Map<TipoItem, Integer> itensPedidos;
    private boolean aceito;
    private String motivoRecusa;

    
    public Pedido(CentroDistribuicao centroDistribuicao, Map<TipoItem, Integer> itensPedidos) {
        this.centroDistribuicao = centroDistribuicao;
        this.itensPedidos = itensPedidos;
        this.aceito = false;
    }

   
    public void aceitar() {}

    public void recusar() {}

    
    public CentroDistribuicao getCentroDistribuicao() {
        return centroDistribuicao;
    }

    public void setCentroDistribuicao(CentroDistribuicao centroDistribuicao) {
        this.centroDistribuicao = centroDistribuicao;
    }

    public Map<TipoItem, Integer> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(Map<TipoItem, Integer> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }

    public String getMotivoRecusa() {
        return motivoRecusa;
    }

    public void setMotivoRecusa(String motivoRecusa) {
        this.motivoRecusa = motivoRecusa;
    }
}

