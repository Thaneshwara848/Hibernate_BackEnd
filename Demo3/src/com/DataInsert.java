package com;

import java.sql.*;
public class DataInsert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
			Statement stmt= con.createStatement();
			stmt.execute("insert into emp values(333,'Bharath','MP',555999,982345)");
			stmt.close();
			System.out.println("Data Inserted...!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
