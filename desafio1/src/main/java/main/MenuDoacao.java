package main;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import entities.*;
import services.DoacaoService;

public class MenuDoacao {
    private Scanner scanner;
    private DoacaoService doacaoService;

    public MenuDoacao(Scanner scanner) {
        this.scanner = scanner;
        this.doacaoService = new DoacaoService();
    }

    public void registrarItem() {
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
            scanner.nextLine(); // consume the leftover newline
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
        scanner.nextLine(); // consume the leftover newline
        doacaoService.adicionarItem(item, quantidade);
        System.out.println("Item adicionado com sucesso.");
    }

    public void listarItens() {
        doacaoService.listarItens();
    }

    public void editarQuantidadeItem() {
        System.out.print("Informe a descrição do item a ter a quantidade editada: ");
        String descricao = scanner.nextLine();
        Optional<Map.Entry<Item, Integer>> itemOptional = doacaoService.encontrarItemPorDescricao(descricao);

        if (itemOptional.isPresent()) {
            System.out.print("Informe a nova quantidade: ");
            int novaQuantidade = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline
            doacaoService.editarQuantidadeItem(itemOptional.get().getKey(), novaQuantidade);
            System.out.println("Quantidade do item editada com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public void removerItem() {
        System.out.print("Informe a descrição do item a ser removido: ");
        String descricao = scanner.nextLine();
        Optional<Map.Entry<Item, Integer>> itemOptional = doacaoService.encontrarItemPorDescricao(descricao);

        if (itemOptional.isPresent()) {
            doacaoService.removerItem(itemOptional.get().getKey());
            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }
}
