package entities;

import javax.persistence.Entity;

@Entity
public class Roupa extends Item {
    private RoupaGenero genero;
    private RoupaTamanho tamanho;

    // Construtor padrão
    public Roupa() {
        super(); // Chamando o construtor padrão da superclasse
    }

    // Construtor com argumentos
    public Roupa(String descricao, RoupaGenero genero, RoupaTamanho tamanho) {
        super(descricao); // Chamando o construtor com argumentos da superclasse
        this.genero = genero;
        this.tamanho = tamanho;
    }

    // Getters e setters
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
}
