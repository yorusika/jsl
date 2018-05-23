package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import svc.BookDeleteService;

public class BookDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		String book_id = request.getParameter("book_id");
		int delCk = new BookDeleteService().bookDelete(book_id);
		request.setAttribute("search", request.getParameter("search"));
		request.setAttribute("action", "delete");
		
		if(delCk > 0) {
			request.setAttribute("message", "本の削除が完了しました。");
			af = new ActionForward("deleteBook.jsp", false);
		} else {
			request.setAttribute("message", "何らかのエラーが発生し、本の削除ができません。\\n後ほどもう一度実行してください。");
			af = new ActionForward("searchBook.hong?action=delete", false);
		}
		
		
		return af;
	}

}
