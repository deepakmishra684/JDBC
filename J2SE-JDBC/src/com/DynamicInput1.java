package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.transaction.managenent.DBConnection;

public class DynamicInput1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from employee11");
		System.out.println("***************************************************");
		System.out.println("Data In Forward Direction");
		System.out.println("----------------------------------");
		System.out.println("eno\tename\t\tesalary\t\teadress");
		System.out.println("----------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" 
		                       + rs.getFloat(3) + "\t\t" + rs.getString(4));
		}
		System.out.println("***************************************************");
		System.out.println("Data In Backward Direction");
		System.out.println("-------------------------------");
		System.out.println("eno\tename\t\tesalary\t\teaddress");
		System.out.println("-------------------------------");
		while (rs.previous()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getFloat(3) 
			                   + "\t\t" + rs.getString(4));
		}
		con.close();
	}
}
