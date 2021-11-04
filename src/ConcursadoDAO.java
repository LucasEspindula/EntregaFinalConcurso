import java.util.ArrayList;
import java.util.List;

public class ConcursadoDAO implements GenericDAO<Concursado, Integer>{
	
	private List<Concursado> concursados = new ArrayList<Concursado>();
	
	private List<ConcursoRealizado> ConcursoNota = new ArrayList<ConcursoRealizado>();
	
	@Override
	public void add(Concursado model) {
		for (Concursado concursadoJaSalvo : concursados) {
			if (model.getId() == concursadoJaSalvo.getId()) {
				throw new IllegalArgumentException("Concursado ja cadastrado.");
			}
		} 
		this.concursados.add(model);
	}
	
	@Override
	public List<Concursado> buscar() {
		return concursados;
	}
	
	@Override
	public Concursado buscarPorId(Integer id) {
		for (Concursado concursadoJaSalvo : concursados) {
			if (id == concursadoJaSalvo.getId()) {	
				return concursadoJaSalvo;
				}
			}
		return null;
	}
	
	public List<ConcursoRealizado> filtrarConcursadosPorReprovados() {
	List<ConcursoRealizado> concursadoFiltrado = new ArrayList<ConcursoRealizado>();
		for (ConcursoRealizado concursoJaSalvo : ConcursoNota) {
			if (concursoJaSalvo.getNota() < 7) {
				concursadoFiltrado.add(concursoJaSalvo);
				}
			}
		return concursadoFiltrado;
	}
}
