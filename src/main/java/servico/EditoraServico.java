package servico;

import java.util.List;

import dao.EditoraDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Editora;

public class EditoraServico {
	
	private EditoraDao dao;
	
	public EditoraServico() {
		dao = DaoFactory.criarEditoraDao();
	}
	
	public void inserirAtualizar(Editora x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Editora x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Editora buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Editora> buscarTodos() {
		return dao.buscarTodos();
	}

}
