package services;

import entities.Abrigo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AbrigoService {
    private EntityManager em;

    public AbrigoService(EntityManager em) {
        this.em = em;
    }

    public void registrarAbrigo(Abrigo abrigo) {
        em.getTransaction().begin();
        em.persist(abrigo);
        em.getTransaction().commit();
    }

    public List<Abrigo> listarAbrigos() {
        TypedQuery<Abrigo> query = em.createQuery("FROM Abrigo", Abrigo.class);
        return query.getResultList();
    }

    public Optional<Abrigo> encontrarAbrigoPorID(Long id) {
    	
        TypedQuery<Abrigo> query = em.createQuery("FROM Abrigo a WHERE a.id = :id", Abrigo.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findFirst();
    }
    public void editarAbrigo(Long id, Abrigo abrigoAtualizado) {
        em.getTransaction().begin();
        Abrigo abrigo = encontrarAbrigoPorID(id).orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
        abrigo.setNome(abrigoAtualizado.getNome());
        abrigo.setEndereco(abrigoAtualizado.getEndereco());
        abrigo.setResponsavel(abrigoAtualizado.getResponsavel());
        abrigo.setTelefone(abrigoAtualizado.getTelefone());
        abrigo.setEmail(abrigoAtualizado.getEmail());
        abrigo.setCapacidade(abrigoAtualizado.getCapacidade());
        em.getTransaction().commit();
    }

    public void deletarAbrigo(Long id) {
        em.getTransaction().begin();
        Abrigo abrigo = encontrarAbrigoPorID(id).orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
        em.remove(abrigo);
        em.getTransaction().commit();
    }
}
