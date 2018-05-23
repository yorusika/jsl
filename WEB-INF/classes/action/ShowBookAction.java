package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.ShowBookService;
import vo.Book;
import vo.Member;


public class ShowBookAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//1. request.getParameter을 통해 book_id를 받아온다.
		//2. session.getAttribute("member")로 멤버 객체를 받아온다.
		//3. ShowBookService의 getOneBook(id, book_id)을 통해 book객체를 받아온다.
		//4. 받아온 book 객체가 null일경우 request.setAttribute로 message에 "책 정보를 찾을 수 없습니다."를 담는다.
		//   그리고 ActionForward("index.jsp", false)를 반환한다.
		//5. 받아온 book 객체가 null이 아니라면 request.setAttribute로 book에 받아온 book객체를 담는다.
		//   그리고 ActionForward("view/showBook.jsp", false)를 반환한다.
		String book_id = request.getParameter("book_id");
		System.out.println("ShowBook, bookID : " + book_id);
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		ShowBookService svc = new ShowBookService();
		Book finding_book = null;
		
		 
		
		if(member==null) {
			
			finding_book = svc.getOneBook(book_id);
			
			
		}else {
			finding_book = svc.getOneBook(member.getId(), book_id);
			
		}
		
		
		

		

		
		ActionForward af = null;
		
		if(finding_book != null) {
			//책을 눌렀을 때 쿠키를 담는 작업
			Cookie todayBook = new Cookie("hong"+finding_book.getBook_id(), finding_book.getImage_name());
			todayBook.setMaxAge(60*60*24);
			response.addCookie(todayBook);
			
			request.setAttribute("finding_book", finding_book);
			af = new ActionForward("view/showBook.jsp", false);
		}else {
			request.setAttribute("message", "何らかのエラーが発生し、詳細情報が閲覧できません。\\n 後ほどもう一度実行してください。");
			af = new ActionForward("index.jsp", false);
		}
			return af;
	}

}
