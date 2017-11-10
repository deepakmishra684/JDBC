package jdbc.transaction.managenent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeJDBCInsertExample {
	public static final String INSERT_EMPLOYEE_QUERY = "insert into EmployeeT (empId, name) values (?,?)";

	public static final String INSERT_ADDRESS_QUERY = "insert into AddressT (empId, address, city, country) values (?,?,?,?)";

	public static void main(String[] args) {

		Connection con = null;
		try {
			con = DBConnection.getConnection();

			insertEmployeeData(con, 2, "Deepak");

			insertAddressData(con, 2, "BKT", "Lucnow", "India");
		} catch (SQLException | ClassNotFoundException e) {
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

	public static void insertAddressData(Connection con, int id, String address, String city, String country)
			throws SQLException {
		PreparedStatement stmt = con.prepareStatement(INSERT_ADDRESS_QUERY);
		stmt.setInt(1, id);
		stmt.setString(2, address);
		stmt.setString(3, city);
		stmt.setString(4, country);

		stmt.executeUpdate();

		System.out.println("Address Data inserted successfully for ID=" + id);
		stmt.close();
	}

	public static void insertEmployeeData(Connection con, int id, String name) throws SQLException {
		PreparedStatement stmt = con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		stmt.setInt(1, id);
		stmt.setString(2, name);

		stmt.executeUpdate();

		System.out.println("Employee Data inserted successfully for ID=" + id);
		stmt.close();
	}
}