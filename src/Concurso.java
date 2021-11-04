import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Concurso implements Dominio<Integer>{

	private String empresa;
	
	private String regras;
	
	private String local;
	
	private LocalDateTime dataHora;
	
	private int identificador;
	
	private List<Concursado> participantes = new ArrayList<Concursado>();
	
	public Concurso(int identificador, String empresa, String regras, String local, LocalDateTime dataHora) {
		this.empresa = empresa;
		this.regras = regras;
		this.local = local;
		this.dataHora = dataHora;
		this.identificador = identificador;
		validacao();
	}
	
	protected void validacao() {
		
		List<String> erros = new ArrayList<String>();
		
		if (empresa == null || empresa.isEmpty()) {
			erros.add("informe uma empresa");
		}
		
		if (regras == null || regras.isBlank()) {
			erros.add("informe uma regra");
		}
		
		if (local == null || local.isBlank()) {
			erros.add("informe um local");
		}
		
		if (dataHora == null || dataHora.isBefore(LocalDateTime.now())) {
			erros.add("informe uma data no futuro");
		}
		
		if (identificador < 0) {
			erros.add("informe um identificador valido");
		}
		
		if (!erros.isEmpty()) {
			throw new IllegalArgumentException(erros.toString());
		}
	}
	
	public void inscreverConcursado(Concursado novoParticipante) {
		for (Concursado inscrito : participantes) {
			if (inscrito.getCpf().equals(novoParticipante.getCpf())) {
				throw new IllegalArgumentException("Participante ja cadastrado.");
			}
		}
		this.participantes.add(novoParticipante);
	}

	public String getRegras() {
		return regras;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getLocal() {
		return local;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public List<Concursado> getParticipantes() {
		return participantes;
	}

	@Override
	public Integer getId() {
		return identificador;
	}
}
