package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Alimento extends Item {
    private int quantidade;
    @Enumerated(EnumType.STRING)
    private UnidadeMedidaAlimento unidadeMedida;
    private LocalDate validade;
    
    public Alimento() {}
    
    public Alimento(String descricao, int quantidade, UnidadeMedidaAlimento unidadeMedida, LocalDate validade) {
        super(descricao);
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeMedidaAlimento getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedidaAlimento unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Alimento [descricao=" + getDescricao() + ", quantidade=" + quantidade + ", unidadeMedida=" + unidadeMedida + ", validade=" + validade + "]";
    }
}
