package model;

import java.util.HashMap;
import java.util.Map;

public class CentroDistribuicao {
    private String nome;
    private String endereco;
    private Map<TipoItem, Integer> estoque;

    public CentroDistribuicao(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.estoque = new HashMap<>();
    }

    
    public void adicionarItem() {}

    public void removerItem() {}

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Map<TipoItem, Integer> getEstoque() {
        return estoque;
    }

    public void setEstoque(Map<TipoItem, Integer> estoque) {
        this.estoque = estoque;
    }
}
