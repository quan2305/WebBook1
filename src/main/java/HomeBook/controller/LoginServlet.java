package HomeBook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.connector.Response;

import HomeBook.model.User;
import JDBC_book.listUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
//			RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("/FormLogin.jsp");
//			dispatcher.include(req, resp);
			resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String user = (String)req.getParameter("user");
			String pass = (String)req.getParameter("password");
			
			
			listUser list = new listUser();
			List<User> list_user;
			
			list_user = list.getUser(user);
			
			User personUser;
			
			if(list_user.isEmpty()){
				personUser = null;
			} else {
				personUser = list_user.get(0);
			}
			
			
			
			if(personUser != null && Password.checkPassword(pass, personUser.getPassword())) {
				HttpSession session = req.getSession(true);
				session.setAttribute("user", personUser);
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FormLogin.jsp");
				dispatcher.forward(req, resp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
}
