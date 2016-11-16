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
import servico.ServicoException;


@WebServlet("/categoria/excluir")
public class CategoriaExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/listarCategoria.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		CategoriaServico cs = new CategoriaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Categoria cat = cs.buscar(cod);
		try {
			cs.excluir(cat);
			List<Categoria> itens = cs.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {	//método excluir deve lançar: throws ServicoException
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} 
	}
}