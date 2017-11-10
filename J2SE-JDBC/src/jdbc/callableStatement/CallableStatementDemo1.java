package jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.transaction.managenent.DBConnection;

public class CallableStatementDemo1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Connection con = DBConnection.getConnection();
	CallableStatement cst=con.prepareCall("{call getSalary(?,?)}");
	cst.setInt(1,111);
	cst.registerOutParameter(2, Types.FLOAT);
	cst.execute(); 
	System.out.println("Salary........."+cst.getFloat(2)); 
	con.close(); } 
}

