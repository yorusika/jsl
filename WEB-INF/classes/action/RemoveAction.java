package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.RemoveService;
import vo.Member;




public class RemoveAction implements Action {// 회원 탈퇴 액션

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//1.session.getAttribute로 member 객체를 받아온다.
		//2. member.getId()로 id값을 받아온다.
		//3. RemoveService 의  removeMember(id) 메소드를 호출해서 
		//   성공여부를 boolean으로 받아온다.
		//4. 삭제 성공시 session.removeAttribute(member)로 세션값을 날려준다.
		//5. 삭제 실패스 request.setAttribute()로 message에 "회원탈퇴에 실패했습니다." 라는 메세지를 담아준다.
		//6. 반환할 액션 포워드는ActionForward("index.jsp", false)
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		RemoveService svc = new RemoveService();
		boolean ischeck = svc.removeMember(member.getId());
		ActionForward af = null;
		
		if(ischeck) {
			session.invalidate();
			af = new ActionForward("index.jsp", false);
		}else {
			request.setAttribute("message", "何らかのエラーが発生し、退会機能がご利用できません。\\n　後ほどもう一度実行してください。");
			af = new ActionForward("index.jsp", false);
		}

		
		return af;
	}

}
