package main;

import java.util.Optional;
import java.util.Scanner;
import entities.Abrigo;
import services.AbrigoService;

public class MenuAbrigo {
    private Scanner scanner;
    private AbrigoService abrigoService;

    public MenuAbrigo(Scanner scanner) {
        this.scanner = scanner;
        this.abrigoService = new AbrigoService();
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
        abrigoService.listarAbrigos().forEach(System.out::println);
    }

    public void editarAbrigo() {
        System.out.print("Digite o nome do Abrigo a ser editado: ");
        String nomeEditar = scanner.nextLine();
        
        Optional<Abrigo> abrigoOptional = abrigoService.encontrarAbrigoPorNome(nomeEditar);
        
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
                    scanner.nextLine();
                    abrigo.setCapacidade(novaCapacidade);
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            
            abrigoService.editarAbrigo(nomeEditar, abrigo);
            System.out.println("Abrigo atualizado com sucesso!");
            
        } else {
            System.out.println("Abrigo não encontrado.");
        }
    }

    public void deletarAbrigo() {
        System.out.print("Digite o nome do Abrigo a ser deletado: ");
        String nomeDeletar = scanner.nextLine();
        
        Optional<Abrigo> abrigoOptional = abrigoService.encontrarAbrigoPorNome(nomeDeletar);
        
        if (abrigoOptional.isPresent()) {
            abrigoService.deletarAbrigo(nomeDeletar);
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

