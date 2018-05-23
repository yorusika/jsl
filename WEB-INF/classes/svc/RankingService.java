package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Book;

public class RankingService {

	public ArrayList<Book> getRankinBookList() {
		// DAO의 getRankinBookList()를 호출해서 ArrayList<Book>를 반환한다.
		HongDAO dao = new HongDAO();
		ArrayList<Book> list = dao.getRankinBookList();
		return list;
	}

}
