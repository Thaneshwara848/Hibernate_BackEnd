package com;

import java.util.*;
import java.sql.*;

public class DemoUpdate1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
			PreparedStatement pstmt=con.prepareStatement("update emp set phone = ?  where id=?");
			Scanner sc= new Scanner(System.in);
			
			System.out.print("Enter ID :");
			int id=sc.nextInt();
			
			System.out.print("Enter Phone : ");
			int phone= sc.nextInt();
			
			pstmt.setInt(1, phone);
			pstmt.setInt(2, id);
			
			pstmt.execute();
			pstmt.close();
			System.out.println("Data Updated...!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


