package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.transaction.managenent.DBConnection;

public class DynamicInput {
public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
	Connection con=DBConnection.getConnection();
	Statement smt=con.createStatement();
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	while(true)
	{
		System.out.print("Employee Number :");
		int eno=Integer.parseInt(bf.readLine());
		System.out.print("Employee Name :");
		String ename=bf.readLine();
		System.out.print("Employee Salary :");
		float eSalary=Float.parseFloat(bf.readLine());
		System.out.print("Employee Address :");
		String eAddress=bf.readLine();
		String query="insert into employee11 values("+eno+",'"+ename+"',"+eSalary+",'"+eAddress+"')";
		smt.executeUpdate(query);
		System.out.println("Employee Inserted Successfully");
		System.out.print("One More Employee[Yes/No]? :");
		String option=bf.readLine();
		if(option.equals("No"))
		{
			break;
		}
		
	}
	con.close();
	
}
}
