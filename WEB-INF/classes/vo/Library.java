package vo;

public class Library {
	private String id;
	private String book_id;
	
	public Library(String id, String book_id) {
		super();
		this.id = id;
		this.book_id = book_id;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	
}
