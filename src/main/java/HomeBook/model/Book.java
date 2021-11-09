package HomeBook.model;

public class Book {
	private int id;
	private String title;
	private String author;
	private int published_year;
	private int categry_id;
	
	public Book(int id, String title, String author, int published_year, int categry_id) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.published_year = published_year;
		this.categry_id = categry_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}

	public int getCategry_id() {
		return categry_id;
	}

	public void setCategry_id(int categry_id) {
		this.categry_id = categry_id;
	}
	
	
	
	
}
