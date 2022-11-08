package com;
import java.util.*;
import java.sql.*;
public class DataDelete {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
			PreparedStatement pstmt=con.prepareStatement("delete from emp where id= ? ");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter ID  : ");
			int id= sc.nextInt();
			
			pstmt.setInt(1, id);
			
			System.out.println("DO you Really Want to Delete  ? y/n ");
			String ch= sc.next();
			if(ch.equalsIgnoreCase("y")|| ch.equalsIgnoreCase("yes"))
			{
				pstmt.execute();
				pstmt.close();
				System.out.println("Data Deleted ...!");
			}
			else {
				System.out.println("let him enjoy some more day in the same company ");
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


