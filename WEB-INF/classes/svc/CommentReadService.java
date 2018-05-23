package svc;

import java.util.ArrayList;

import dao.HongDAO;
import vo.Comment;

public class CommentReadService {

	public ArrayList<Comment> getCommentList(String book_id, int startCount, int endCount) {		
		HongDAO dao = new HongDAO();
		ArrayList<Comment> list=dao.getCommentList(book_id, startCount, endCount);
		
		if(list==null)
			System.out.println("반환된 리스트는 없습니다");
		
		return list;
	}

	public int getTotalComment(String book_id) {
		HongDAO dao = new HongDAO();
		int result=dao.getTotalComment(book_id);
		
		
		
		return result;
	}

}
