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

        System.out.print("Informe o tipo do item (1-Roupa, 2-Higiene, 3-Alimentos): ");
        int tipo = scanner.nextInt();

        Item item = null;
        
        if (tipo == 1) {
            RoupaGenero genero = null;
            RoupaTamanho tamanho = null;

            System.out.print("Informe o gênero (1-MASCULINO/2-FEMININO): ");
            int opGenero = scanner.nextInt();

            if (opGenero == 1) {
                genero = RoupaGenero.MASCULINO;
            } else if (opGenero == 2) {
                genero = RoupaGenero.FEMININO;
            } else {
                System.out.println("Opção de gênero inválida. Operação cancelada.");
                return;
            }

            System.out.print("Informe o tamanho (1-INFANTIL/2-PP/3-P/4-M/5-G/6-GG): ");
            int opTamanho = scanner.nextInt();

            switch (opTamanho) {
                case 1:
                    tamanho = RoupaTamanho.INFANTIL;
                    break;
                case 2:
                    tamanho = RoupaTamanho.PP;
                    break;
                case 3:
                    tamanho = RoupaTamanho.P;
                    break;
                case 4:
                    tamanho = RoupaTamanho.M;
                    break;
                case 5:
                    tamanho = RoupaTamanho.G;
                    break;
                case 6:
                    tamanho = RoupaTamanho.GG;
                    break;
                default:
                    System.out.println("Opção de tamanho inválida. Operação cancelada.");
                    return;  
            }

            if (genero != null && tamanho != null) {
                item = new Roupa(descricao, genero, tamanho);
            } else {
                System.out.println("Erro: Não foi possível criar a roupa. Verifique os dados inseridos.");
            }
        } 
        
        else if (tipo==2) {
        	
        	TipoProdutoHigiene tipoProduto=null;
            System.out.print("Informe o tipo do produto (1-ABSORVENTE/2-SABONETE/3-ESCOVA_DE_DENTE/4-PASTA_DE_DENTE): ");
            int opHigiene = scanner.nextInt();
            
            switch (opHigiene) {
			case 1: {
				tipoProduto = TipoProdutoHigiene.ABSORVENTE;
				break;
			}
			case 2: {
				tipoProduto = TipoProdutoHigiene.SABONETE;
				break;
			}
			case 3: {
				tipoProduto = TipoProdutoHigiene.ESCOVA_DE_DENTE;
				break;
			}
			case 4: {
				tipoProduto = TipoProdutoHigiene.PASTA_DE_DENTE;
				break;
			}
			default:
				System.out.println("Opção de tamanho inválida. Operação cancelada.");
                return; 
			}
            
            if(tipoProduto != null) {
            	item = new ProdutoHigiene(descricao, tipoProduto);
            }else {
            	System.out.println("Erro: Não foi possível criar a Produto de Higiene. Verifique os dados inseridos.");
            }        
    
        } 
        
        else if (tipo==3) {
            System.out.print("Informe a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 
            
            UnidadeMedidaAlimento unidadeMedida=null;
            System.out.print("Informe a unidade de medida (1-KG/2-ML/3-L): ");
            
            int opAlimento = scanner.nextInt();
            
            switch (opAlimento) {
			case 1: {
				unidadeMedida = UnidadeMedidaAlimento.KG;
				break;
			}
			case 2: {
				unidadeMedida = UnidadeMedidaAlimento.ML;
				break;
			}
			case 3: {
				unidadeMedida = UnidadeMedidaAlimento.L;
				break;
			}
			default:
				System.out.println("Opção de tamanho inválida. Operação cancelada.");
                return; 
			}
            
            System.out.print("Informe a data de validade (yyyy-MM-dd): ");
            LocalDate validade = LocalDate.parse(scanner.nextLine());
            
            if(unidadeMedida!=null) {
            	item = new Alimento(descricao, quantidade, unidadeMedida, validade);
            }
            
        } else {
            System.out.println("Tipo de item inválido.");
            return;
        }

        System.out.print("Informe a quantidade a ser doada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 
        
        if(item!=null) {
        	doacaoService.adicionarItem(doacao, item, quantidade);
        	System.out.println("Item adicionado com sucesso.");
        }else {
        	System.out.println("Erro ao adicionar Item.");
        }
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
        } 
        
        else {
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
