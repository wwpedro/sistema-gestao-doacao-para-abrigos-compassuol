package model;

import java.util.Map;

public class OrdemPedido {
    private Abrigo abrigo;
    private Map<TipoItem, Integer> itensNecessarios;

    
    public OrdemPedido(Abrigo abrigo, Map<TipoItem, Integer> itensNecessarios) {
        this.abrigo = abrigo;
        this.itensNecessarios = itensNecessarios;
    }

    
    public Abrigo getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(Abrigo abrigo) {
        this.abrigo = abrigo;
    }

    public Map<TipoItem, Integer> getItensNecessarios() {
        return itensNecessarios;
    }

    public void setItensNecessarios(Map<TipoItem, Integer> itensNecessarios) {
        this.itensNecessarios = itensNecessarios;
    }
}

