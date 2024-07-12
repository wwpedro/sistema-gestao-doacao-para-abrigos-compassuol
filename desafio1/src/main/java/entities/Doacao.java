package entities;

import java.util.HashMap;
import java.util.Map;

public class Doacao {
    private Map<Item, Integer> itens;

    public Doacao() {
        this.itens = new HashMap<>();
    }

    public Map<Item, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Item, Integer> itens) {
        this.itens = itens;
    }
}
