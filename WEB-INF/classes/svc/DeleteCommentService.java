package svc;

import dao.HongDAO;

public class DeleteCommentService {

	public int deleteComment(String comment) {
		HongDAO dao = new HongDAO();
		int result = dao.deleteComment(comment);
		return result;
	}
	
}
