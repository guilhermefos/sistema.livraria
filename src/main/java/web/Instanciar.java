package web;

import javax.servlet.http.HttpServletRequest;

import dominio.Categoria;
import dominio.Editora;

public class Instanciar {

	public static Editora editora(HttpServletRequest request) {
		Editora aux = new Editora();
		String s;
		
		s = request.getParameter("codEditora");
		if (s!=null && !s.isEmpty()) {
			try {		//excessão de campo inválido no front end.
				aux.setCodEditora(Integer.parseInt(s));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		s = request.getParameter("nome");	//fazer para todos os atributos da classe.
		if (s!=null && !s.isEmpty()) {	
			aux.setNome(s);
		}
		return aux;	//retorna null se algum campo do objeto ficou vazio.
		
	}

	public static Categoria categoria(HttpServletRequest request) {
		Categoria aux = new Categoria();
		String s;
		
		s = request.getParameter("codCategoria");
		if (s!=null && !s.isEmpty()) {
			try {		//excessão de campo inválido no front end.
				aux.setCodCategoria(Integer.parseInt(s));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		s = request.getParameter("nome");	//Verificar como validar nome, digitando um número por ex.
		if (s!=null && !s.isEmpty()) {
			aux.setNome(s);
		}
		return aux;
		
	}
	
}
