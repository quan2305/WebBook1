package HomeBook.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import HomeBook.model.User;
import JDBC_book.listUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String user = req.getParameter("email");
			String pass = req.getParameter("psw");
			
			listUser userPerson =  new listUser();
			userPerson.addUser(user, pass);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FormLogin.jsp");
			dispatcher.forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
