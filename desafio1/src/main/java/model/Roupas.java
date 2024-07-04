package model;

public class Roupas extends Item {
    private Genero genero;
    private TamanhoRoupa tamanho;

    public Roupas(String descricao, int quantidade, Genero genero, TamanhoRoupa tamanho) {
        super(descricao, TipoItem.ROUPAS, quantidade);
        this.genero = genero;
        this.tamanho = tamanho;
    }

    
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TamanhoRoupa getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoRoupa tamanho) {
        this.tamanho = tamanho;
    }
}

