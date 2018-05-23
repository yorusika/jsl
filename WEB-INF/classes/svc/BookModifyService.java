package svc;

import dao.HongDAO;
import vo.Book;

public class BookModifyService {
	
	public int bookModify(Book thisBook) {
		int modiCk = new HongDAO().modifyBook(thisBook);
		
		return modiCk;
	}

}
