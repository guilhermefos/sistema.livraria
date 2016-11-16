package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Livro;
import servico.LivroServico;

@WebServlet("/livro/resultado")
public class LivroResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/livro/resultadoBusca.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LivroServico ls = new LivroServico();
		String titulo = request.getParameter("titulo");
		
		BigDecimal valorMin = new BigDecimal(request.getParameter("valorMin"));
		BigDecimal valorMax = new BigDecimal(request.getParameter("valorMax"));
		
		List<Livro> itens = ls.buscarPorTituloValorMinimoValorMaximo(titulo, valorMin, valorMax);
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
