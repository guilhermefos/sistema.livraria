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
import servico.ServicoException;


@WebServlet("/editora/excluir")
public class EditoraExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/editora/listarEditora.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		EditoraServico es = new EditoraServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Editora ed = es.buscar(cod);
		try {
			es.excluir(ed);
			List<Editora> itens = es.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} 
	}
}