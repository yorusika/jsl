package svc;

import dao.HongDAO;
import vo.Book;

public class BookAddService {
	
	public int bookAdd(Book newBook) {
		int addCk = new HongDAO().addBook(newBook);
		
		return addCk;
		
	}

}
