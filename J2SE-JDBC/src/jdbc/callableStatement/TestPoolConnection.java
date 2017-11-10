package jdbc.callableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

public class TestPoolConnection {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PooledConnection pc = DbConnectionPool.getPoolConnection();
		con = pc.getConnection();

		Statement smt = con.createStatement();
		String query = "select * from employee11 where eno=111";
		ResultSet rs = smt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
			                    + "  " + rs.getFloat(3) + "  " + rs.getString(4));
		}
	}
}
