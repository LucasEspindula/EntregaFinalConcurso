import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiscalDAO implements GenericDAO<Fiscal, Integer> {

	
	private Connection conexao;
	
	public FiscalDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/concurso";
			conexao = DriverManager.getConnection (url, "root", "21317046");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(Fiscal model) {
		// INSERT INTO fiscal VALUES(1, 'Lucas', 18, '12345678910','aiai@gmail.com', NULL, NULL, '12345678910');
		try {
			String SQL = "INSERT INTO fiscal VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conexao.prepareStatement(SQL);
			preparedStatement.setInt(1, model.getId());
			preparedStatement.setString(2, model.getNome());
			preparedStatement.setInt(3, model.getIdade());
			preparedStatement.setString(4, model.getCpf());
			preparedStatement.setString(5, model.getEmail());
			preparedStatement.setString(6, model.getAgencia());
			preparedStatement.setString(7, model.getConta());
			preparedStatement.setString(8, model.getPix());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		for (Fiscal fiscalJaSalvo : fiscais) {
//			if (model.getId() == fiscalJaSalvo.getId()) {
//				throw new IllegalArgumentException("Fiscal ja cadastrado.");
//			}
//		}
//		this.fiscais.add(model);
	}

	@Override
	public List<Fiscal> buscar() {
		List<Fiscal> fiscaisCadastrados = new ArrayList<Fiscal>();		
		try {
			String SQL = "SELECT * FROM fiscal";
			PreparedStatement preparedStatement = conexao.prepareStatement(SQL);
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				int fiscalid = results.getInt("fiscalid");
				String nome = results.getString("nome");
				int idade = results.getInt("idade");
				String cpf = results.getString("cpf");
				String email = results.getString("email");
				String agencia = results.getString("agencia");
				String conta = results.getString("conta");
				String pix = results.getString("pix");
				
				Fiscal fiscais = new Fiscal(fiscalid, nome, idade, cpf, email, agencia,conta,pix);
				fiscaisCadastrados.add(fiscais);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fiscaisCadastrados;
	}

	@Override
	public Fiscal buscarPorId(Integer id) {
		try {
			String SQL = "SELECT * FROM fiscal f where fiscalid= " + id;
			PreparedStatement preparedStatement = conexao.prepareStatement(SQL);
			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				int fiscalid = results.getInt("fiscalid");
				String nome = results.getString("nome");
				int idade = results.getInt("idade");
				String cpf = results.getString("cpf");
				String email = results.getString("email");
				String agencia = results.getString("agencia");
				String conta = results.getString("conta");
				String pix = results.getString("pix");
				
				new Fiscal(fiscalid, nome, idade, cpf, email, agencia,conta,pix);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
//		for (Fiscal fiscalJaSalvo : fiscais) {
//			if (id == fiscalJaSalvo.getId()) {
//				return fiscalJaSalvo;
//			}
//		}
	}
}
