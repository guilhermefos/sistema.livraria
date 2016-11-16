package servico;

import java.util.ArrayList;
import java.util.List;

import dao.CategoriaDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Categoria;

public class CategoriaServico {
	
	private CategoriaDao dao;
	
	public CategoriaServico() {
		dao = DaoFactory.criarCategoriaDao();
	}
	
	public void validar(Categoria x) throws ValidacaoException {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome() == null ) {	// Se for null o objeto foi criado nulo. trata retorno da classe instanciar.
			erros.add("Favor preencher o campo nome");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	public void inserir(Categoria x) throws ServicoException {
		
		try {
			//EXCEÇÃO: 3.1.1 - NOME JÁ CADASTRADO.
			Categoria aux = dao.buscarNomeExato(x.getNome());
			if( aux != null) {
				throw new ServicoException("Já existe uma Categoria com esse NOME", 1);
			}
			
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			
		} catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();	//desfaz caso tenha erro.
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void Atualizar(Categoria x) throws ServicoException {
		
		try {
			//EXCEÇÂO 3.3.2 - NOME JÁ CADASTRADO.
			Categoria aux = dao.buscarNomeExatoDiferente(x.getCodCategoria(), x.getNome());
			if( aux != null) {
				throw new ServicoException("Já existe uma Categoria diferente com esse nome", 2);
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			
		} catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();	//desfaz caso tenha erro.
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Categoria x) throws ServicoException {
		
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
			
		} catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();	//desfaz caso tenha erro.
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Categoria buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Categoria> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Categoria> buscaPorNome(String nome) {
		return dao.buscaPorNome(nome);
	}
	
	public List<Categoria> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}

}
