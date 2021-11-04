import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ConcursoRealizadoTest {
	
	@Test
	public void deveTestarASituacaoDeReprovado() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		
		Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
		
		participante.pagarInscricao(1);
		participante.avaliacaoConcurso(1, 6);
		
		Assert.assertEquals(Situacao.REPROVADO, concursoRealizado.getSituacao());
	}
	
	@Test
	public void deveTestarASituacaoDeAprovado() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		
		Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
		
		participante.pagarInscricao(1);
		participante.avaliacaoConcurso(1, 7);
		
		Assert.assertEquals(Situacao.APROVADO, concursoRealizado.getSituacao());
	}
	
	@Test
	public void testaAAvaliacaoDoConcursoJaPago() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
		
		Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
		
		participante.pagarInscricao(1);
		participante.avaliacaoConcurso(1, 8);
		
		Assert.assertEquals(8, concursoRealizado.getNota());
	}
	
	@Test
	public void testaAAvaliacaoDoConcursoNaoPago() {
		
		try {
			Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
			
			ConcursoRealizado concursoRealizado = new ConcursoRealizado(procergs);
			
			Concursado participante = new Concursado(1, "Lucas souza", 20, "12345678910", "dwdwdwd@gmail.com", concursoRealizado);
			
			participante.avaliacaoConcurso(1, 8);
			
		} catch (Exception e) {
			
			Assert.assertEquals("A inscricao nao foi paga", e.getMessage());
			}
		}
	
	@Test
	public void deveTestarUmConcursoCadastradoNulo() {
		
		try {
			new ConcursoRealizado(null);
		} catch (Exception e) {

			Assert.assertEquals("[informe um concurso valido]", e.getMessage());
		}
	}
}
