package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.CommentService;
import vo.Member;

public class CommentAddAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
//		Comment comment = (Comment)session.getAttribute("comment");
		String comment=request.getParameter("comment");
		String book_id=request.getParameter("book_id");
		Member member=(Member)session.getAttribute("member");
		System.out.println("로그인된 아이디:"+member.getId());
		System.out.println("댓글 내용 :"+comment);
		System.out.println("book_id:"+book_id);
		
		CommentService svc = new CommentService();
//		ArrayList<Comment> list = svc.getComment(session.getId(), book_id, comment);
		int result=svc.getComment(member.getId(), book_id, comment);
//		request.setAttribute("getComment", list);
		
		ActionForward af = null;
		
		if(result != 0) {
			
			af = new ActionForward("showBook.hong?book_id="+book_id,false);	// 어디로 가는지 지정해주세요
		}else {
			request.setAttribute("message", "何らかのエラーが発生し、コメント登録に失敗しました。\n後ほどもう一度実行してください。");
		}
		return af;
	}

}
