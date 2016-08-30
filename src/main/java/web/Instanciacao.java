package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Editora;
import dominio.Emprestimo;
import dominio.Livro;
import servico.ClienteServico;


/**
 * Servlet implementation class Instanciacao
 */
@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Cliente c1 = new Cliente(null, "Guilherme Ferreira", "09243891685", "34-3235-8893", "guilherme.oliveira@gmail.com", sdf.parse("04/08/1989"), new BigDecimal("200000.00"));
			Cliente c2 = new Cliente(null, "Luciana Oliveira", "07248892635", "34-3255-8893", "luciana.oliveira@gmail.com", sdf.parse("04/09/1990"), new BigDecimal("600000.00"));
			Cliente c3 = new Cliente(null, "Gustavo Ferreira", "09243801685", "34-3235-9893", "gustavo.oliveira@gmail.com", sdf.parse("24/08/1989"), new BigDecimal("200000.00"));
			
			Editora e1 = new Editora(null, "Atlas");
			Editora e2 = new Editora(null, "Viva");
			Editora e3 = new Editora(null, "Trash");
			
			Categoria ct1 = new  Categoria(null, "Romance");
			Categoria ct2 = new  Categoria(null, "Filosofia");
			Categoria ct3 = new  Categoria(null, "Tecnologia");
			
			Livro l1 = new Livro(null, "HTML & CSS", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l2 = new Livro(null, "JAVA", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l3 = new Livro(null, "OBJECTIVE C", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l4 = new Livro(null, "C#", "", 400, new BigDecimal("20.00"), e1, ct3);
			Livro l5 = new Livro(null, "ERA UMA VEZ", "", 400, new BigDecimal("20.00"), e2, ct1);
			Livro l6 = new Livro(null, "FELICIDADE HOJE", "", 400, new BigDecimal("20.00"), e2, ct1);
			Livro l7 = new Livro(null, "ALEGRIA", "", 400, new BigDecimal("20.00"), e2, ct1);
			Livro l8 = new Livro(null, "SEI QUE NADA SEI", "", 400, new BigDecimal("20.00"), e3, ct2);
			Livro l9 = new Livro(null, "SOCRATES", "", 400, new BigDecimal("20.00"), e3, ct2);
			Livro l10 = new Livro(null, "PLATAO", "", 400, new BigDecimal("20.00"), e3, ct2);
			
			Emprestimo em1 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			Emprestimo em2 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			Emprestimo em3 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			Emprestimo em4 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			Emprestimo em5 = new Emprestimo(null, sdf.parse("29/08/1989"), 3, c1);
			
			
			ClienteServico cs1 = new ClienteServico();
			
			cs1.inserirAtualizar(c1);
			
			
			response.getWriter().append("Fim");
		
		}
		catch (ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
