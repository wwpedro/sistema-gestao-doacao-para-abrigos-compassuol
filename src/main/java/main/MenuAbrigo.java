package main;

import entities.Abrigo;
import services.AbrigoService;
import utils.JPAUtil;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuAbrigo {
    private Scanner scanner;
    private AbrigoService abrigoService;
    private EntityManager em;

    public MenuAbrigo(Scanner scanner) {
        this.scanner = scanner;
        this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
        this.abrigoService = new AbrigoService(em);
    }

    public void registrarAbrigo() {
        System.out.print("Nome do Abrigo: ");
        String nome = scanner.nextLine();
        
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        System.out.print("Responsável: ");
        String responsavel = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();  
        
        Abrigo abrigo = new Abrigo(nome, endereco, responsavel, telefone, email, capacidade);
        abrigoService.registrarAbrigo(abrigo);
        System.out.println("Abrigo registrado com sucesso!");
    }

    public void listarAbrigos() {
    	List<Abrigo> abrigos = abrigoService.listarAbrigos();

        if (abrigos.isEmpty()) {
            System.out.println("Não existem abrigos registrados no momento.");
        } else {
            abrigos.forEach(System.out::println);
        }
    }

    public void editarAbrigo() {
        System.out.print("Digite o ID do Abrigo a ser editado: ");
        Long id = scanner.nextLong();
        
        Optional<Abrigo> abrigoOptional = abrigoService.encontrarAbrigoPorID(id);
        
        if (abrigoOptional.isPresent()) {
            Abrigo abrigo = abrigoOptional.get();
            exibirAbrigo(abrigo);
            
            System.out.println("Qual campo você deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. Endereço");
            System.out.println("3. Responsável");
            System.out.println("4. Telefone");
            System.out.println("5. Email");
            System.out.println("6. Capacidade");
            System.out.print("Escolha uma opção: ");
            int campoOpcao = scanner.nextInt();
            scanner.nextLine();  
            
            switch (campoOpcao) {
                case 1:
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    abrigo.setNome(novoNome);
                    break;
                    
                case 2:
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = scanner.nextLine();
                    abrigo.setEndereco(novoEndereco);
                    break;
                    
                case 3:
                    System.out.print("Novo Responsável: ");
                    String novoResponsavel = scanner.nextLine();
                    abrigo.setResponsavel(novoResponsavel);
                    break;
                    
                case 4:
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    abrigo.setTelefone(novoTelefone);
                    break;
                    
                case 5:
                    System.out.print("Novo Email: ");
                    String novoEmail = scanner.nextLine();
                    abrigo.setEmail(novoEmail);
                    break;
                    
                case 6:
                    System.out.print("Nova Capacidade: ");
                    int novaCapacidade = scanner.nextInt();
                    abrigo.setCapacidade(novaCapacidade);
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            abrigoService.editarAbrigo(id, abrigo);
            System.out.println("Abrigo atualizado com sucesso!");
            
        } else {
            System.out.println("Abrigo não encontrado.");
        }
    }

    public void deletarAbrigo() {
        System.out.print("Digite o Id do Abrigo a ser deletado: ");
        Long id = scanner.nextLong();
        
        Optional<Abrigo> abrigoOptional = abrigoService.encontrarAbrigoPorID(id);
        
        if (abrigoOptional.isPresent()) {
            abrigoService.deletarAbrigo(id);
            System.out.println("Abrigo deletado com sucesso!");
        } else {
            System.out.println("Abrigo não encontrado.");
        }
    }

    private void exibirAbrigo(Abrigo abrigo) {
        System.out.println("Abrigo encontrado:");
        System.out.println(abrigo);
    }
}
