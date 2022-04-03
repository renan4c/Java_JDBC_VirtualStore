package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import modelo.Categoria;
import modelo.Produto;

public class TestaCategoriaProduto {
	public static void main(String[] args) throws SQLException {
		try(Connection con = new ConnectionFactory().getConnection() ) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			List<Categoria> categorias = categoriaDAO.listaCategoriaProdutos();
			for (Categoria categoria : categorias) {
				System.out.println(categoria);
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(produto);
				}
			}
		}
	}
}
