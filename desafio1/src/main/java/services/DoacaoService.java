package services;

import entities.Doacao;
import entities.Item;

import java.util.Map;
import java.util.Optional;

public class DoacaoService {
    private Doacao doacao;

    public DoacaoService() {
        this.doacao = new Doacao();
    }

    public void adicionarItem(Item item, int quantidade) {
        Map<Item, Integer> itens = doacao.getItens();
        itens.put(item, itens.getOrDefault(item, 0) + quantidade);
    }

    public void removerItem(Item item) {
        doacao.getItens().remove(item);
    }

    public void editarQuantidadeItem(Item item, int novaQuantidade) {
        if (doacao.getItens().containsKey(item)) {
            doacao.getItens().put(item, novaQuantidade);
        }
    }

    public Optional<Map.Entry<Item, Integer>> encontrarItemPorDescricao(String descricao) {
        return doacao.getItens().entrySet().stream()
                .filter(entry -> entry.getKey().getDescricao().equalsIgnoreCase(descricao))
                .findFirst();
    }

    public void listarItens() {
        doacao.getItens().forEach((item, quantidade) -> {
            System.out.println("Item: " + item + ", Quantidade: " + quantidade);
        });
    }
}
