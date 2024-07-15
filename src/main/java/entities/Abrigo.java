package entities;

@Entity
public class Abrigo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private String responsavel;
    private String telefone;
    private String email;
    private int capacidade;
    
	public Abrigo(String nome, String endereco, String responsavel, String telefone, String email, int capacidade) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.responsavel = responsavel;
		this.telefone = telefone;
		this.email = email;
		this.capacidade = capacidade;
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
        return "Abrigo [nome=" + nome + ", endereco=" + endereco + ", responsavel=" + responsavel +
               ", telefone=" + telefone + ", email=" + email + ", capacidade=" + capacidade + "]";
    }
}
