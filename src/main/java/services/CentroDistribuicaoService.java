package services;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import entities.CentroDistribuicao;

public class CentroDistribuicaoService {
    private EntityManager em;

    public CentroDistribuicaoService(EntityManager em) {
        this.em = em;
    }

    public void registrarCentroDistribuicao(CentroDistribuicao centro) {
        em.getTransaction().begin();
        em.persist(centro);
        em.getTransaction().commit();
    }

    public List<CentroDistribuicao> listarCentros() {
        TypedQuery<CentroDistribuicao> query = em.createQuery("FROM CentroDistribuicao", CentroDistribuicao.class);
        return query.getResultList();
    }

    public Optional<CentroDistribuicao> encontrarCentroDistribuicaoPorNome(String nome) {
        TypedQuery<CentroDistribuicao> query = em.createQuery("FROM CentroDistribuicao c WHERE c.nome = :nome", CentroDistribuicao.class);
        query.setParameter("nome", nome);
        return query.getResultList().stream().findFirst();
    }

    public void editarCentroDistribuicao(String nome, CentroDistribuicao centroAtualizado) {
        em.getTransaction().begin();
        CentroDistribuicao centro = encontrarCentroDistribuicaoPorNome(nome).orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));
        centro.setNome(centroAtualizado.getNome());
        centro.setEndereco(centroAtualizado.getEndereco());
        centro.setTelefone(centroAtualizado.getTelefone());
        em.getTransaction().commit();
    }

    public void deletarCentroDistribuicao(String nome) {
        em.getTransaction().begin();
        CentroDistribuicao centro = encontrarCentroDistribuicaoPorNome(nome).orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));
        em.remove(centro);
        em.getTransaction().commit();
    }
}
