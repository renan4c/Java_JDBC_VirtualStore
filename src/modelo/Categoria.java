package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return String.format("Categoria ID(%d) %s", id, nome);
	}

	public void addProduto(Produto prod) {
		this.produtos.add(prod);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String getNome() {
		return nome;
	}
}
