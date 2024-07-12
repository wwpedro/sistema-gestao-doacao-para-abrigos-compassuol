package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entities.Abrigo;

public class AbrigoService {
    private List<Abrigo> abrigos = new ArrayList<>();
    
    public void registrarAbrigo(Abrigo abrigo) {
        abrigos.add(abrigo);
    }
    
    public List<Abrigo> listarAbrigos() {
        return abrigos;
    }
    
    public Optional<Abrigo> encontrarAbrigoPorNome(String nome) {
        return abrigos.stream().filter(a -> a.getNome().equals(nome)).findFirst();
    }
    
    public void editarAbrigo(String nome, Abrigo abrigoAtualizado) {
        encontrarAbrigoPorNome(nome).ifPresent(abrigo -> {
            if (abrigoAtualizado.getEndereco() != null && !abrigoAtualizado.getEndereco().isEmpty()) {
                abrigo.setEndereco(abrigoAtualizado.getEndereco());
            }
            if (abrigoAtualizado.getResponsavel() != null && !abrigoAtualizado.getResponsavel().isEmpty()) {
                abrigo.setResponsavel(abrigoAtualizado.getResponsavel());
            }
            if (abrigoAtualizado.getTelefone() != null && !abrigoAtualizado.getTelefone().isEmpty()) {
                abrigo.setTelefone(abrigoAtualizado.getTelefone());
            }
            if (abrigoAtualizado.getEmail() != null && !abrigoAtualizado.getEmail().isEmpty()) {
                abrigo.setEmail(abrigoAtualizado.getEmail());
            }
            if (abrigoAtualizado.getCapacidade() > 0) {
                abrigo.setCapacidade(abrigoAtualizado.getCapacidade());
            }
        });
    }
    
    public void deletarAbrigo(String nome) {
        abrigos.removeIf(abrigo -> abrigo.getNome().equals(nome));
    }
}

