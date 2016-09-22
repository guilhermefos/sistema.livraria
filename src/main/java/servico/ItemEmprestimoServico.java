package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemEmprestimoDao;
import dao.Transaction;
import dao.impl.EM;
import dominio.ItemEmprestimo;

public class ItemEmprestimoServico {
	
	private ItemEmprestimoDao dao;
	
	public ItemEmprestimoServico() {
		dao = DaoFactory.criarItemEmprestimoDao();
	}
	
	/**
	 * 
	 * Insert or Update ItemEmprestimo object
	 * 
	 * @param x ItemEmprestimo object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(ItemEmprestimo x) 
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
	 * Delete ItemEmprestimo object
	 * 
	 * @param x ItemEmprestimo object from delete
	 * 
	 * @return void
	 * 
	 */
	public void excluir(ItemEmprestimo x) 
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
	 * Select a ItemEmprestimo object
	 * 
	 * @param cod int to find
	 * 
	 * @return ItemEmprestimo object
	 * 
	 */
	public ItemEmprestimo buscar(int cod) 
	{
		return dao.buscar(cod);
	}
	
	/**
	 * 
	 * Select all ItemEmprestimo objects
	 * 
	 * @return List of ItemEmprestimo objects
	 * 
	 */
	public List<ItemEmprestimo> buscarTodos() 
	{
		return dao.buscarTodos();
	}

}
