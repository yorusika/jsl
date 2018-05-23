package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BookAddAction;
import action.BookDeleteAction;
import action.BookModifyAction;
import action.BookSearchAction;
import action.CommentAddAction;
import action.CommentReadAction;
import action.DeleteCommentAction;
import action.GetPageAction;

import action.JoinAction;
import action.KindSearchAction;
import action.LibraryAction;
import action.LogOutAction;
import action.LoginAction;
import action.NewBookListAction;
import action.OneBookSearchAction;
import action.RankingAction;
import action.RemoveAction;
import action.SearchAction;
import action.ShowBookAction;
import action.TodayCookieAction;
import action.RemoveshelfAction;
import action.IdCheckAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.hong")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		//요청파악
		String requestURI = request.getRequestURI();
		String contextPath= request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		Action action = null;
		ActionForward af = null;
		
	
		if(command.startsWith("/view")) { // '/view'가 command에 포함 되지 않도록 처리 	
			command=command.substring(5);
		}
		
		System.out.println("입력된 커멘드: "+command); //제대로 커멘드가 입력되었는지 확인
		
		
		
		if(command.equals("/search.hong")) {		//제목 검색
			action=new SearchAction();
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		if(command.equals("/kindSearch.hong")) {//장르 검색
			action=new KindSearchAction();
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(command.equals("/login.hong")) { //로그인 기능
			action = new LoginAction();
			try {
				af = action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/join.hong")) {  //회원가입
			
			action = new JoinAction();
			
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		

		
		if(command.equals("/logout.hong")) { //로그아웃 기능
			action = new LogOutAction();
			try {
				af = action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/idCheck.hong")) { 
			action = new IdCheckAction();
			try {
				af = action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/remove.hong")) { //회원 탈퇴
			action = new RemoveAction();
			
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(command.equals("/library.hong")) { //내서재
			action = new LibraryAction();
			
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/shelfDelete.hong")) { //내서재 책 삭제
			action = new RemoveshelfAction();
			
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		


		
		if(command.equals("/newBookList.hong")) { //새책 목록
			action = new NewBookListAction();
			
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		
		if(command.equals("/rankingList.hong")) { //hit수 랭킹목록
			action = new RankingAction();
			try {
				af=action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		


		if(command.equals("/showBook.hong")) { //책 상세정보 기능
			action = new ShowBookAction();
			try {
				af = action.excute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		
		if(command.equals("/addBook.hong")) { //책 등록
			action = new BookAddAction();
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/searchBook.hong")) { //책 검색
			action = new BookSearchAction();
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/modifyBook.hong")) { //책 수정
			action = new BookModifyAction();
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/deleteBook.hong")) { //책 삭제
			action = new BookDeleteAction();
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/getPages.hong")) {
			action = new GetPageAction();
			
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/todayList.hong")) {
			action = new TodayCookieAction();
			
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		
		if(command.equals("/commendAdd.hong")) {
			action = new CommentAddAction();
			
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/commendRead.hong")) {
			action = new CommentReadAction();
			
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/commendDelete.hong")) {
			action = new DeleteCommentAction();
			
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/oneBookSearch.hong")) {
			action = new OneBookSearchAction();
			
			try {
				af = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(af.isRedirec()) {
		response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher dsp = request.getRequestDispatcher(af.getPath());
			dsp.forward(request, response);
		}
		
		
	}
		
	

	
		
}
