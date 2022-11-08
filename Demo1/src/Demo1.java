import java.sql.*;
public class Demo1 {
	
	public static void main(String[] args) {
		
		
	// 5 steps
	try {
		//Load the driver
		Class.forName("com.mysql.jdbc.Driver");
		//Create the connection 
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabackend", "root", "root");
		// create the statement 
		Statement stmt = con.createStatement();
		// executr the query 
		stmt.execute("insert into employee values(700,'Charan',45,80000,'Manager');");
		// close the connection 
		stmt.close();
		System.out.println("Data Inserted Succfully..!");
			
	} catch (Exception e) {
		System.out.println(e);
	}

	}

//}
//			9:00
//				break 20 minuts 
//					will back at 
//						9 : 20 
	
	
	
	