package JDBC_book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Filter.BCrypt;
import HomeBook.controller.Password;
import HomeBook.model.User;

public class listUser {
	
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<User> getUser(String user) throws SQLException{
		List<User> list = new ArrayList<>();
		
		try {
			
			new JDBCConnector();
			conn = JDBCConnector.getJDBCConnector();
			
			String query = "select * from `web_book`.`user`"
					+ " where `web_book`.`user`.`email` =? ";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void addUser(String user, String pass) throws ClassNotFoundException, SQLException {
		new JDBCConnector();
		conn = JDBCConnector.getJDBCConnector();
		
		String hashPass = Password.hashPassword(pass);
		
		String query = "insert into `web_book`.`user` (email, password) " +
					"values( ?, ?)" ;
		
		ps = conn.prepareStatement(query);
		ps.setString(1, user);
		ps.setString(2, hashPass);
		ps.execute();
		
		conn.close();
	}
	
}
