package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Book;
import vo.Library;

public class LibraryService {


	public int getTotalCount(String id) {
		// TODO Auto-generated method stub
		HongDAO dao = new HongDAO();
		return dao.getLibraryTotal(id);
	}

	public ArrayList<Book> getLibraryList(String id, int startCount, int endCount) {
		System.out.println("LibraryService");
		HongDAO dao = new HongDAO();
		ArrayList<Book> list = dao.getLibraryList(id, startCount, endCount);
//		ArrayList<Library> library=dao.addLibrary(id, list);
		
		
		if(list==null)
			System.out.println("반환된 리스트는 널입니다.");
		return list;
	}

}
