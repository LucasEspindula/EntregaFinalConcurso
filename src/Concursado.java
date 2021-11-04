import java.util.ArrayList;
import java.util.List;

public class Concursado extends Pessoa implements Dominio<Integer>{
	
	public List<ConcursoRealizado> concursos;
	
	private int identificador;

	public Concursado(int identificador, String nome, int idade, String cpf, String email, ConcursoRealizado concurso) {
		super(nome, idade, cpf, email);
		this.concursos = new ArrayList<ConcursoRealizado>();
		this.identificador = identificador;
		addConcurso(concurso);
		validacao();
	}
	
	public void addConcurso(ConcursoRealizado addConcurso) {	
		 for (ConcursoRealizado concursoInscritos: concursos) {
			 if (concursoInscritos.getConcurso().getId() == addConcurso.getConcurso().getId()) {
				 throw new IllegalArgumentException("inscricao duplicada");
			}
		 }	 
		this.concursos.add(addConcurso);
	}
	
	public void avaliacaoConcurso(int concursoId, int nota) {
		 for (ConcursoRealizado concursoRealizado: concursos) {
			 if (concursoRealizado.getConcurso().getId() == concursoId) {
				 concursoRealizado.avaliar(nota);
			}
		 }
	}
	
	public void pagarInscricao(int concursoId) {
		for (ConcursoRealizado concursoRealizado : concursos) {
			if (concursoRealizado.getConcurso().getId() == concursoId) {
				concursoRealizado.pagar();
			}
		}
	}
	
	protected void validacao() {
		
		List<String> erros = new ArrayList<String>();
		
		erros.addAll(super.validacaoGeral());
		
		if (concursos == null) {
			erros.add("A lista nao pode ser nula");
		}
		
		if (identificador < 0) {
			erros.add("informe um identificador valido");
		}
		
		if (!erros.isEmpty()) {
			throw new IllegalArgumentException(erros.toString());
		}
	}

	public List<ConcursoRealizado> getSituacoes() {
		return concursos;
	}

	@Override
	public Integer getId() {
		return identificador;
	}
}
