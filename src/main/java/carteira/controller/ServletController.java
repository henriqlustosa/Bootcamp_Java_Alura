package carteira.controller;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDate;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carteira.dao.TransacaoDao;
import carteira.factory.ConnectionFactory;
import carteira.modelo.TipoTransacao;
import carteira.modelo.Transacao;

@WebServlet("/transacoes")
public class ServletController extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	//private List<Transacao> lista = new ArrayList<>();

	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Transacao t1 = new Transacao("XPTO", new BigDecimal("500.0"), 3, LocalDate.now(), TipoTransacao.COMPRA);
		Transacao t2 = new Transacao("ABCD", new BigDecimal("450.5"), 3, LocalDate.now(), TipoTransacao.VENDA);
		lista.add(t1);
		lista.add(t2);
		
		req.setAttribute("listaTransacao", lista);
		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, resp);
	}
	*/
	
	
	private TransacaoDao dao;

	public ServletController() {
		Connection conexao = new ConnectionFactory().getConnection();
		this.dao = new TransacaoDao(conexao);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("transacoes", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ticker = req.getParameter("ticker");
		BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(",", "."));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));
		
		Transacao nova = new Transacao(ticker, preco, quantidade, data ,tipo);
		dao.salvar(nova);
		resp.sendRedirect("transacoes");
	}
}
