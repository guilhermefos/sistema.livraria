package servico;

import java.util.List;

import dao.CategoriaDao;
import dao.DaoFactory;
import dao.Transaction;
import dao.impl.EM;
import dominio.Categoria;

public class CategoriaServico {
	
	private CategoriaDao dao;
	
	public CategoriaServico() {
		dao = DaoFactory.criarCategoriaDao();
	}
	
	/**
	 * 
	 * Insert or Update Categoria object
	 * 
	 * @param x Categoria object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(Categoria x) 
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
	 * Delete Categoria object
	 * 
	 * @param x Categoria object from delete
	 * 
	 * @return void
	 * 
	 */
	public void excluir(Categoria x) 
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
	
	public Categoria buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Categoria> buscarTodos() {
		return dao.buscarTodos();
	}

}
