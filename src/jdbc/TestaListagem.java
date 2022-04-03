package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stm = con.prepareStatement("select * from produto");
		stm.execute();
		ResultSet rs = stm.getResultSet();
		
		while (rs.next()) {
			Integer id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao = rs.getString("DESCRICAO");
			
			System.out.println(id + " - " + nome + " - " + descricao);
			
		}
		
		con.close();
	}
}
