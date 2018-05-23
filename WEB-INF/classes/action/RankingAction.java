package action;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import svc.RankingService;
import vo.Book;

public class RankingAction implements Action {//인기 도서 받아오기 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		/*
		 1. RankinService 의 getRankinBookList() 메소드를 호출한다.
		 2. 결과값을 ArrayList<Book> 형태로 반환받는다.
		 3. 결과값을 request.setAttribute로 rankingList라는 이름으로 담는다.
		 4. 반환할 액션 포워드는 ActionForward("view/rankingListShow.jsp", false)	 
		*/
		RankingService svc = new RankingService();
		ArrayList<Book> list = null;
		list = svc.getRankinBookList();
		request.setAttribute("rankingList", list);
		ActionForward af = null;
		

			af = new ActionForward("view/rankingListShow.jsp", false);

		
		return af;
	}

}
