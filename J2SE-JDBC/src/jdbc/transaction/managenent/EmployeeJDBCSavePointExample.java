package jdbc.transaction.managenent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class EmployeeJDBCSavePointExample {
	public static final String INSERT_LOGS_QUERY = "insert into Logs (message) values (?)";

	public static void main(String[] args) {

		Connection con = null;
		Savepoint savepoint = null;
		try {
			con = DBConnection.getConnection();

			// set auto commit to false
			con.setAutoCommit(false);

			EmployeeJDBCInsertExample.insertEmployeeData(con, 9, "CKK");

			EmployeeJDBCInsertExample.insertAddressData(con, 9, "BKT",
					"Lucknow", "India");

			// if code reached here, means main work is done successfully
			savepoint = con.setSavepoint("Employee_SavePoint");

			insertLogData(con);

			// now commit transaction
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (savepoint == null) {
					// SQLException occurred in saving into Employee or Address tables
					con.rollback();
					System.out
							.println("JDBC Transaction rolled back successfully");
				} else {
					// exception occurred in inserting into Logs table
					// we can ignore it by rollback to the savepoint
					con.rollback(savepoint); 
					
					//lets commit now
					con.commit();
				}
			} catch (SQLException e1) {
				System.out.println("SQLException in rollback" + e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertLogData(Connection con)
			throws SQLException {
		PreparedStatement stmt = con.prepareStatement(INSERT_LOGS_QUERY);
		
		//message is very long, will throw SQLException
		stmt.setString(1, "    for ID             " );

		stmt.executeUpdate();
		System.out.println("Logs Data inserted successfully for ID=");

		stmt.close();
	}
}
