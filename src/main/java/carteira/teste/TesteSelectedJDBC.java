package carteira.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import carteira.dao.TransacaoDao;
import carteira.modelo.*;
public class TesteSelectedJDBC {

	public static void main(String[] args) {
	try {
		String url = "jdbc:postgresql://localhost:5433/carteira";
		String username = "postgres";
		String password = "AMam@!12";
		Connection conexao = DriverManager.getConnection(url,username,password);
		TransacaoDao dao = new TransacaoDao(conexao);
		
		List<Transacao> transacoes = dao.listar();
		
		transacoes.forEach(System.out::println);
		
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro");
		}
		}
}
