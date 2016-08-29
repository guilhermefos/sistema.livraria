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

import dominio.Cliente;
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
