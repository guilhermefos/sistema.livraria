package dao;

import java.util.List;

import dominio.Editora;

public interface EditoraDao {
	
	public void inserirAtualizar(Editora x);
	public void excluir(Editora x);
	public Editora buscar(int cod);
	public List<Editora> buscarTodos();

}
