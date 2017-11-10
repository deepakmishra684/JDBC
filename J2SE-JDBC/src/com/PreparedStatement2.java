package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class PreparedStatement2 {

	public static void main(String[] args) {
		try{
			Driver refDriver=new Driver();
			DriverManager.registerDriver(refDriver);
			
			String url="jdbc:mysql://localhost:3306/record_database?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			
			String query="select * from record where EmployeeId=?";
			PreparedStatement pmt=con.prepareStatement(query);
			
			pmt.setInt(1, 444);
			ResultSet rs=pmt.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String firstName=rs.getString(2);
				String lastName=rs.getString(3);
				String email=rs.getString(4);
				String city=rs.getString(5);
				System.out.println("Record ::"+id+" "+firstName+" "+lastName+" "+email+" "+city);
			}
			
		}
        catch(SQLException e)
		{
        	e.printStackTrace();
        	}
		}
}
