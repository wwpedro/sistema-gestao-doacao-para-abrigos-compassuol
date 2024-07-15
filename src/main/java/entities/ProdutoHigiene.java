package entities;

import javax.persistence.Entity;

@Entity
public class ProdutoHigiene extends Item {
    private TipoProdutoHigiene tipo;

    // Construtor padrão
    public ProdutoHigiene() {
        super(); // Chamando o construtor padrão da superclasse
    }

    // Construtor com argumentos
    public ProdutoHigiene(String descricao, TipoProdutoHigiene tipo) {
        super(descricao); // Chamando o construtor com argumentos da superclasse
        this.tipo = tipo;
    }

    // Getters e setters
    public TipoProdutoHigiene getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdutoHigiene tipo) {
        this.tipo = tipo;
    }
}
