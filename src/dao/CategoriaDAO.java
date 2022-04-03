package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDAO {
	Connection con;
	public CategoriaDAO(Connection con) {
		this.con = con;
	}
	public List<Categoria> showAll() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from categoria";
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			ps.execute();
			try(ResultSet rs = ps.getResultSet()) {
				while(rs.next()) {
					Categoria cat = new Categoria(rs.getInt(1), rs.getString(2));
					categorias.add(cat);
				}
			}
		}
		return categorias;
	}
	public List<Categoria> listaCategoriaProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria cat = null;
		String sql = "select c.id, c.nome, p.id, p.nome, p.descricao from categoria c join produto p on c.id = p.categoria_id order by 2";
		String ultima = null;
		try(PreparedStatement ps = con.prepareStatement(sql)) {
			ps.execute();
			try(ResultSet rs = ps.getResultSet()) {
				while(rs.next()) {
					if(ultima == null || !rs.getString(2).equals(ultima)) {
						cat = new Categoria(rs.getInt(1), rs.getString(2));
						ultima = cat.getNome();
						categorias.add(cat);
					}
					Produto prod = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));
					cat.addProduto(prod);
				}
			}
		}
		return categorias;
	}
}





















