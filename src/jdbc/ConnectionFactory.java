package jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	final String stringConexao = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
	public DataSource dataSource;
	public ConnectionFactory() {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setJdbcUrl(stringConexao);
		pool.setUser("root");
		pool.setPassword("root");
		pool.setMaxPoolSize(15);
		this.dataSource = pool;
	}

	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}
