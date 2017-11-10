 package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Statement2 {

public static void main(String[] args) {
	
	try{
	Driver refDriver=new Driver();
	DriverManager.registerDriver(refDriver);
	
	String url="jdbc:mysql://localhost:3306/record_database?user=root&password=root";
	
	Connection con=DriverManager.getConnection(url);
	
	Statement smt=con.createStatement();
	
	String query="select * from record where EmployeeID=333";
	
	ResultSet rs=smt.executeQuery(query);
	
	while(rs.next())
	{
		int id=rs.getInt(1);
		String firstName=rs.getString(2);
		String lastName=rs.getString(3);
		String email=rs.getString(4);
		String city=rs.getString(5);
		
		System.out.println("Id::"+id+", FirstName::"+firstName+", LastName::"+lastName+", Email::"+email+", City::"+city);
		
	}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
}
}
