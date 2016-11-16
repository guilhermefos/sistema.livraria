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

import dominio.Categoria;
import servico.CategoriaServico;

@WebServlet("/categoria/filtrar")
public class CategoriaFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/listarCategoria.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoriaServico cs = new CategoriaServico();
		String nome = request.getParameter("busca");
		List<Categoria> itens = cs.buscaPorNome(nome);
		request.setAttribute("itens", itens);	//mostra no listar somente os itens que veio da busca e não tudo agora.
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}