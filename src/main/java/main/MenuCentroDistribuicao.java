package main;

import java.util.Optional;
import java.util.Scanner;
import javax.persistence.EntityManager;
import entities.CentroDistribuicao;
import services.CentroDistribuicaoService;
import utils.JPAUtil;

public class MenuCentroDistribuicao {
    private Scanner scanner;
    private CentroDistribuicaoService centroService;
    private EntityManager em;

    public MenuCentroDistribuicao(Scanner scanner) {
        this.scanner = scanner;
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
        this.centroService = new CentroDistribuicaoService(em);
    }

    public void registrarCentro() {
        System.out.print("Nome do Centro de Distribuição: ");
        String nome = scanner.nextLine();
        
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        CentroDistribuicao centro = new CentroDistribuicao(nome, endereco, telefone);
        centroService.registrarCentroDistribuicao(centro);
        System.out.println("Centro de Distribuição registrado com sucesso!");
    }

    public void listarCentros() {
        centroService.listarCentros().forEach(System.out::println);
    }

    public void editarCentro() {
        System.out.print("Digite o nome do Centro de Distribuição a ser editado: ");
        String nomeEditar = scanner.nextLine();
        
        Optional<CentroDistribuicao> centroOptional = centroService.encontrarCentroDistribuicaoPorNome(nomeEditar);
        
        if (centroOptional.isPresent()) {
            CentroDistribuicao centro = centroOptional.get();
            exibirCentro(centro);
            
            System.out.println("Qual campo você deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. Endereço");
            System.out.println("3. Telefone");
            System.out.print("Escolha uma opção: ");
            int campoOpcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (campoOpcao) {
                case 1:
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    centro.setNome(novoNome);
                    break;
                    
                case 2:
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = scanner.nextLine();
                    centro.setEndereco(novoEndereco);
                    break;
                    
                case 3:
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    centro.setTelefone(novoTelefone);
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            centroService.editarCentroDistribuicao(nomeEditar, centro);
            System.out.println("Centro de Distribuição atualizado com sucesso!");
            
        } else {
            System.out.println("Centro de Distribuição não encontrado.");
        }
    }

    public void deletarCentro() {
        System.out.print("Digite o nome do Centro de Distribuição a ser deletado: ");
        String nomeDeletar = scanner.nextLine();
        
        Optional<CentroDistribuicao> centroOptional = centroService.encontrarCentroDistribuicaoPorNome(nomeDeletar);
        
        if (centroOptional.isPresent()) {
            centroService.deletarCentroDistribuicao(nomeDeletar);
            System.out.println("Centro de Distribuição deletado com sucesso!");
        } else {
            System.out.println("Centro de Distribuição não encontrado.");
        }
    }

    private void exibirCentro(CentroDistribuicao centro) {
        System.out.println("Centro de Distribuição encontrado:");
        System.out.println(centro);
    }
}
