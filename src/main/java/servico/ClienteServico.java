package servico;

import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Cliente;

public class ClienteServico {
	
	private ClienteDao dao;
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	
	
	/**
	 * 
	 * Insert or Update Client object
	 * 
	 * @param x Cliente object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(Cliente x) 
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
	 * Delete Cliente object
	 * 
	 * @param x Cliente object from delete
	 * 
	 * @return void
	 * 
	 */
	public void excluir(Cliente x)
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
	 * Select a Cliente object
	 * 
	 * @param cod int to find
	 * 
	 */
	public Cliente buscar(int cod) 
	{
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos() {
		return dao.buscarTodos();
	}

}
