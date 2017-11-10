package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ResultSetMetaData1 {
	
public static void main(String[] args) {
	try{
		Driver refDriver=new Driver();
		DriverManager.registerDriver(refDriver);
		
		String url="jdbc:mysql://localhost:3306/record_database?user=root&password=root";
		Connection con=DriverManager.getConnection(url);
		
		String query="select * from record";
		PreparedStatement pmt=con.prepareStatement(query);
		
		ResultSet rs=pmt.executeQuery();
		ResultSetMetaData rd=rs.getMetaData();
		DatabaseMetaData dbmd=con.getMetaData();  
		
		System.out.println("Total number of Column::"+rd.getColumnCount());
		System.out.println("Column name of 1 st column::"+rd.getColumnName(2));
		System.out.println("Coulumn type of 1 st column::"+rd.getColumnTypeName(2));
		
		System.out.println("*********************************************************");
		
		System.out.println("Driver Name: "+dbmd.getDriverName());  
		System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		System.out.println("UserName: "+dbmd.getUserName());  
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion()); 
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
}
