package HomeBook.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import HomeBook.model.Book;
import HomeBook.model.Category_object;
import HomeBook.model.History;
import HomeBook.model.Item;
import JDBC_book.Category;
import JDBC_book.listBook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionString = req.getParameter("action");
		
		if(actionString == null) {
			doGet_DisplayCart(req, resp);
		} else {
			if(actionString.equalsIgnoreCase("buy")) {
				doGet_Buy(req, resp);
			} else if(actionString.equalsIgnoreCase("return")) {
				doGet_Return(req, resp);
			}
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			Category li = new Category();
			List<Category_object> listCategory;
			listCategory = li.getCategory();
			HttpSession session = req.getSession();
			
			if(session.getAttribute("cart") == null) {
				List<Item> cart = new ArrayList<Item>();
				session.setAttribute("cart", cart);
			}
			
			req.setAttribute("listCategory1", listCategory);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void doGet_DisplayCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doGet_Buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		try {
			listBook list = new listBook();
			List<Book> listbook = list.getAllBook();
			Category li = new Category();
			List<Category_object> listCategory =li.getCategory();
			
			
			if(session.getAttribute("history") == null) {
				List<History> histoyHistories = new ArrayList<History>();
				//int id_user = Integer.parseInt((String)session.getAttribute("user"));
				int id_user = 1;
				int id_book = Integer.parseInt((String)req.getParameter("id"));
				
				LocalDate myObj = LocalDate.now(); 
				String borrow_date = myObj.toString();
				histoyHistories.add(new History(id_user, id_book, borrow_date, null));
				session.setAttribute("history", histoyHistories);
			} else {
				List<History> histoyHistories = (List<History>) session.getAttribute("history");
				int id_user = 1;
				int id_book = Integer.parseInt((String)req.getParameter("id"));
				
				LocalDate myObj = LocalDate.now(); 
				String borrow_date = myObj.toString();
				histoyHistories.add(new History(id_user, id_book, borrow_date, null));
				session.setAttribute("history", histoyHistories);
			}

			if(session.getAttribute("cart") == null) {
				List<Item> cart = new ArrayList<Item>();
				cart.add(new Item(findBookByID(req.getParameter("id"), listbook), 1));
				session.setAttribute("cart", cart);
			} else {
				List<Item> cart = (List<Item>)session.getAttribute("cart");
				int index = isExisting(req.getParameter("id"), cart);
				
				if(index == -1){
					cart.add(new Item(findBookByID(req.getParameter("id"), listbook), 1));	
				} else {
					int quantity = cart.get(index).getQuantity() + 1;
					cart.get(index).setQuantity(quantity);
				}
				
				
				session.setAttribute("cart", cart);
			}
			
			req.setAttribute("listCategory1", listCategory);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
	
			
			//resp.sendRedirect("cart.jsp" );
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet_Return(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try {

			HttpSession session = req.getSession();
			List<Item> list = (List<Item>)session.getAttribute("cart");
			Category li = new Category();
			List<Category_object> listCategory =li.getCategory();
			
			
			
			List<History> histories = (List<History>) session.getAttribute("history");
			
			if(histories != null) {
				
				for(History his : histories) {
					int id_book = Integer.parseInt(req.getParameter("id")); 
					
					if(his.getId_book() == id_book) {
						LocalDate myDate = LocalDate.now();
						String return_date = myDate.toString();
						
						his.setReturn_date(return_date);
					}
				}
				
				session.setAttribute("history", histories);
			}
			
			
			int index = isExisting(req.getParameter("id"), list);
			list.remove(index);
			session.setAttribute("cart", list);
			req.setAttribute("listCategory1", listCategory);
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	protected Book findBookByID(String id, List<Book> list) {
		int idBook = Integer.parseInt(id);
		for(Book book : list) {
			if(book.getId() == idBook) {
				return book;
			}
		}
		return null;
	}
	
	private int isExisting(String id, List<Item> cart) {
		int idBook = Integer.parseInt(id);
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getBook().getId() == idBook) {
				return i;
			}
		}
		return -1;
	}

}
