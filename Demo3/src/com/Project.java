package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
class Emp
{
	Emp()
	{
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
			con.setAutoCommit(true);
			pstmt.close();
			System.out.println("Data inserted...!");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static void display() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
			Statement stmt= con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from emp");
			while(rs.next()) {
				
System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" :"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getInt(5));
			}
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
	static void delete()
	{
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
public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int ch;
		do {
			System.out.println("Insert");
			System.out.println("Display");
			System.out.println("Raise Salary :");
			System.out.println("Delete ");
			
			System.out.println("Enter Choice ");
			ch= sc.nextInt();
			if(ch==1)
			{
				Emp e = new Emp();
			}
			if (ch==2)
			{
				Emp.display();
			}
			if(ch==3)
			{
				
			}
			if(ch==4)
			{
				Emp.delete();
			}
			if(ch>15)
			{
				System.exit(0);
				System.out.println("Thank you ");
			}
		}while(ch<=5);
	}

}
