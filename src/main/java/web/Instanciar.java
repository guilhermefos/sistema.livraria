package web;

import javax.servlet.http.HttpServletRequest;

import dominio.Editora;

public class Instanciar {

	public static Editora editora(HttpServletRequest request) {
		Editora aux = new Editora();
		String s;
		
		s = request.getParameter("codEditora");
		if (s!=null && !s.isEmpty()) {
			try {		//excess�o de campo inv�lido no front end.
				aux.setCodEditora(Integer.parseInt(s));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		s = request.getParameter("nome");	//Verificar como validar nome, digitando um n�mero por ex.
		if (s!=null && !s.isEmpty()) {
			aux.setNome(s);
		}
		return aux;
		
	}
	
}
