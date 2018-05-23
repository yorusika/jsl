package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.HongDAO;

import vo.Member;

/**
 * Servlet implementation class RentServlet
 */
@WebServlet("/rent")
public class RentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String id=member.getId();
		String book_id = request.getParameter("book_id");
		HongDAO dao = new HongDAO();
		response.setContentType("text/html; charset=utf-8");
		
		int count=dao.countCheck(id);
		
		System.out.println("현재 빌린 책은"+count);
		
		if(count>=20) {
			response.getWriter().write("本は一人様当たり20冊までお貸しできます。\n"+id+"様は現在20冊の本をお借りになっております。");
			return;
		}
		
		
		int result=dao.rent(id, book_id);
		
		if(result>0) {
			System.out.println("빌렸습니다.");
		response.getWriter().write("success");
		return;
		}else {
			System.out.println("못 빌렸습니다.");
			response.getWriter().write("何らかのエラーが発生し、貸出機能がご利用できません。\n後ほどもう一度実行してください。");
			return;
		}
		
	}

}
