package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Book;

public class BookSearchService {
	
	public ArrayList<Book> searchBook(String search) {
		ArrayList<Book> bookList = null;
		bookList = new HongDAO().searchBook(search);
		
		return bookList;
		
	}

}
