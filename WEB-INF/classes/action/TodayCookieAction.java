package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import vo.Book;

public class TodayCookieAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Book>todayBookList=null;
		ActionForward af=null;
		String book_id;
		Book book=null;
		Cookie[] cookieArray = request.getCookies();
		if(cookieArray != null) {
			todayBookList=new ArrayList<Book>();
			for (int i=0; i<cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("hong")) {
					book=new Book();
					book_id=cookieArray[i].getName().substring(4);
					book.setBook_id(book_id);
					book.setImage_name(cookieArray[i].getValue());
					todayBookList.add(0, book);
					
				}
					
				
			}
		}
		
		request.setAttribute("todayBookList", todayBookList);
		
		af = new ActionForward("view/todayBook.jsp", false);
		return af;
		
	}

}
