import java.util.List;
import org.junit.Test;
import org.junit.Assert;

public class FiscalDAOtest {

	@Test
	public void deveSalvarUmFiscal() {
		
		FiscalDAO fiscalDAO = new FiscalDAO();
		
		Fiscal tiao = new Fiscal(6, "tiao silva", 42, "12345678910", "dwdwdwd@gmail.com", "1234", "1234567890", "12345");
		fiscalDAO.add(tiao);
		
	}
	
	@Test
	public void deveListarTodosOsFiscais() {
		FiscalDAO fiscalDAO = new FiscalDAO();
		
		List<Fiscal> fiscaisSalvos = fiscalDAO.buscar();
		
		Assert.assertEquals(6, fiscaisSalvos.size());
	}
	
	@Test
	public void deveBuscarPorId() {
		FiscalDAO fiscalDAO = new FiscalDAO();
		fiscalDAO.buscarPorId(1);
	}
}
