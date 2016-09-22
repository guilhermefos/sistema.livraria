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
	
	/**
	 * 
	 * Delete Editora object
	 * 
	 * @param x Editora object from delete
	 * 
	 * @return void
	 * 
	 */
	public void excluir(Editora x) 
	{
		try
		{
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch(RuntimeException e)
		{
			Transaction.rollback();
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * Select a Editora object
	 * 
	 * @param cod int to find
	 * 
	 * @return Editora object
	 * 
	 */
	public Editora buscar(int cod) 
	{
		return dao.buscar(cod);
	}
	
	public List<Editora> buscarTodos() {
		return dao.buscarTodos();
	}

}
