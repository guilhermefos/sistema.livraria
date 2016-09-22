package servico;

import java.util.List;

import dao.EditoraDao;
import dao.Transaction;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Editora;

public class EditoraServico {
	
	private EditoraDao dao;
	
	public EditoraServico() {
		dao = DaoFactory.criarEditoraDao();
	}
	
	/**
	 * 
	 * Insert or Update Editora object
	 * 
	 * @param x Editora object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(Editora x) 
	{
		try
		{
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e)
		{
			Transaction.rollback();
			System.out.println("Erro: " + e.getMessage());
		}
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
