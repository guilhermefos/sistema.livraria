package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Categoria;

@WebServlet("/categoria/novo")
public class CategoriaNovo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/formInserir.jsp";	//Pastas em 'webapp'.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("itens", new Categoria());
		request.getRequestDispatcher(DESTINO).forward(request, response);
		
	}
}