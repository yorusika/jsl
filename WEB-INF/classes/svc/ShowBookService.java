package svc;


import dao.HongDAO;
import vo.Book;

public class ShowBookService {

	public Book getOneBook(String id, String book_id) {
		//만약 id가 null이라면 
		//DAO에서 getOneBook(String book_id)으로  book객체를 받아와서 반환한다.
		//만약 id가 null이 아니라면 
		//DAO에서 getOneBook(String id, String book_id)로 book객체를 받아와서 반환한다.
		HongDAO dao = new HongDAO();
		Book book = null;

		book= dao.getOneBook(id, book_id);
		
		return book;
		
	}
	
	public Book getOneBook(String book_id) {
		//만약 id가 null이라면 
		//DAO에서 getOneBook(String book_id)으로  book객체를 받아와서 반환한다.
		//만약 id가 null이 아니라면 
		//DAO에서 getOneBook(String id, String book_id)로 book객체를 받아와서 반환한다.
		HongDAO dao = new HongDAO();
		Book book = null;
		
		
		 book= dao.getOneBook(book_id);
		
		return book;
		
	}

}
