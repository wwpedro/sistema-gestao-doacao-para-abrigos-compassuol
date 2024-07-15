package main;

import entities.*;
import services.DoacaoService;
import utils.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuDoacao {
    private Scanner scanner;
    private DoacaoService doacaoService;
    private EntityManager em;

    public MenuDoacao(Scanner scanner) {
        this.scanner = scanner;
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
        this.doacaoService = new DoacaoService(em);
    }

    public void registrarItem(Doacao doacao) {
        System.out.print("Informe a descrição do item: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o tipo do item (Roupas, Produtos de Higiene, Alimentos): ");
        String tipo = scanner.nextLine();

        Item item;
        if (tipo.equalsIgnoreCase("Roupas")) {
            System.out.print("Informe o gênero (MASCULINO/FEMININO): ");
            RoupaGenero genero = RoupaGenero.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Informe o tamanho (INFANTIL/PP/P/M/G/GG): ");
            RoupaTamanho tamanho = RoupaTamanho.valueOf(scanner.nextLine().toUpperCase());
            item = new Roupa(descricao, genero, tamanho);
        } else if (tipo.equalsIgnoreCase("Produtos de Higiene")) {
            System.out.print("Informe o tipo do produto (ABSORVENTE/SABONETE/ESCOVA_DE_DENTE/PASTA_DE_DENTE): ");
            TipoProdutoHigiene tipoProduto = TipoProdutoHigiene.valueOf(scanner.nextLine().toUpperCase());
            item = new ProdutoHigiene(descricao, tipoProduto);
        } else if (tipo.equalsIgnoreCase("Alimentos")) {
            System.out.print("Informe a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Informe a unidade de medida (KG/ML/L): ");
            UnidadeMedidaAlimento unidadeMedida = UnidadeMedidaAlimento.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Informe a data de validade (yyyy-MM-dd): ");
            LocalDate validade = LocalDate.parse(scanner.nextLine());
            item = new Alimento(descricao, quantidade, unidadeMedida, validade);
        } else {
            System.out.println("Tipo de item inválido.");
            return;
        }

        System.out.print("Informe a quantidade a ser doada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        doacaoService.adicionarItem(doacao, item, quantidade);
        System.out.println("Item adicionado com sucesso.");
    }

    public void listarItens(Doacao doacao) {
        System.out.println("=== Itens da Doação ===");
        List<ItemDoacao> itens = doacaoService.listarItens(doacao);
        for (ItemDoacao itemDoacao : itens) {
            System.out.println(itemDoacao.getItem().getDescricao() + " - Quantidade: " + itemDoacao.getQuantidade());
        }
    }

    public void editarQuantidadeItem(Doacao doacao) {
        System.out.print("Informe a descrição do item a ter a quantidade editada: ");
        String descricao = scanner.nextLine();
        Optional<ItemDoacao> itemOptional = doacaoService.encontrarItemPorDescricao(doacao, descricao);

        if (itemOptional.isPresent()) {
            System.out.print("Informe a nova quantidade: ");
            int novaQuantidade = scanner.nextInt();
            scanner.nextLine(); 
            doacaoService.editarQuantidadeItem(doacao, itemOptional.get().getItem(), novaQuantidade);
            System.out.println("Quantidade do item editada com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public void removerItem(Doacao doacao) {
        System.out.print("Informe a descrição do item a ser removido: ");
        String descricao = scanner.nextLine();
        Optional<ItemDoacao> itemOptional = doacaoService.encontrarItemPorDescricao(doacao, descricao);

        if (itemOptional.isPresent()) {
            doacaoService.removerItem(doacao, itemOptional.get().getItem());
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public Doacao criarDoacao() {
        Doacao doacao = new Doacao();
        em.getTransaction().begin();
        em.persist(doacao);
        em.getTransaction().commit();
        System.out.println("Doação criada com sucesso. ID: " + doacao.getId());
        return doacao;
    }

    public Doacao carregarDoacao() {
        System.out.print("Informe o ID da doação: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); 
        Optional<Doacao> doacaoOptional = doacaoService.encontrarDoacaoPorId(id);

        if (doacaoOptional.isPresent()) {
            Doacao doacao = doacaoOptional.get();
            System.out.println("Doação carregada. ID: " + doacao.getId());
            return doacao;
        } else {
            System.out.println("Doação não encontrada.");
            return null;
        }
    }
}
