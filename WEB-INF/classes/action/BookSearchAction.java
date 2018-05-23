package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import svc.BookSearchService;
import vo.Book;

public class BookSearchAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		String search = request.getParameter("search");
		String action = request.getParameter("action");
		
		ArrayList<Book> searchBooks = null;
		
		searchBooks = new BookSearchService().searchBook(search);
		
		if(searchBooks != null) {
			request.setAttribute("search", search);
			request.setAttribute("searchBooks", searchBooks);
			
			af = new ActionForward("/view/adminSearchList.jsp", false);
			/* if(action.equals("modify")) {
				request.setAttribute("action", action);
				af = new ActionForward("/view/modifyBook.jsp", false);				
			} else {
				af = new ActionForward("/view/deleteBook.jsp", false);				
			}*/
		}else {
			request.setAttribute("message", "このキーワードの検索結果が見つかりません。");
			if(action.equals("modify")) {
			
			af = new ActionForward("/view/modifyBook.jsp", false);
			}else {
			af = new ActionForward("/view/deleteBook.jsp", false);
			}
		}
		
		
		
		return af;
	}

}
