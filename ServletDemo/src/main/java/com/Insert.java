package com;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Insert() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id= Integer.parseInt(request.getParameter("uid"));
	String name=request.getParameter("uname");
	int age= Integer.parseInt(request.getParameter("uage"));
	int salary= Integer.parseInt(request.getParameter("usalary"));
	String desig = request.getParameter("udesig");
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
		PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		Scanner sc= new Scanner(System.in);
		
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, age);
		pstmt.setInt(4, salary);
		pstmt.setString(5, desig);
		
		pstmt.execute();
		pstmt.close();
		System.out.println("Data inserted...!");
		PrintWriter out=response.getWriter();
		out.print("<a href='HOME.html'>HOME PAGE </a>");
		
//		INSERT
//		UPDATE
//		DELETE
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	PrintWriter out= response.getWriter();
	
	out.print("Data Inserted Sucessfully....!");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}
