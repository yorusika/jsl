package svc;

import dao.HongDAO;

public class RemoveshelfService {
	public int removeshelf(String id, String book_id) {
		
		HongDAO dao = new HongDAO();
		int result = dao.removeshelf(id, book_id);
		
		return result;
		
	}
}
