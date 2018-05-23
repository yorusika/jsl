package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import controller.ActionForward;

import svc.IdCheckService;

public class IdCheckAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		IdCheckService svc = new IdCheckService();
		int result = svc.IdCheck(id);
		if(id=="admin") {
			result=0;
			
		}
		System.out.println("IDcheckAciton, id:"+id);
		System.out.println("result:"+result);
		/*
		 * HongDAO hdao=HongDAO.getInstance(); int result=hdao.registerCheck(id);
		 */

		ActionForward af = null;

		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		af = new ActionForward("view/idcheck.jsp", false);
//		af = new ActionForward("home.jsp", true);

		return af;

	}

}
