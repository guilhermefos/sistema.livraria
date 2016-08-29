package dao;

import java.util.List;

import dominio.ItemEmprestimo;

public interface ItemEmprestimoDao {
	
	public void inserirAtualizar(ItemEmprestimo x);
	public void excluir(ItemEmprestimo x);
	public ItemEmprestimo buscar(int cod);
	public List<ItemEmprestimo> buscarTodos();

}
