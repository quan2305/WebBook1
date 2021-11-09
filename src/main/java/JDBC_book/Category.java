package JDBC_book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import HomeBook.model.Book;
import HomeBook.model.Category_object;

public class Category {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Category_object> getCategory() throws SQLException{
		List<Category_object> list = new ArrayList<>();
		String query = "Select * from category";
		

		try {
			new JDBCConnector();
			conn = JDBCConnector.getJDBCConnector();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Category_object(rs.getInt(1),
						rs.getString(2)
						));
			}
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;	
	}	
	
	public static void main(String agrs[]) throws SQLException {
		Category list = new Category();
		List<Category_object> lisCategory = list.getCategory();
		
		for(Category_object c : lisCategory) {
			System.out.println(c.getId() + c.getName());
		}
	}
}
