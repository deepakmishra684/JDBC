package jdbc.callableStatement;

import java.sql.SQLException;

import javax.sql.PooledConnection;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class DbConnectionPool {
	public final static String DB_URL = "jdbc:mysql://localhost:3306/record_database";
	public final static String DB_USERNAME = "root";
	public final static String DB_PASSWORD = "root";

	public static PooledConnection getPoolConnection() throws SQLException {
		PooledConnection pc = null;
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL(DB_URL);
		ds.setUser(DB_USERNAME);
		ds.setPassword(DB_PASSWORD);
		pc = ds.getPooledConnection();

		return pc;
	}
}
