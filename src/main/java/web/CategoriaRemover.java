package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import servico.CategoriaServico;

@WebServlet("/categoria/remover")
public class CategoriaRemover extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/confirmarExclusao.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoriaServico cs = new CategoriaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));	//cod é o apelido na página jsp, depois de ?
		Categoria cat = cs.buscar(cod);
		request.setAttribute("item", cat);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}