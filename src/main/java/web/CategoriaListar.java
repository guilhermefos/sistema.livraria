package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;
import servico.CategoriaServico;

//Primeiro: Buscar todos.

@WebServlet("/categoria/listarCategoria")	//entra primeiro aqui na chamada no front end.
public class CategoriaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/listarCategoria.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoriaServico cs = new CategoriaServico();
		List<Categoria> itens = cs.buscarTodosOrdenadosPorNome();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}