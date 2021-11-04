import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcursoDAO implements GenericDAO<Concurso, Integer> {

	private List<Concurso> concursos = new ArrayList<Concurso>();
	
	@Override
	public void add(Concurso model) {	
		for (Concurso concursoJaSalvo : concursos) {
			if (model.getId() == concursoJaSalvo.getId()) {
				throw new IllegalArgumentException("Concurso ja cadastrado.");
			}
		}
		this.concursos.add(model);
	}

	@Override
	public List<Concurso> buscar() {
		return concursos;
	}

	@Override
	public Concurso buscarPorId(Integer id) {
		for (Concurso concursoJaSalvo : concursos) {
			if (id == concursoJaSalvo.getId()) {	
				return concursoJaSalvo;
			}
		}
		return null;
	}
	
	public List<Concurso> getConcursos() {
		return concursos;
	}
	
	public List<Concurso> filtrarPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		List<Concurso> concursoFiltrado = new ArrayList<Concurso>();
		for (Concurso concursoJaSalvo : concursos) {
			if (concursoJaSalvo.getDataHora().isAfter(dataInicial) 
					&& concursoJaSalvo.getDataHora().isBefore(dataFinal)) {
				concursoFiltrado.add(concursoJaSalvo);
			}
		}
		return concursoFiltrado;
	}	
	
	public List<Concurso> filtrarConcursoPorCidade(String cidade) {
		List<Concurso> concursoFiltrado = new ArrayList<Concurso>();
		for (Concurso concursoJaSalvo : concursos) {
			if (concursoJaSalvo.getLocal().contains(cidade)) {
				concursoFiltrado.add(concursoJaSalvo);
			}
		}
		return concursoFiltrado;
	}
	
	public List<Concurso> filtrarConcursoPorNumeroDeParticipantes(int participantes) {
		List<Concurso> concursoFiltrado = new ArrayList<Concurso>();
			for (Concurso concursoJaSalvo : concursos) {
				if (concursoJaSalvo.getParticipantes().size() >= participantes) {
					concursoFiltrado.add(concursoJaSalvo);
				}
			}
		return concursoFiltrado;
	}
	
	public List<Concurso> filtrarConcursoPorEmpresa(String empresa) {	
		List<Concurso> concursoFiltrado = new ArrayList<Concurso>();
		for (Concurso concursoJaSalvo : concursos) {
			if (concursoJaSalvo.getEmpresa().equals(empresa)) {
				concursoFiltrado.add(concursoJaSalvo);
			}
		}
		return concursoFiltrado;
	}
}
