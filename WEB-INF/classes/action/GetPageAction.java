package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.GetPageService;
import vo.Book;
import vo.Member;

public class GetPageAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String book_id=request.getParameter("book_id");
		System.out.println("책 번호:" + book_id);
		ActionForward af = null;
		
		GetPageService svc = new GetPageService();
		
		svc.hitUpdate(book_id);
		
		Book book_view=svc.getPage(book_id);
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String id=member.getId();
		
		int book_mark = svc.getBook_mark(book_id, id);
		book_view.setBook_mark(book_mark);
		
		
		if(book_view!=null) {
			if(book_view.getBook_folder()!=null&&book_view.getBook_page()!=0) {
				request.setAttribute("book_view", book_view);
				af=new ActionForward("/view/bookView.jsp", false);
				return af;
				
			}
			
		}
		
		request.setAttribute("message", "この本は詳細情報のみ提供いたしております。\\n閲覧機能は後ほど追加する予定です。");
		af=new ActionForward("/showBook.hong?book_id="+book_id, false);
		return af;
	}

}
