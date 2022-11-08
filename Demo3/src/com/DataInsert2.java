package com;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataInsert2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
			PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
			Scanner sc= new Scanner(System.in);
			
			System.out.print("Enter ID  : ");
			int id=sc.nextInt();
			
		    System.out.print("Enter Name : ");
			String name= sc.next();
			
			System.out.print("Enter Place :");
			String place= sc.next();
			
			System.out.print("Enter Pin :");
			int pin = sc.nextInt();
			
			System.out.print("Enter Phone :");
			int ph= sc.nextInt();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, place);
			pstmt.setInt(4, pin);
			pstmt.setInt(5, ph);
			
			pstmt.execute();
			pstmt.close();
			System.out.println("Data inserted...!");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


// CRUD
// Cretat// insert 
//Update
// Delete
//Read

