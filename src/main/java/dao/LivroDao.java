package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Livro;

public interface LivroDao {
	public void inserirAtualizar(Livro x);
	public void excluir(Livro x);
	public Livro buscar(int cod);
	public List<Livro> buscarTodos();
	public Livro buscaTituloExato(String titulo);
	public Livro buscaLivroPorIsbn(String isbn);
	public List<Livro> buscarPorTitulo(String trecho);
	public List<Livro> buscarPorTituloValorMinimoValorMaximo(String trecho, BigDecimal vlrMin, BigDecimal vlrMax);
}