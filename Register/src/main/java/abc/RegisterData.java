package abc;

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

/**
 * Servlet implementation class RegisterData
 */
public class RegisterData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterData() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("uid");
		String name= request.getParameter("uname");
		String age = request.getParameter("uage");
		String salary = request.getParameter("usalary");
		String desig = request.getParameter("udesig");
		
		PrintWriter out= response.getWriter();
		out.print("HI Mr ! "+name + " Data Inserted Successfully....!");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root","root");
			PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, age);
			pstmt.setString(4, salary);
			pstmt.setString(5, desig);
						
			pstmt.execute();
			pstmt.close();
			System.out.println("Data inserted...!");
						
		}
		catch (Exception e) {
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
