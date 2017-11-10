package com;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Statement1 {

public static void main(String[] args) {
	
	try{
		Driver refDriver=new Driver();
		DriverManager.registerDriver(refDriver);
		
		String url="jdbc:mysql://localhost:3306/record_database?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		Statement smt=con.createStatement();
		
		/*creating table Record_table in database*/
		//String query="create table Record1(EmployeeID int,FirstName varchar(2),LastName varchar(255),Email varchar(255),City varchar(255))";
		
		//insert record into the Record_table*/
        String query="insert into record1 values(222,'   ra   ','Dixit','dm22684@gmail.com','Mumbai')";
		
	/*	update record in to the Record_Table
		//String query="update record set FirstName='Mahta' where EmployeeID=333";
		
		delete record from table Record_Table 
		String query="delete from record where EmployeeID=111";*/
		int i=smt.executeUpdate(query);
		
		System.out.println(i+"create table");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
}
}
