package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.ActionForward;
import svc.BookAddService;
import vo.Book;

public class BookAddAction implements Action {

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
		
//		이미지 이름!!! 이미지 업로드 확인!! 
		System.out.println("이미지 이름 : " + image_name);
		String author = multi.getParameter("author");
		String list = multi.getParameter("list");
		String introduce = multi.getParameter("introduce");
		String author_introduce = multi.getParameter("author_introduce");
		String book_folder = multi.getParameter("book_folder");
		String book_page=multi.getParameter("book_page");
		
		Book newBook = new Book(null, name, 0, kind, image_name, author, list, introduce, author_introduce);
		newBook.setBook_folder(book_folder);
		
		
		
		if(book_page!=null && book_page.length()!=0) {
			newBook.setBook_page(Integer.parseInt(book_page));	
		}
		
		

		int addCk = new BookAddService().bookAdd(newBook);
		
		if(addCk > 0) {
			request.setAttribute("message", "本の登録が完了しました。");
		} else {
			request.setAttribute("message", "何らかのエラーが発生し、本の登録ができません。\\n後ほどもう一度実行してください。");
		}
		af = new ActionForward("/view/insertBook.jsp", false);
		
		return af;
	}

}
