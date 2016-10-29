package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Editora;
import servico.EditoraServico;

@WebServlet("/editora/editar")
public class EditoraEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/editora/formEditar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EditoraServico es = new EditoraServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Editora ed = es.buscar(cod);
		request.setAttribute("item", ed);
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}