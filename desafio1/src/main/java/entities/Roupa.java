package entities;

public class Roupa extends Item {
    private RoupaGenero genero;
    private RoupaTamanho tamanho;

    public Roupa(String descricao, RoupaGenero genero, RoupaTamanho tamanho) {
        super(descricao);
        this.genero = genero;
        this.tamanho = tamanho;
    }

    public RoupaGenero getGenero() {
        return genero;
    }

    public void setGenero(RoupaGenero genero) {
        this.genero = genero;
    }

    public RoupaTamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(RoupaTamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Roupa [descricao=" + getDescricao() + ", genero=" + genero + ", tamanho=" + tamanho + "]";
    }
}
