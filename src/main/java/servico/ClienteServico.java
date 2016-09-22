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
	 * @param x Client object from update
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
	
	public void excluir(Cliente x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Cliente buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos() {
		return dao.buscarTodos();
	}

}
