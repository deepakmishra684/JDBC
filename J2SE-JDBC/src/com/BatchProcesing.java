package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;

public class BatchProcesing {
	public static void main(String[] args) {
		
	try{
	Driver refDriver=new Driver();
	DriverManager.registerDriver(refDriver);
	
	String url="jdbc:mysql://localhost:3306/record_database?user=root&password=root";
	
	Connection con=DriverManager.getConnection(url);
	
	DatabaseMetaData metaData = (DatabaseMetaData) con.getMetaData();
	String dbProduct = metaData.getDatabaseProductName();
	String dbVersion = metaData.getDatabaseProductVersion();
	String driverName = metaData.getDriverName();
	String driverVersion = metaData.getDriverVersion();
	System.out.println(dbProduct);
	System.out.println(dbVersion);
	System.out.println(driverName);
	System.out.println(driverVersion);
	
	Statement smt=con.createStatement();
	String query1="insert into record values(666,'Monika','Dixit','dm22684@gmail.com','Mumbai')";
	String query2="insert into record values(777,'Sun','Dixit','dm22684@gmail.com','Banglore')";
	smt.addBatch(query1);
	smt.addBatch(query2);
	
	smt.executeBatch();

	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
}