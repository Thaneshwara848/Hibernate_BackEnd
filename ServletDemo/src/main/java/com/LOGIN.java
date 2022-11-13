package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LOGIN
 */
public class LOGIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LOGIN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String name=request.getParameter("uname");
		String desig= request.getParameter("udesig");
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from employee");
		while(rs.next())
		{
		if(name.equalsIgnoreCase(rs.getString(2)) && desig.equalsIgnoreCase(rs.getString(5)))
			{
			RequestDispatcher rd=request.getRequestDispatcher("HOME.html");
			rd.forward(request, response);
			}
			else{
				out.print("<h3 style='color:red'>invalid crdentials please try once again </h3>");
				RequestDispatcher rd= request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	
		
		
		
			
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
