package HomeBook.model;

public class History {

	private int id_user;
	private int id_book;
	private String borrow_date;
	private String return_date;
	
	public History(int id_user, int id_book, String borrow_date, String return_date) {
		this.id_user = id_user;
		this.id_book = id_book;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
	
	
	
}
