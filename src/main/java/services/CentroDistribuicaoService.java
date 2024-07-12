package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entities.CentroDistribuicao;

public class CentroDistribuicaoService {
    private List<CentroDistribuicao> centros = new ArrayList<>();
    
    public void registrarCentroDistribuicao(CentroDistribuicao centro) {
        centros.add(centro);
    }
    
    public List<CentroDistribuicao> listarCentros() {
        return centros;
    }
    
    public Optional<CentroDistribuicao> encontrarCentroDistribuicaoPorNome(String nome) {
        return centros.stream().filter(c -> c.getNome().equals(nome)).findFirst();
    }
    
    public void editarCentroDistribuicao(String nome, CentroDistribuicao centroAtualizado) {
        encontrarCentroDistribuicaoPorNome(nome).ifPresent(centro -> {
            if (centroAtualizado.getNome() != null && !centroAtualizado.getNome().isEmpty()) {
                centro.setNome(centroAtualizado.getNome());
            }
            if (centroAtualizado.getEndereco() != null && !centroAtualizado.getEndereco().isEmpty()) {
                centro.setEndereco(centroAtualizado.getEndereco());
            }
            if (centroAtualizado.getTelefone() != null && !centroAtualizado.getTelefone().isEmpty()) {
                centro.setTelefone(centroAtualizado.getTelefone());
            }
        });
    }
    
    public void deletarCentroDistribuicao(String nome) {
        centros.removeIf(centro -> centro.getNome().equals(nome));
    }
}
