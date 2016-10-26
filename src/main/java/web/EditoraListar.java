package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Editora;
import servico.EditoraServico;

@WebServlet("/editora/listar")
public class EditoraListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/editora/listar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EditoraServico es = new EditoraServico();
		List<Editora> itens = es.buscarTodosOrdenadosPorNome();
		request.setAttribute("itens", itens);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}