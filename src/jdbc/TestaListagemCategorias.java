package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import modelo.Categoria;

public class TestaListagemCategorias {
	public static void main(String[] args) throws SQLException {
		try(Connection con = new ConnectionFactory().getConnection()) {
			List<Categoria> cat = new CategoriaDAO(con).showAll();
			cat.stream().forEach(System.out::println);
		}
	}
}
