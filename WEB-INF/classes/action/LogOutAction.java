package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import vo.Member;

public class LogOutAction implements Action {// 로그아웃 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//1.session.removeAttribute로 member 속성을 지운다.
		//2.반환할 액션 포워드는  ActionForward("index.jsp", false)
		HttpSession session = request.getSession();		
//		Member member = session.removeAttribute("loginUser");
		
		session.removeAttribute("member");
		
		
		ActionForward af = null;
		
		
		/*if(member != null) {
		af = new ActionForward("index.jsp", false);
		}
		return af;*/
		if(af == null) {
			af = new ActionForward("index.jsp", false);
		}
		return af;
	}

}
