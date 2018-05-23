package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.ShowBookService;
import vo.Book;
import vo.Member;

public class OneBookSearchAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String book_id = request.getParameter("book_id");
		System.out.println("ShowBook, bookID : " + book_id);
	

		
		ShowBookService svc = new ShowBookService();
		Book searchBook = null;
		

		searchBook = svc.getOneBook(book_id);

		
		ActionForward af = null;
		
		if(searchBook != null) {
			//책을 눌렀을 때 쿠키를 담는 작업
			
			
			request.setAttribute("searchBook", searchBook);
			af = new ActionForward("./modifyBook.jsp", false);
		}else {
			request.setAttribute("message", "何らかのエラーが発生し、本の修正ができません。\\n 後ほどもう一度実行してください。");
			request.setAttribute("search", request.getParameter("search"));
			request.setAttribute("action", "modify");
			
			af = new ActionForward("searchBook.hong?action=delete", false);
		}
			return af;
	}

}
