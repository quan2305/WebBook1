package JDBC_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

	public static Connection getJDBCConnector() throws ClassNotFoundException {
		final String url = "jdbc:mysql://localhost:3306/web_book";
		final String user = "root";
		final String password = "root";
		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main (String args[]) throws ClassNotFoundException  {
		Connection con = getJDBCConnector();
		
		if(con != null) {
			System.out.print("Success");
		} else {
			System.out.print("Fail");
		}
	}
}
