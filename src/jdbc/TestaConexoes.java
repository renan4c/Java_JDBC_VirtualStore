package jdbc;

import java.sql.SQLException;

public class TestaConexoes {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory con = new ConnectionFactory();
		for (int i = 0; i < 20; i++) {
			con.getConnection();
			System.out.println("i:" + i);
		}
	}
}
