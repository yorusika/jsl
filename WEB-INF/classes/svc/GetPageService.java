package svc;

import dao.HongDAO;
import vo.Book;

public class GetPageService {

	public Book getPage(String book_id) {
		HongDAO dao = new HongDAO(); 
		Book book_view=dao.getPage(book_id);
		
		return book_view;
	}

	public void hitUpdate(String book_id) {
		HongDAO dao = new HongDAO(); 
		dao.hitUpdate(book_id);
		
		return;
		
	}

	public int getBook_mark(String book_id, String id) {
		HongDAO dao = new HongDAO(); 
		int book_mark= dao.getBook_mark(book_id, id);
		return book_mark;
	}

}
