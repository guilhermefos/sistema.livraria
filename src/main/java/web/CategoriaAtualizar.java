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
import servico.ServicoException;
import servico.ValidacaoException;

@WebServlet("/categoria/atualizar")
public class CategoriaAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/categoria/listarCategoria.jsp";
	private static String FORM = "/categoria/formEditar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoriaServico cs = new CategoriaServico();
		Categoria x = Instanciar.categoria(request);

		try {
			cs.validar(x);
			cs.Atualizar(x);
			List<Categoria> itens =	cs.buscarTodosOrdenadosPorNome();
			request.setAttribute("itens", itens);
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {	//validação regra de negócio
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(ERRO).forward(request, response);
		} catch (ValidacaoException e) { //validação de dados.
			request.setAttribute("erros", e.getErros());
			request.setAttribute("item", x);
			request.getRequestDispatcher(FORM).forward(request, response);
		}
		
		
	}
}