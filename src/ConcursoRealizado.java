import java.util.ArrayList;
import java.util.List;

public class ConcursoRealizado {
	
	public Concurso concurso;
	
	public Situacao situacao;
	
	public int nota;
	
	public Pagamento statusPagamento;

	public ConcursoRealizado(Concurso concurso) {
		this.concurso = concurso;
		this.situacao = Situacao.EM_AVALIACAO;
		this.nota = 0;
		this.statusPagamento = Pagamento.PENDENTE;
		validacao();
	}
	
	public void avaliar(int nota) {
		if (!statusPagamento.equals(Pagamento.PAGO)) {
			throw new IllegalArgumentException("A inscricao nao foi paga");
		}
		this.nota = nota;
		if (nota < 7) {
			situacao = Situacao.REPROVADO;
		} else {
			situacao = Situacao.APROVADO;
		}
	}
	
	public void pagar() {
		statusPagamento = Pagamento.PAGO;
	}
	
	private void validacao() {
		
		List<String> erros = new ArrayList<String>();
		
		if (concurso == null) {
			erros.add("informe um concurso valido");
		}
		
		if (!erros.isEmpty()) {
			throw new IllegalArgumentException(erros.toString());
		}
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public int getNota() {
		return nota;
	}

	public Pagamento getStatusPagamento() {
		return statusPagamento;
	}
}
