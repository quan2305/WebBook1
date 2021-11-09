package JDBC_book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import HomeBook.model.Book;



public class listBook {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Book> getAllBook() throws SQLException {
		List<Book> list = new ArrayList<>();
		String query = "select * from `web_book`.`book` " 
				;
		
		try {
			new JDBCConnector();
			conn = JDBCConnector.getJDBCConnector();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5)
						));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	public List<Book> getListBook(String quer) throws SQLException {
		List<Book> list = new ArrayList<>();
		String query = quer;
		
		try {
			new JDBCConnector();
			conn = JDBCConnector.getJDBCConnector();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5)
						));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Book> findBook(String title) throws SQLException{
		List<Book> list = new ArrayList<>();
		String query = "select * from `web_book`.`book`" +
				"where `web_book`.`book`.`title` like " + "'" + "%" + title + "%" + "'";
		
		try {
			new JDBCConnector();
			conn = JDBCConnector.getJDBCConnector();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Book(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5)
						));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String agrs[]) throws SQLException {
		listBook list = new listBook();
		List<Book> listbook = list.getAllBook();
		
		for(Book b : listbook) {
			System.out.println(b.getId() + b.getTitle() + b.getAuthor() + b.getPublished_year() + b.getCategry_id());
		}
	}
}