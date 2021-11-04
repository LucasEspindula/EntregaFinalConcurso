import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class ConcursadoTest {

	@Test
	public void deveValidarACriacaoDeUmConcursadoComSucesso() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		
		Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
		
		Assert.assertEquals("Lucas souza", participante.getNome());
		Assert.assertEquals(20, participante.getIdade());
		Assert.assertEquals("12345678910", participante.getCpf());
		Assert.assertEquals("dwdwdwd@gmail.com", participante.getEmail());
		
		}
	
	@Test
	public void deveTestarACriacaoDeUmConcursadoComConcursoNulo() {
		
		try {
			new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", null);
		} catch (Exception e) {
			Assert.assertEquals("[A lista nao pode ser nula]", e.getMessage());
			}
		}
	
	@Test
	public void deveTestarACriacaoDeUmConcursadoNulo() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		
		try {
			new Concursado(-1, null, -1, null, null, concursoRealizado);
		} catch (Exception e) {
			Assert.assertEquals("[informe um nome, informe uma idade valida, informe um cpf, "
					+ "informe um email, informe um identificador valido]", e.getMessage());
		}
	}
	
	@Test
	public void deveTestarACriacaoDeUmConcursadoComInformacoesInvalidas() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		
		try {
			new Concursado(-1, " ", 0, "123456789101", "dwdwdwdgmail.", concursoRealizado);
		} catch (Exception e) {
			Assert.assertEquals("[informe um nome, informe uma idade valida, informe um cpf valido, "
					+ "informe um email valido, informe um identificador valido]", e.getMessage());
		}
	}
	
	@Test
	public void testaAdicaoDeNovoConcurso() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		Concurso procempa = new Concurso(2, "Procempa", "Levar caneta preta e chegar 30 min antes.", "AV Tira dentes",LocalDateTime.now().plusMonths(2));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		ConcursoRealizado concursoRealizado2 = new ConcursoRealizado(procempa);
		
		Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
		
		participante.addConcurso(concursoRealizado2);
		
		Assert.assertEquals(2, participante.getSituacoes().size());

		}
	
	@Test
	public void testaAInscricaoDoConcursadoNoMesmoConcurso() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		Concurso procempa = new Concurso(2, "Procempa", "Levar caneta preta e chegar 30 min antes.", "AV Tira dentes",LocalDateTime.now().plusMonths(2));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		ConcursoRealizado concursoRealizado2 = new ConcursoRealizado(procempa);
		
		Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
		
		try {
			participante.addConcurso(concursoRealizado2);
		} catch (Exception e) {
			
			Assert.assertEquals("inscricao duplicada", e.getMessage());
			}
		}
	}
