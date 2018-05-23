package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.JoinService;
import vo.Member;


public class JoinAction implements Action {//회원가입 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. request.getParameter()로 id pass name을 받아서 멤버 객체를 생성한다.
		//2. JoinService의 insertMember(member)메소드를 호출해서 결과값을 boolean형으로 받아온다.
		//3. 받아온 boolean값이 false일 경우 request.setAttribute로 message에 "회원가입에 실패했습니다"라는 메세지를 담는다.
		//	 이 때 반환할 액션 포워드는 new ActionForward("view/joinForm.jsp",false);
		//4. 받아온 boolean값이 true일 경우 반환할 액션 포워드는 new ActionForward("index.html",true);
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		
		
		Member member= new Member(id, pass, name);
		JoinService svc = new JoinService();
		boolean newMember = svc.insertMember(member);
		HttpSession session = request.getSession();
		session.setAttribute("JoinUser", newMember);
		ActionForward af = null;

		if(newMember != false) {			
			af = new ActionForward("index.jsp", true);
		}else {			
			String message= "何らかのエラーが発生し、会員登録ができません。\\n後ほどもう一度実行してください。";
			request.setAttribute("message", message);
			System.out.println(message);
			af = new ActionForward("view/joinForm.jsp", false);
		}
		
		
		return af;
		
		
	}

}
