package servico;

import java.math.BigDecimal;
import java.util.List;

import dao.DaoFactory;
import dao.LivroDao;
import dao.Transaction;
import dominio.Livro;

public class LivroServico {
	
	private LivroDao dao;
	
	public LivroServico() {
		dao = DaoFactory.criarLivroDao();
	}
	
	/**
	 * 
	 * Insert Livro object
	 * 
	 * @param x Livro object from update
	 * 
	 * @return void
	 * 
	 */
	public void inserir(Livro x) throws ServicoException {
		try {
			Livro aux = dao.buscaLivroPorIsbn(x.getIsbn());
			if (aux != null) {
				throw new ServicoException("Já existe um livro com esse ISBN! Inserção cancelada.", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * Update Livro object
	 * 
	 * @param x Livro object from update
	 * 
	 * @return void
	 * 
	 */
	public void atualizar(Livro x) throws ServicoException {
		try {
			Livro aux = dao.buscaLivroPorIsbn(x.getIsbn());
			if (aux != null && aux.getCodLivro() != x.getCodLivro()) {
				throw new ServicoException("Já existe um livro com esse ISBN! Atualização cancelada.", 1);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * Delete Livro object
	 * 
	 * @param x Livro object from delete
	 * 
	 * @return void
	 * 
	 */
	public void excluir(Livro x) 
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
	 * Select a Livro object
	 * 
	 * @param cod int to find
	 * 
	 * @return Livro object
	 * 
	 */
	public Livro buscar(int cod) 
	{
		return dao.buscar(cod);
	}
	
	/**
	 * 
	 * Select all Livro objects
	 * 
	 * @return List of Livro objects
	 * 
	 */
	public List<Livro> buscarTodos() 
	{
		return dao.buscarTodos();
	}
	
	/**
	 * 
	 * Select all Livro per title and dairy value objects
	 * 
	 * @return List of Livro objects
	 * 
	 */
	public List<Livro> buscarPorTituloValorMinimoValorMaximo(String trecho, BigDecimal valorMin, BigDecimal valorMin2) 
	{
		return dao.buscarPorTituloValorMinimoValorMaximo(trecho, valorMin, valorMin2);
	}

}
