package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Book;

public class SearchService {

	public ArrayList<Book> getSearchList(String search, int stratCount, int endCount) {
		// TODO Auto-generated method stub
		/*
		 * 1.  HongDAO의  getSearchList(search) 메소드를 호출해서 ArrayList<Book>을 return한다.
		 * 2. 받아온 ArrayList<Book>을 return한다
		 */
		 HongDAO dao = new HongDAO();
		 ArrayList<Book> list = dao.getSearchList(search, stratCount, endCount);
		
		 
		 
		return list;
	}

	public int getSearchTotal(String search) {
		HongDAO dao = new HongDAO();
		return dao.getSearchTotal(search);
	}
	
}
