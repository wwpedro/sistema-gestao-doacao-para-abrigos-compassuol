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

    public Optional<Abrigo> encontrarAbrigoPorNome(String nome) {
        TypedQuery<Abrigo> query = em.createQuery("FROM Abrigo a WHERE a.nome = :nome", Abrigo.class);
        query.setParameter("nome", nome);
        return query.getResultList().stream().findFirst();
    }

    public void editarAbrigo(String nome, Abrigo abrigoAtualizado) {
        em.getTransaction().begin();
        Abrigo abrigo = encontrarAbrigoPorNome(nome).orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
        abrigo.setNome(abrigoAtualizado.getNome());
        abrigo.setEndereco(abrigoAtualizado.getEndereco());
        abrigo.setResponsavel(abrigoAtualizado.getResponsavel());
        abrigo.setTelefone(abrigoAtualizado.getTelefone());
        abrigo.setEmail(abrigoAtualizado.getEmail());
        abrigo.setCapacidade(abrigoAtualizado.getCapacidade());
        em.getTransaction().commit();
    }

    public void deletarAbrigo(String nome) {
        em.getTransaction().begin();
        Abrigo abrigo = encontrarAbrigoPorNome(nome).orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
        em.remove(abrigo);
        em.getTransaction().commit();
    }
}
