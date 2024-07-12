package entities;

public class ProdutoHigiene extends Item {
    private TipoProdutoHigiene tipoProduto;

    public ProdutoHigiene(String descricao, TipoProdutoHigiene tipoProduto) {
        super(descricao);
        this.tipoProduto = tipoProduto;
    }

    public TipoProdutoHigiene getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProdutoHigiene tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public String toString() {
        return "ProdutoHigiene [descricao=" + getDescricao() + ", tipoProduto=" + tipoProduto + "]";
    }
}
