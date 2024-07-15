package entities;

import javax.persistence.*;

@Entity
public class ItemDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Doacao doacao;

    @ManyToOne
    private Item item;

    private int quantidade;

    public ItemDoacao() {
    }

    public ItemDoacao(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
