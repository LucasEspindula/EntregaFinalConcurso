import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	
	private String nome;
	
	private int idade;
	
	private String cpf;
	
	private String email;

	public Pessoa(String nome, int idade, String cpf, String email) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
	}
	
	protected abstract void validacao();
	
	protected List<String> validacaoGeral() {
		
		List<String> erros = new ArrayList<String>();
		
		if (nome == null || nome.isBlank()) {
			erros.add("informe um nome");
		}
		
		if (idade <= 0) {
			erros.add("informe uma idade valida");
		}
		
		if (cpf == null || cpf.isBlank()) {
			erros.add("informe um cpf");
		} else if (cpf != null && cpf.length() != 11) {
			erros.add("informe um cpf valido");
		}
		
		if (email == null || email.isBlank()) {
			erros.add("informe um email");
		} else if (!email.contains("@") || !email.contains(".com")) {
			erros.add("informe um email valido");
		}
		return erros;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}
}
