package entities;

public abstract class Item {
    private String descricao;

    public Item(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Item [descrição=" + descricao + "]";
    }
}

