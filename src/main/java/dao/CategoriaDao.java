package dao;

import java.util.List;

import dominio.Categoria;

public interface CategoriaDao {
	
	public void inserirAtualizar(Categoria x);
	public void excluir(Categoria x);
	public Categoria buscar(int cod);
	public List<Categoria> buscarTodos();
	
	public List<Categoria> buscaPorNome(String nome);
	public List<Categoria> buscarTodosOrdenadosPorNome();
	public Categoria buscarNomeExato(String nome);
	public Categoria buscarNomeExatoDiferente(Integer codCategoria, String nome);

}
