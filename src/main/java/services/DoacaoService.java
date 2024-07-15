package services;

import entities.*;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DoacaoService {
    private EntityManager em;

    public DoacaoService(EntityManager em) {
        this.em = em;
    }

    public void adicionarItem(Doacao doacao, Item item, int quantidade) {
        try {
            em.getTransaction().begin();

            em.persist(item);

            ItemDoacao itemDoacao = new ItemDoacao();
            itemDoacao.setDoacao(doacao);
            itemDoacao.setItem(item);
            itemDoacao.setQuantidade(quantidade);

            doacao.getItens().add(itemDoacao);
            em.persist(itemDoacao);
            em.merge(doacao);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public List<ItemDoacao> listarItens(Doacao doacao) {
        return em.createQuery("SELECT id FROM ItemDoacao id WHERE id.doacao = :doacao", ItemDoacao.class)
                .setParameter("doacao", doacao)
                .getResultList();
    }

    public Optional<ItemDoacao> encontrarItemPorDescricao(Doacao doacao, String descricao) {
        return doacao.getItens().stream()
                .filter(itemDoacao -> itemDoacao.getItem().getDescricao().equalsIgnoreCase(descricao))
                .findFirst();
    }

    public Optional<Doacao> encontrarDoacaoPorId(Long id) {
        Doacao doacao = em.find(Doacao.class, id);
        return Optional.ofNullable(doacao);
    }

    public void editarQuantidadeItem(Doacao doacao, Item item, int novaQuantidade) {
        ItemDoacao itemDoacao = em.createQuery(
                "SELECT id FROM ItemDoacao id WHERE id.doacao = :doacao AND id.item = :item", ItemDoacao.class)
                .setParameter("doacao", doacao)
                .setParameter("item", item)
                .getSingleResult();
        itemDoacao.setQuantidade(novaQuantidade);

        em.getTransaction().begin();
        em.merge(itemDoacao);
        em.getTransaction().commit();
    }

    public void removerItem(Doacao doacao, Item item) {
        ItemDoacao itemDoacao = em.createQuery(
                "SELECT id FROM ItemDoacao id WHERE id.doacao = :doacao AND id.item = :item", ItemDoacao.class)
                .setParameter("doacao", doacao)
                .setParameter("item", item)
                .getSingleResult();

        em.getTransaction().begin();
        doacao.getItens().remove(itemDoacao);
        em.remove(itemDoacao);
        em.merge(doacao);
        em.getTransaction().commit();
    }
}
