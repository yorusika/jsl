package svc;

import java.sql.Timestamp;
import java.util.ArrayList;

import dao.HongDAO;

public class CommentService {

	public int getComment(String id, String book_id, String comment) {
		HongDAO dao = new HongDAO();
		return dao.getComment(id, book_id, comment);
	
	}

}
