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
 * Servlet implementation class BookMarkServlet
 */
@WebServlet("/book_mark")
public class BookMarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String id=member.getId();
		String book_id = request.getParameter("book_id");
		int book_mark = Integer.parseInt(request.getParameter("book_mark"));
		HongDAO dao = new HongDAO();
		dao.book_mark(id, book_id, book_mark);
		
		System.out.println("id"+id+"book_id"+book_id+"book_mark"+book_mark);
		
		response.getWriter().write(""+book_mark);
	}

}
