import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

public class ConcursoTest {

	@Test
	public void deveValidarACriacaoDeUmConcursoValico() {
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		Assert.assertEquals("Procergs", procergs.getEmpresa());
		Assert.assertEquals(1, procergs.getId().intValue());
		Assert.assertEquals("AV Ipiranga", procergs.getLocal());
		Assert.assertEquals("Levar caneta preta e chegar 30 min antes.", procergs.getRegras());
	}
	
	@Test
	public void deveBuscarConcursoPorID() {
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		Concurso procempa = new Concurso(2, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoDAO salvaConcurso = new ConcursoDAO();
		salvaConcurso.add(procempa);
		salvaConcurso.add(procergs);
															
		Assert.assertEquals(procergs, salvaConcurso.buscarPorId(1));
	}
	
	@Test
	public void deveInvalidarACriacaoDeUmConcursoInvalido() {
		
		try {	
			new Concurso(-3, null, null, null,LocalDateTime.of(2021, 5, 10, 10, 10));
			
		} catch (Exception e) {
			Assert.assertEquals("[informe uma empresa, informe uma regra, informe um local, informe uma data no futuro, "
					+ "informe um identificador valido]", e.getMessage());
		}
	}
	
	@Test
	public void deveValidarInscricaoDeCandidato() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		
		ConcursoRealizado situacaoJoao = new ConcursoRealizado(procergs);
		
		Concursado joaoLima = new Concursado(1, "Joao Lima", 18, "02458123456", "jaum@gmail.com", situacaoJoao);
		
		Concursado pedroAlves = new Concursado(2, "Pedro Alves", 19, "02458123457", "pedro@gmail.com", situacaoJoao);
		
		procergs.inscreverConcursado(joaoLima);
		procergs.inscreverConcursado(pedroAlves);
		
		Assert.assertEquals(2, procergs.getParticipantes().size());
	}
	
	@Test
	public void deveValidarInscricaoDeCandidatoJaCadastrado() {
		
		Concurso procergs = new Concurso(1, "Procergs", "Levar caneta preta e chegar 30 min antes.", "AV Ipiranga",LocalDateTime.now().plusMonths(1));
		ConcursoRealizado situacaoConcursado = new ConcursoRealizado(procergs);
		
		Concursado joaoLima = new Concursado(1, "Joao Lima", 18, "02458123456", "jaum@gmail.com", situacaoConcursado);	
		
		Concursado pedroAlves = new Concursado(2, "Pedro Alves", 19, "02458123457", "pedro@gmail.com", situacaoConcursado);
		
		Concursado thiagoAlmeida = new Concursado(3, "Thiago Almeida", 16, "02458123454", "thiagoAlmeida@gmail.com", situacaoConcursado);
		
		procergs.inscreverConcursado(joaoLima);
		procergs.inscreverConcursado(pedroAlves);
		procergs.inscreverConcursado(thiagoAlmeida);
		
		try {		
			procergs.inscreverConcursado(pedroAlves);
		} catch (Exception e) {
			Assert.assertEquals("Participante ja cadastrado.", e.getMessage());
		}
	}	
}
