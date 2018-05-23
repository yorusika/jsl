package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.LibraryService;
import vo.Member;
import vo.Paging;
import vo.Book;
import vo.Library;

public class LibraryAction implements Action {// 내 서재 보기 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 *
		 1. session.getAttribute 로 member을 받아온다. 
		 2. member.getId로 id를 받아온다.
		 3. LibraryService의 getLibraryList(id)메소드를 호출해서  ArrayList<Book>을 받아온다. 
		 4. request.setAttribute로 libraryList에 ArrayList<Book>을 담는다.
		 5. 반환할 엑션 Forward는 ActionForward("view/library.jsp", false);
		 */				
		Paging paging=new Paging();
		 
		if(request.getParameter("currentPage")!=null) {
			paging.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}else {
			paging.setCurrentPage(1);
		}
		
		ArrayList<Book> list = null;
		
		HttpSession session = request.getSession();		
		Member member = (Member) session.getAttribute("member");		
		LibraryService svc = new LibraryService();			
		int TotalCount = svc.getTotalCount(member.getId());
		paging.setTotalCount(TotalCount);
		paging.setBlockCount(5);
		paging.setBlockPage(5);
		paging.pagingAction();
		
		ActionForward af = null;
		
		if(TotalCount!=0) {
		list = svc.getLibraryList(member.getId(), paging.getStartCount(), paging.getEndCount());
		af = new ActionForward("view/bookshelf.jsp", false);
		}else {
			//request.setAttribute("message", "本棚が空いております。");
			af = new ActionForward("view/bookshelf.jsp", false);
		}
		request.setAttribute("paging", paging);
		request.setAttribute("libraryList", list);

		
		return af;
	}

}
