package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Book;

public class NewBookService {

	public ArrayList<Book> getNewBookList() {
		// DAO의 getNewBookList() 메소드를 호출해서 결과값을 그대로 반환한다.
		HongDAO dao = new HongDAO();
		ArrayList<Book> list = dao.getNewBookList();
		return list;
	}

}
