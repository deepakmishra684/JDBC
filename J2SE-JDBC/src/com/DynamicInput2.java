package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.transaction.managenent.DBConnection;

public class DynamicInput2 {

	public static void main(String[] args) throws Exception {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from employee11");
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getInt(1));
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getInt(1));
		rs.last();
		System.out.println(rs.getInt(1));
		rs.first();
		System.out.println(rs.getInt(1));
		rs.absolute(3);
		System.out.println(rs.getInt(1));
		rs.absolute(-3);
		System.out.println(rs.getInt(1));
		rs.first();
		rs.relative(2);
		System.out.println(rs.getInt(1));
		rs.last();
		rs.relative(-2);
		System.out.println(rs.getInt(1));
	}
}
