package servico;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.EditoraDao;
import dao.Transaction;
import dominio.Editora;

public class EditoraServico {
	
	private EditoraDao dao;
	
	public EditoraServico() {
		dao = DaoFactory.criarEditoraDao();
	}
	
	public void validar(Editora x) throws ValidacaoException {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome() == null || x.getNome().isEmpty()) {	//incluir x.getNome().isEmpty()
			erros.add("Favor preencher o campo nome");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	public void inserir(Editora x) throws ServicoException {
		try {
			//EXCEÇÃO: 3.1.1 - NOME JÁ CADASTRADO.
			Editora aux = dao.buscarNomeExato(x.getNome());
			if( aux != null) {
				throw new ServicoException("Já existe uma Editora com esse NOME", 1);
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

	public void Atualizar(Editora x) throws ServicoException {
		try {
			//EXCEÇÂO 3.3.2 - NOME JÁ CADASTRADO.
			Editora aux = dao.buscarNomeExatoDiferente(x.getCodEditora(), x.getNome());
			if( aux != null) {
				throw new ServicoException("Já existe uma Editora diferente com esse nome", 2);
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
	
	public void excluir(Editora x) {
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
	
	public Editora buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Editora> buscarTodos() {
		return dao.buscarTodos();
	}

	public List<Editora> buscaPorNome(String nome) {
		return dao.buscaPorNome(nome);
	}
	
	public List<Editora> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}
}
