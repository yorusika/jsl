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
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/return_book")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
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
		int result=dao.removeshelf(id, book_id);
		if(result>0) {
		response.getWriter().write("success");
		}else {
			response.getWriter().write("何らかのエラーが発生し、返却機能がご利用できません。\n後ほどもう一度実行してください。");	
		}
		
	}

}
