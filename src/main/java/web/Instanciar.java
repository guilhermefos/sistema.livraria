package web;

import javax.servlet.http.HttpServletRequest;

import dominio.Editora;

public class Instanciar {

	public static Editora editora(HttpServletRequest request) {
		Editora aux = new Editora();
		String s;
		
		s = request.getParameter("codEditora");
		if (s!=null && !s.isEmpty()) {
			aux.setCodEditora(Integer.parseInt(s));
		}
		
		s = request.getParameter("nome");
		if (s!=null && !s.isEmpty()) {
			aux.setNome(s);
		}
		return aux;
		
	}
	
}
