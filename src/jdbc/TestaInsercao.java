package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import modelo.Produto;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Produto prod = new Produto("cell", "xiaomi");
		try (Connection con = new ConnectionFactory().getConnection()) {
			ProdutoDAO produtoDao = new ProdutoDAO(con);
			produtoDao.salvar(prod);
			List<Produto> produtos = produtoDao.showAll();
			produtos.stream().forEach(System.out::println);
		}
	}

}
