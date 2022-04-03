package jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		Statement stm = con.createStatement();
		stm.execute("delete from produto where id > 2");
		Integer updateCount = stm.getUpdateCount();
		System.out.println("linhas modificadas: "+updateCount);
		TestaListagem.main(null);
	}

}
