package dao;

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
