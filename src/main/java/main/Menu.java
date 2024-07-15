package main;

import java.util.Scanner;

import entities.Doacao;
import utils.JPAUtil;

public class Menu {
    private Scanner scanner;
    private MenuAbrigo menuAbrigo;
    private MenuCentroDistribuicao menuCentro;
    private MenuDoacao menuDoacao;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.menuAbrigo = new MenuAbrigo(scanner);
        this.menuCentro = new MenuCentroDistribuicao(scanner);
        this.menuDoacao = new MenuDoacao(scanner);
    }

    public void exibirMenu() {
        int opcao;
        Doacao doacao = null;
        do {
            System.out.println("---------------Menu---------------");
            System.out.println("1. Registrar Abrigo");
            System.out.println("2. Listar Abrigos");
            System.out.println("3. Editar Abrigo");
            System.out.println("4. Deletar Abrigo");
            System.out.println("5. Registrar Centro de Distribuição");
            System.out.println("6. Listar Centros de Distribuição");
            System.out.println("7. Editar Centro de Distribuição");
            System.out.println("8. Deletar Centro de Distribuição");
            System.out.println("9. Registrar Item na Doação");
            System.out.println("10. Listar Itens da Doação");
            System.out.println("11. Editar Quantidade de Item na Doação");
            System.out.println("12. Remover Item da Doação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuAbrigo.registrarAbrigo();
                    break;
                case 2:
                    menuAbrigo.listarAbrigos();
                    break;
                case 3:
                    menuAbrigo.editarAbrigo();
                    break;
                case 4:
                    menuAbrigo.deletarAbrigo();
                    break;
                case 5:
                    menuCentro.registrarCentro();
                    break;
                case 6:
                    menuCentro.listarCentros();
                    break;
                case 7:
                    menuCentro.editarCentro();
                    break;
                case 8:
                    menuCentro.deletarCentro();
                    break;
                case 9:
                    doacao = menuDoacao.criarDoacao();
                    menuDoacao.registrarItem(doacao);
                    break;
                case 10:
                    doacao = menuDoacao.carregarDoacao();
                    if (doacao != null) {
                        menuDoacao.listarItens(doacao);
                    }
                    break;
                case 11:
                    doacao = menuDoacao.carregarDoacao();
                    if (doacao != null) {
                        menuDoacao.editarQuantidadeItem(doacao);
                    }
                    break;
                case 12:
                    doacao = menuDoacao.carregarDoacao();
                    if (doacao != null) {
                        menuDoacao.removerItem(doacao);
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado");
                    JPAUtil.close(); 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.exibirMenu();
    }
}
