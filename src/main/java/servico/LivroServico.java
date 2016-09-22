package servico;

import java.util.List;

import dao.DaoFactory;
import dao.LivroDao;
import dao.Transaction;
import dao.impl.EM;
import dominio.Livro;

public class LivroServico {
	
	private LivroDao dao;
	
	public LivroServico() {
		dao = DaoFactory.criarLivroDao();
	}
	
	/**
	 * 
	 * Insert or Update Livro object
	 * 
	 * @param x Livro object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserirAtualizar(Livro x) 
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
	
	public void excluir(Livro x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Livro buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Livro> buscarTodos() {
		return dao.buscarTodos();
	}

}
