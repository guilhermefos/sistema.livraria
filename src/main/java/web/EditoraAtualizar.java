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
import servico.ValidacaoException;

@WebServlet("/editora/atualizar")
public class EditoraAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/editora/listarEditora.jsp";
	private static String FORM = "/editora/formEditar.jsp";
	private static String ERRO = "/publico/erro.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EditoraServico es = new EditoraServico();
		Editora x = Instanciar.editora(request);

		try {
			es.validar(x);
			es.Atualizar(x);
			List<Editora> itens = es.buscarTodosOrdenadosPorNome();
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