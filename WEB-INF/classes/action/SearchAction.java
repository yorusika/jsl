package action;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import svc.SearchService;
import vo.Book;
import vo.Paging;


public class SearchAction implements Action {//제목 검색 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* 1. request.getParameter로 "search"에 담긴 값을 가져온다.
		 * 2. SearchService의 getSearchList(search)에서 ArrayList<Book>을 받아온다. 
		 * 3. 가져온 검색 결과를 request.setAttribute로 "searchList"에 담는다.
		 * 4. "search"에 담겨있던 값을 request.setAttribute로 "searchWord"에 담는다. 
		 * 5. 다음과 같은 액션 포워드를 반환한다: ActionForward("view/searchList.jsp", false)
		 */
		 Paging paging=new Paging();
		 if(request.getParameter("currentPage")!=null) {
				paging.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
			}else {
				paging.setCurrentPage(1);
			}
		 
		 ActionForward af = null;
		String search=request.getParameter("search");
		SearchService svc = new SearchService();
		int totalCount = svc.getSearchTotal(search);
		paging.setTotalCount(totalCount);
		
		paging.setBlockCount(5);
		paging.setBlockPage(5);
		paging.pagingAction();
		System.out.println("시작컨텐츠"+paging.getStartCount()+"끝나는 컨텐츠"+paging.getEndCount());
		
		
		ArrayList<Book> searchList = svc.getSearchList(search, paging.getStartCount(), paging.getEndCount());
		if(searchList==null) {
			request.setAttribute("message", "このキーワードの検索結果が見つかりませんでした。");
			af = new ActionForward("index.jsp", false);
		}else {
		
		request.setAttribute("search", search);
		request.setAttribute("paging", paging);
		request.setAttribute("searchList", searchList);
		
		af = new ActionForward("view/searchList.jsp", false);
		}
		return af;
	}

}
