package model;

import java.util.HashMap;
import java.util.Map;

public class Abrigo {
    private String nome;
    private String endereco;
    private String responsavel;
    private String telefone;
    private String email;
    private int capacidade;
    private int ocupacao; // Em porcentagem
    private Map<TipoItem, Integer> itensRecebidos;

    public Abrigo(String nome, String endereco, String responsavel, String telefone, String email, int capacidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.email = email;
        this.capacidade = capacidade;
        this.ocupacao = 0;
        this.itensRecebidos = new HashMap<>();
    }

    public void receberItem() {}


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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Map<TipoItem, Integer> getItensRecebidos() {
        return itensRecebidos;
    }

    public void setItensRecebidos(Map<TipoItem, Integer> itensRecebidos) {
        this.itensRecebidos = itensRecebidos;
    }
}

