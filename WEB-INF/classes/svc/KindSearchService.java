package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Book;

public class KindSearchService {
	public ArrayList<Book> getKindSearchList(String kind, int startCount, int endCount) {
		// TODO Auto-generated method stub
		/*
		 * 1.  HongDAO의  getKindSearchList(kind) 메소드를 호출해서 ArrayList<Book>을 return한다.
		 * 2. 받아온 ArrayList<Book>을 return한다
		 */
		 HongDAO dao = new HongDAO();				 
		 ArrayList<Book> list = dao.getKindSearchList(kind, startCount, endCount);
		/*System.out.print("여기는 서비스의 리스트입니다. list.get(0).getName");
		System.out.println(list.get(0).getName());*/
		 
		 
		 
		return list;
	}

	public ArrayList<Book> getKindSearchList(String id, String kind) {
		 HongDAO dao = new HongDAO();				 
		 ArrayList<Book> list = dao.getKindSearchList(id, kind);
		 
		return list;
	}

	public int getTotalCount(String kind) {
		 HongDAO dao = new HongDAO();				 
		 int totalCount = dao.getTotalCount(kind);
		 
		return totalCount;
	}

	public ArrayList<Book> getKindSearchList(String id, String kind, int startCount, int endCount) {
		 HongDAO dao = new HongDAO();				 
		 ArrayList<Book> list = dao.getKindSearchList(id, kind, startCount, endCount);
		return list;
	}
	
}
