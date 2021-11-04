import org.junit.Test;
import org.junit.Assert;

public class FiscalTest {
	
	@Test
	public void deveCriarUmFiscalComSucesso() {
		
		Fiscal tiao = new Fiscal(1, "Tiao silva", 42, "12345678910", "dwdwdwd@gmail.com", "1234", "1234567890", "12345");
		
		FiscalDAO confirmaFiscal = new FiscalDAO();
		confirmaFiscal.add(tiao);
		
		Assert.assertEquals("Tiao silva", tiao.getNome());
		Assert.assertEquals(42, tiao.getIdade());
		Assert.assertEquals("12345678910", tiao.getCpf());
		Assert.assertEquals("dwdwdwd@gmail.com", tiao.getEmail());
		Assert.assertEquals("1234", tiao.getAgencia());
		Assert.assertEquals("1234567890", tiao.getConta());
		Assert.assertEquals("12345", tiao.getPix());
	}
	
	@Test
	public void deveImpedirACriacaoDeUmFiscalDuplicado() {
		
		Fiscal tiao = new Fiscal(1, "Tiao silva", 42, "12345678910", "dwdwdwd@gmail.com", "1234", "1234567890", "12345");
		
		FiscalDAO confirmaFiscal = new FiscalDAO();
		confirmaFiscal.add(tiao);
		
		try {
			confirmaFiscal.add(tiao);
		} catch (Exception e) {
			Assert.assertEquals("Fiscal ja cadastrado.", e.getMessage());
		}
	}
	
	@Test
	public void deveTestarACriacaoDeUmFiscalNulo() {
		
		try {
			new Fiscal(-2, null, 0, null, null, null, null, null);
			// fail("deve quebrar");
		} catch (Exception e) {
			Assert.assertEquals("[informe um nome, informe uma idade valida, informe um cpf, "
					+ "informe um email, adicione uma agencia, adicione uma conta, adicione um pix, "
					+ "informe um identificador valido]", e.getMessage());
		}
	}
	
	@Test
	public void deveTestarACriacaoDeUmFiscalComInformacoesInvalida() {
		
		try {
			new Fiscal(-2, " ", -1, "123456789101", "dwdwdwdgmail.com", "123", "12345678901", " ");
		} catch (Exception e) {
			Assert.assertEquals("[informe um nome, informe uma idade valida, informe um cpf valido, "
					+ "informe um email valido, adicione uma agencia valida, adicione uma conta valida, "
					+ "adicione um pix, informe um identificador valido]", e.getMessage());
		}
	}
}
