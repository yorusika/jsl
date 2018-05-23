package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.ActionForward;
import svc.BookModifyService;
import vo.Book;

public class BookModifyAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		String savePath = request.getServletContext().getRealPath("/book_images");
		int sizeLimit = 1024 * 1024 * 15;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, encoding, new DefaultFileRenamePolicy());
		String name = multi.getParameter("name");
		String kind = multi.getParameter("kind");
		
		String image_name = multi.getFilesystemName("image_name");
		if(image_name==null || image_name=="") {
			image_name=multi.getParameter("origin_name");
		}
		
		System.out.println("이미지 이름 : " + image_name);
		String author = multi.getParameter("author");
		String list = multi.getParameter("list");
		String introduce = multi.getParameter("introduce");
		String book_id = multi.getParameter("book_id");
		String author_introduce = multi.getParameter("author_introduce");
		String book_folder = multi.getParameter("book_folder");
		int book_page = Integer.parseInt(multi.getParameter("book_page"));
		
		Book thisBook = new Book(book_id, name, kind, image_name, author, list, introduce, author_introduce);
		thisBook.setBook_folder(book_folder);
		thisBook.setBook_page(book_page);
		int modiCk = new BookModifyService().bookModify(thisBook);
		
		if(modiCk > 0) {
			request.setAttribute("thisBook", thisBook);
			request.setAttribute("message", "本の修正が完了しました。");
		} else {
			request.setAttribute("message", "何らかのエラーが発生し、本の修正ができません。\\n後ほどもう一度実行してください。");
		}
		af = new ActionForward("/view/modifyBook.jsp", false);
		
		return af;
	}

}
