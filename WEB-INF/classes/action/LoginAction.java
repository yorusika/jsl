package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.LoginService;
import vo.Member;

public class LoginAction implements Action {// 로그인 액션

	private final String ADMIN_ID = "admin";
	private final String ADMIN_PW = "1234";
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		
		//1.request.getParameter로 id와 pass를 받아온다.
		//2. LoginService의 getLoginMember(id, pass)메소드를 를 호출해서 member 객체를 가져온다. 
		//4. 만약 member 객체가 null일 경우 request.setAttribute로 "message"에 "로그인에 실패했습니다."라는 문장을 넣어준다.
		//5. 만약 member 객체가 null이 아닐 경우 Session의 "member"에 member 객체를 담는다.  
		//6. 반환할 ActionForward는 ActionForward("index.jsp", false)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		ActionForward af = null;
		
		if(id.equals(ADMIN_ID) && pass.equals(ADMIN_PW)) {
			
			
			af = new ActionForward("/Hongwaka/view/insertBook.jsp", true);
			return af;
		}
		
		
		LoginService svc = new LoginService();
		Member member = svc.getLoginMember(id, pass);
	
		
		
		
		if(member != null) {

			HttpSession session = request.getSession();
			session.setAttribute("member", member);		
			af = new ActionForward("index.jsp", false);

			
		}else {
		
			request.setAttribute("message","ログインに失敗しました。\\n IDと暗証番号をもう一度ご確認お願いいたします。");
			System.out.println("로그인에 실패했습니다!");
			af = new ActionForward("view/loginForm.jsp", false);
			
		}
		
	
		return af;
	}

}
