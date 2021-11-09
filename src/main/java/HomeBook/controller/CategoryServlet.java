package HomeBook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

//import com.sun.org.apache.xml.internal.serialize.Printer;

import HomeBook.model.Book;
import HomeBook.model.Category_object;
import JDBC_book.Category;
import JDBC_book.JDBCConnector;
import JDBC_book.listBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet{
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		 response.setContentType("text/html");
		 
		 PrintWriter writer = response.getWriter();
		;
		 
			String value = (String)request.getParameter("item");
			writer.print(value);
			
			String query = "select * from `web_book`.`book`" 
					 + "where `web_book`.`book`.`category_id` = " + value;
			writer.print(query);
			 
			listBook list = new listBook();
			List<Book> listbook = list.getListBook(query);
			
			Category li = new Category();
			List<Category_object> listCategory =li.getCategory();
				
			request.setAttribute("listCategory1", listCategory);
			request.setAttribute("listBook", listbook);
			request.getRequestDispatcher("index1.jsp").forward(request, response);	
			 
		 
	}
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
