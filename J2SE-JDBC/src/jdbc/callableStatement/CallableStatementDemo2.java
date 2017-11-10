package jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.transaction.managenent.DBConnection;

public class CallableStatementDemo2 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection con = DBConnection.getConnection();
	
	
	CallableStatement ct=con.prepareCall("{?=call getAvg(?,?)}");
	ct.setInt(1, 222);
	ct.setInt(2, 222);
	ct.registerOutParameter(1,Types.INTEGER);
	ct.execute();
	System.out.println("Avarage Salary......."+ct.getInt(1));
	con.close();
}
}
