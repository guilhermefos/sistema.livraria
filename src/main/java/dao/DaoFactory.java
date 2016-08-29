package dao;

import dao.impl.CategoriaDaoImpl;
import dao.impl.ClienteDaoImpl;
import dao.impl.EditoraDaoImpl;
import dao.impl.EmprestimoDaoImpl;
import dao.impl.ItemEmprestimoDaoImpl;
import dao.impl.LivroDaoImpl;

public class DaoFactory {
	
	public static LivroDao criarLivroDao() {
		return new LivroDaoImpl();
	}

	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}

	public static EditoraDao criarEditoraDao() {
		return new EditoraDaoImpl();
	}
	
	public static CategoriaDao criarCategoriaDao() {
		return new CategoriaDaoImpl();
	}
	
	public static EmprestimoDao criarEmprestimoDao() {
		return new EmprestimoDaoImpl();
	}
	
	public static ItemEmprestimoDao criarItemEmprestimoDao(){
		return new ItemEmprestimoDaoImpl();
	}

}
