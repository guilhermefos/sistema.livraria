package web;
/*
 * Cenário do diagrama: Consultar.
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Editora;
import servico.EditoraServico;
import servico.ServicoException;

@WebServlet("/editora/inserir")
public class EditoraInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/editora/listarEditora.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EditoraServico es = new EditoraServico();
		Editora x = Instanciar.editora(request);

		try {
			es.inserir(x);
			List<Editora> itens = es.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		}
		
		
	}
}