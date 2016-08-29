package dao;

import java.util.List;

import dominio.Emprestimo;

public interface EmprestimoDao {
	
	public void inserirAtualizar(Emprestimo x);
	public void excluir(Emprestimo x);
	public Emprestimo buscar(int cod);
	public List<Emprestimo> buscarTodos();

}
