package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "doacao_id")
    private List<ItemDoacao> itens = new ArrayList<>();

    public Doacao() {
    }

    public Long getId() {
        return id;
    }

    public List<ItemDoacao> getItens() {
        return itens;
    }

    public void adicionarItem(Item item, int quantidade) {
        ItemDoacao itemDoacao = new ItemDoacao(item, quantidade);
        itens.add(itemDoacao);
        itemDoacao.setDoacao(this); // Estabelece o relacionamento bidirecional
    }

    public void removerItem(Item item) {
        itens.removeIf(itemDoacao -> itemDoacao.getItem().equals(item));
    }
}
