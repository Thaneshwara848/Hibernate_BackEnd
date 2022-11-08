import java.sql.*;
public class Employee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend","root","root");
			Statement stmt = con.createStatement();
			stmt.execute("insert into employee values(900,'Darshan',35,45000,'Dev')");
			stmt.close();
			System.out.println("Data Inserted...!");
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
	}
}
