package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import svc.RemoveshelfService;
import vo.Member;

public class RemoveshelfAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String id=member.getId();
		String book_id=request.getParameter("book_id");
		RemoveshelfService svc = new RemoveshelfService();
		int result = svc.removeshelf(id, book_id);
		
		
		if(result==0) {
			request.setAttribute("message", "何らかのエラーが発生し、返却機能がご利用できません。\\n　後ほどもう一度実行してください。");
		}
		
		af = new ActionForward("/Hongwaka/library.hong", true);
		
		return af;
	
	}

}
