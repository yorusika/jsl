package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.KindSearchService;
import vo.Book;
import vo.Member;
import vo.Paging;


public class KindSearchAction implements Action { //책 장르 검색 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*1. request.getParameter로 kind 값을 받아온다.
		2. KindSearchService 의 getKindSearchList(kind)메서드를 호출해서  ArrayList<Book>을 받아온다.
		3. 가져온 ArrayList<Book>을 request.setAttribute로 searchList에 담는다. 
		4. kind 값이 lit이라면 '문학'장르
			 edu라면 '교육'장르
			 pol이라면 '정치'장르
			 eco라면 '경제'장르
			 kid라면 '어린이 장르
			 를 "searchWord"에 담는다. 
	  	5. 다음과 같은 액션 포워드를 반환한다: ActionForward("view/searchList.jsp", false)
	  	*/		
		
		//페이징에 대한 고찰
		//먼저 받아올건 currentPage 현재 페이지를 받아와야만 한다.
		 Paging paging=new Paging();
		 
		if(request.getParameter("currentPage")!=null) {
			paging.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}else {
			paging.setCurrentPage(1);
		}

		String kind = request.getParameter("kind");
		KindSearchService svc = new KindSearchService();
		ArrayList<Book> list;
		ActionForward af = null;	
		//도서 대여 여부를 확인하기 위해, 로그인 여부를 확인
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		int totalCount = svc.getTotalCount(kind);
		paging.setTotalCount(totalCount);
		
		paging.setBlockCount(4);
		paging.setBlockPage(5);
		paging.pagingAction();
		//페이징 세팅 완료.
		
		System.out.println("페이징 설정="+paging.toString());
		
		if(totalCount!=0) {
			if(member==null) {
				list=svc.getKindSearchList(kind, paging.getStartCount(), paging.getEndCount());
				
			}else {
				list=svc.getKindSearchList(member.getId(),kind, paging.getStartCount(), paging.getEndCount());
			}
			request.setAttribute("searchList", list);
		}
		

		
		
		
		

	
		
		
		

		
		request.setAttribute("paging", paging);
		request.setAttribute("kind", kind);
		
		if(kind.equals("lit")) {
			/*HttpSession session = request.getSession();
			request.setAttribute("searchList", list);*/
			System.out.println("무사히 문학 카테고리 진입.");
			af = new ActionForward("view/searchList.jsp", false);
			
		
			request.setAttribute("search", "文学");
		}else if(kind.equals("edu")) {
			/*HttpSession session = request.getSession();
			request.setAttribute("searchList", list);*/
			
		
			request.setAttribute("search", "教育");
			af = new ActionForward("view/literature.jsp", false);
			
			
		}else if(kind.equals("pol")) {
			af = new ActionForward("view/searchList.jsp", false);
			
			request.setAttribute("search", "政治");
		}else if(kind.equals("eco")) {
			af = new ActionForward("view/searchList.jsp", false);
			
			request.setAttribute("search", "経済");
		}else if(kind.equals("kid")){
			af = new ActionForward("view/searchList.jsp", false);
			
			request.setAttribute("search", "児童");
		}
		
		
	
		
		af = new ActionForward("view/literature.jsp", false);
		return af;
	}

}
