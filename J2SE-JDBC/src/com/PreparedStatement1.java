package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class PreparedStatement1 {

	public static void main(String[] args) {
		try{
			Driver refDriver=new Driver();
			DriverManager.registerDriver(refDriver);
			
			String url="jdbc:mysql://localhost:3306/record_database?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			/*insert record into Record_table
			String query="insert into record values(?,?,?,?,?)";
			PreparedStatement pmt=con.prepareStatement(query);
			pmt.setInt(1, 444);
			pmt.setString(2, "Chandu");
			pmt.setString(3, "Khushvaha");
			pmt.setString(4, "ckk@gmail.com");
			pmt.setString(5, "Alahabad");*/
			
			/*update record into Record_table
			String query="update record set lastName=? where EmployeeId=?";
			PreparedStatement pmt=con.prepareStatement(query);
			pmt.setString(1, "Chand");
			pmt.setInt(2, 444);
		   */
			
			String query="delete from record where EmployeeID=?";
			PreparedStatement pmt=con.prepareStatement(query);
			pmt.setInt(1,222);
			int i=pmt.executeUpdate();
			System.out.println(i+"Record inserted");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
