import java.util.ArrayList;
import java.util.List;

public class Fiscal extends Pessoa implements Dominio<Integer> {
	
	private String agencia;
	
	private String conta;
	
	private String pix;

	private int identificador;

	public Fiscal(int identificador, String nome, int idade, String cpf, String email, String agencia, String conta, String pix) {
		super(nome, idade, cpf, email);
		this.identificador = identificador;
		this.agencia = agencia;
		this.conta = conta;
		this.pix = pix;
		validacao();
	}
	
	protected void validacao() {
		
		List<String> erros = new ArrayList<String>();
		
		erros.addAll(super.validacaoGeral());
		
		if (agencia == null || agencia.isBlank()) {
			erros.add("adicione uma agencia");
		} else if (agencia != null && agencia.length() != 4) {
			erros.add("adicione uma agencia valida");
		}
		
		if (conta == null || conta.isBlank()) {
			erros.add("adicione uma conta");
		} else if (conta != null && conta.length() != 10) {
			erros.add("adicione uma conta valida");
		} 
		
		if (pix == null || pix.isBlank()) {
			erros.add("adicione um pix");
		}
		
		if (identificador < 0) {
			erros.add("informe um identificador valido");
		}
		
		if (!erros.isEmpty()) {
			throw new IllegalArgumentException(erros.toString());
		}
	}

	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getPix() {
		return pix;
	}

	@Override
	public Integer getId() {
		return identificador;
	}
}
