package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.transaction.managenent.DBConnection;

public class DynamicInput3 {

	public static void main(String[] args) throws Exception {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from employee11");
		System.out.println("***************************************************");
		System.out.println("Data Before Updations");
		System.out.println("----------------------------------");
		System.out.println("ENO     ENAME     ESAL     EADDR");
		System.out.println("---------------------------------------");
		while (rs.next()) {
			System.out.println(
					rs.getInt(1) + "     " + rs.getString(2) + "     " + rs.getFloat(3) + "     " + rs.getString(4));
		}
		System.out.println("***************************************************");
		System.out.println("Application is in Pausing state, please update database");
		System.in.read();
		rs.beforeFirst();
		System.out.println("Data After Updations");
		System.out.println("ENO     ENAME     ESAL     EADDR");
		System.out.println("---------------------------------------");
		while (rs.next()) {
			rs.refreshRow();
			System.out.println(
					rs.getInt(1) + "     " + rs.getString(2) + "     " + rs.getFloat(3)
					+ "     " + rs.getString(4));
		}
		con.close();
	}
}
