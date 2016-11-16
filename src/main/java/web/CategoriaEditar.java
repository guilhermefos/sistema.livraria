package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import servico.CategoriaServico;

@WebServlet("/categoria/editar")
public class CategoriaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/formEditar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoriaServico cs = new CategoriaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Categoria cat = cs.buscar(cod);
		request.setAttribute("item", cat);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}