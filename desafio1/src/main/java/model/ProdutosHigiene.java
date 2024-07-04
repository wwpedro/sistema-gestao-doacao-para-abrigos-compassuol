package model;

public class ProdutosHigiene extends Item {
    public ProdutosHigiene(String descricao, int quantidade) {
        super(descricao, TipoItem.PRODUTOS_HIGIENE, quantidade);
    }
}

