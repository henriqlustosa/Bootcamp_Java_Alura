package carteira.teste;
import carteira.modelo.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;


import carteira.dao.TransacaoDao;

public class TesteInsertedJDBC {
	public static void main(String[] args) {
		try {
			String url = "jdbc:postgresql://localhost:5433/carteira";
			String username = "postgres";
			String password = "AMam@!12";
			Connection conexao = DriverManager.getConnection(url,username,password);
			TransacaoDao dao = new TransacaoDao(conexao);
			
			
			Transacao transacao = new Transacao("XPTO2",
					new BigDecimal("333"),
					200,
					LocalDate.now(),
					TipoTransacao.COMPRA);
			
			dao.salvar(transacao);
		}catch (Exception e) {
			System.out.println("Ocorreu um erro");
		}
		
	}

}
