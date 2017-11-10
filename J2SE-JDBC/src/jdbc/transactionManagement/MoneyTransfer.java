package jdbc.transactionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoneyTransfer {

	public final static void moneyTransfer(long acc1, long acc2, int fund) {
		Connection con = null;
		try {
			con = MyDBConnection.getConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();

			int acc1_balance = accountSender(con, acc1);
			int acc2_balance = accountReciever(con, acc2);

			if (acc1_balance > fund)

			{
				int acc1Up = acc1_balance - fund;
				int acc2Up = acc2_balance + fund;

				int up = st.executeUpdate("update account set balance=" + acc1Up + " where acountNumber=" + acc1);

				int up1 = st.executeUpdate("update account set balance=" + acc2Up + " where acountNumber=" + acc2);

				// System.out.print (up+" "+up1);

				if (up == 1 && up1 == 1)

				{

					con.commit();
					System.out.println("*******: " + fund + " balance is successfully Transferred:*******");

				}

				else

				{

					con.rollback();

					System.out.println("rollback");

				}

			}

			else

			{
				System.out.println("You does not have sufficient balance !!! please deposit in your account.");
			}

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

	public static int accountSender(Connection con, long acc1) throws SQLException {
		String query1 = "select balance from account where acountNumber=?";
		PreparedStatement pmt1 = con.prepareStatement(query1);
		pmt1.setLong(1, acc1);
		ResultSet rs1 = pmt1.executeQuery();
		rs1.next();
		int acoountSender = rs1.getInt(1);
		return acoountSender;
	}

	public static int accountReciever(Connection con, long acc2) throws SQLException {
		String query2 = "select balance from account where acountNumber=?";
		PreparedStatement pmt2 = con.prepareStatement(query2);
		pmt2.setLong(1, acc2);
		ResultSet rs2 = pmt2.executeQuery();
		rs2.next();
		int acoountSender = rs2.getInt(1);
		return acoountSender;
	}

	public static void main(String args[])
	{
		long acc1 = 1054173;
		long acc2 = 1054572;
		int fund = 1000;
		moneyTransfer(acc1, acc2, fund);
	}
}
