package action;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import svc.NewBookService;
import vo.Book;


public class NewBookListAction implements Action {//신간 목록 받아오기 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 1. NewBookService 의 getNewBookList(); 메소드를 호출한다.
		 2. 결과값을 ArrayList<Book> 형태로 반환받는다.
		 3. 결과값을 request.setAttribute로 newBookList라는 이름으로 담는다.
		 4. 반환할 액션 포워드는 new ActionForward("view/newBookListShow.jsp", false)	 
		*/
		
		NewBookService svc = new NewBookService();
		ArrayList<Book> list = new ArrayList<Book>(); 
		list = svc.getNewBookList();
		request.setAttribute("newBookList", list);
		ActionForward af = null;
		
	
		

		af = new ActionForward("/view/newBookListShow.jsp", false);

		
		
		return af;
	}

}
