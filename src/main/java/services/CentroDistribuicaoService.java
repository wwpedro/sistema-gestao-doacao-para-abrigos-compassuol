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

    public Optional<CentroDistribuicao> encontrarCentroDistribuicaoPorID(Long id) {
        TypedQuery<CentroDistribuicao> query = em.createQuery("FROM CentroDistribuicao c WHERE c.id = :id", CentroDistribuicao.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }

    public void editarCentroDistribuicao(Long id, CentroDistribuicao centroAtualizado) {
        em.getTransaction().begin();
        CentroDistribuicao centro = encontrarCentroDistribuicaoPorID(id).orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));
        centro.setNome(centroAtualizado.getNome());
        centro.setEndereco(centroAtualizado.getEndereco());
        centro.setTelefone(centroAtualizado.getTelefone());
        em.getTransaction().commit();
    }

    public void deletarCentroDistribuicao(Long id) {
        em.getTransaction().begin();
		CentroDistribuicao centro = encontrarCentroDistribuicaoPorID(id).orElseThrow(() -> new IllegalArgumentException("Centro não encontrado"));
        em.remove(centro);
        em.getTransaction().commit();
    }
}
