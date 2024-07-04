package model;

import java.util.Date;

public class Alimentos extends Item {
    private String unidadeMedida;
    private Date validade;

    public Alimentos(String descricao, int quantidade, String unidadeMedida, Date validade) {
        super(descricao, TipoItem.ALIMENTOS, quantidade);
        this.unidadeMedida = unidadeMedida;
        this.validade = validade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}

