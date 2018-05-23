package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.CommentReadService;
import vo.Comment;
import vo.Paging;

public class CommentReadAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//페이징에 대한 고찰
		//먼저 받아올건 currentPage 현재 페이지를 받아와야만 한다.
		 Paging paging=new Paging();
		 
		if(request.getParameter("currentPage")!=null) {
			paging.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		}else {
			paging.setCurrentPage(1);
		}
		

		/*HttpSession session=request.getSession();
		Comment comment=(Comment)session.getAttribute("Comment");*/
		
		String book_id=request.getParameter("book_id");
		System.out.println("commendRead, book_id:"+book_id);
		CommentReadService svc=new CommentReadService();
		
		//총 게시글 수 셋팅
		int totalCount = svc.getTotalComment(book_id);
		paging.setTotalCount(totalCount);
		
		paging.setBlockCount(5);
		paging.setBlockPage(5);
		paging.pagingAction();
		
		System.out.println("페이징 설정="+paging.toString());
		
		
		ArrayList<Comment> list=svc.getCommentList(book_id, paging.getStartCount(), paging.getEndCount());
		request.setAttribute("commendList", list);
		request.setAttribute("book_id", book_id);
		
		request.setAttribute("paging", paging);
		
		ActionForward af=null;
		
		if(list!=null){
			af=new ActionForward("view/commendRead.jsp",false);
			
		}else{
			System.out.println("오 맙소사 미친거아냐 왜 암것도 없어");
			af=new ActionForward("view/commendRead.jsp",false);
		}
		
		
		return af;
	}

}
