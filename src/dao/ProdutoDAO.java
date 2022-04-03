package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDAO {
	private Connection con;

	public ProdutoDAO(Connection con) {
		this.con = con;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.execute();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				rs.next();
				produto.setId(rs.getInt(1));
			}
		}
	}
	
	public List<Produto> showAll() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		try(PreparedStatement st = con.prepareStatement("select * from produto")) {
			st.execute();
			try(ResultSet rs = st.getResultSet()) {
				while(rs.next() ) {
					Produto prod = new Produto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"));
					produtos.add(prod);
				}
			}
		}
		return produtos;
	}
}
