package HomeBook.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import HomeBook.model.Book;
import HomeBook.model.Category_object;
import JDBC_book.Category;
import JDBC_book.listBook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class Book_servlet extends HttpServlet{
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
			
			try {
				
				listBook list = new listBook();
				List<Book> listbook = list.getAllBook();
				Category li = new Category();
				List<Category_object> listCategory =li.getCategory();
				
				
				request.setAttribute("listCategory", listCategory);
				request.setAttribute("listBook", listbook);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
	 }
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	
}
