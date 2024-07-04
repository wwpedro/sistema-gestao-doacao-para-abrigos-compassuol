package model;

public abstract class Item {
    private String descricao;
    private TipoItem tipo;
    private int quantidade;
    
    
    public Item() {}
    
    public Item(String descricao, TipoItem tipo, int quantidade) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
