package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abrigo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
    private String endereco;
    private String responsavel;
    private String telefone;
    private String email;
    private int capacidade;
    
    public Abrigo() {}
    
	public Abrigo(String nome, String endereco, String responsavel, String telefone, String email, int capacidade) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.email = email;
		this.capacidade = capacidade;
	}
	
	public Long getId() {
        return id;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}	
	
	@Override
    public String toString() {
        return "________________________\nAbrigo: "+nome +"\nId: "+id+ ", \nendereco: " + endereco + ", \nresponsavel: " + responsavel +
               ", \ntelefone: " + telefone + ", \nemail: " + email + ", \ncapacidade: " + capacidade + "\n";
    }
}
