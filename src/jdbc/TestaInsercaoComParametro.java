package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		try (Connection con = new ConnectionFactory().getConnection()) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement("insert into produto (nome, descricao) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS)) {
				addVariavel("Smart tv", "45 polegadas", ps);
				addVariavel("radio", "a pilha", ps);
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}
		}

		TestaListagem.main(null);
	}

	private static void addVariavel(String nome, String descricao, PreparedStatement ps) throws SQLException {
		ps.setString(1, nome);
		ps.setString(2, descricao);
		ps.execute();
		try (ResultSet rs = ps.getGeneratedKeys()) {
			rs.next();
			System.out.println("id criado: " + rs.getInt(1));
		}
	}

}
