package svc;

import dao.HongDAO;

public class BookDeleteService {
	
	public int bookDelete(String book_id) {
		int DelCk = new HongDAO().deleteBook(book_id);
		
		return DelCk;
	}

}
