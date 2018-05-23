package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import svc.DeleteCommentService;

public class DeleteCommentAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("delete액션으로 곧바로 넘어오기느 하는가..?");
		
		String comment_id = request.getParameter("comment_id");
		System.out.println("comment_id는 제대로 받아져 왔는가?="+comment_id);
		DeleteCommentService svc = new DeleteCommentService();
		int result = svc.deleteComment(comment_id);
		String book_id=request.getParameter("book_id");
		
		ActionForward af = null;
		if(result == -1) {
			request.setAttribute("message", "何らかのエラーが発生し、コメントの削除に失敗しました。\\n後ほどもう一度実行してください。");
		}else {
			request.setAttribute("message", "コメントの削除を完了しました。");
		}
//		af=new ActionForward("view/commendRead.jsp",false);
//		af = new ActionForward("showBook.hong?book_id="+comment_id,false);	// 어디로 가는지 지정해주세요
		af = new ActionForward("showBook.hong?comment_id="+comment_id+"&&book_id"+book_id,false);
		
		return af;
	}

	
}
